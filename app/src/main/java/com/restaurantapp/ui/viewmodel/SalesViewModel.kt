package com.restaurantapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restaurantapp.data.entity.SalesData
import com.restaurantapp.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.math.max

@HiltViewModel
class SalesViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    // 🔹 State Flows for Live Compose Updates
    private val _salesList = MutableStateFlow<List<SalesData>>(emptyList())
    val salesList: StateFlow<List<SalesData>> = _salesList

    private val _totalSales = MutableStateFlow(0.0)
    val totalSales: StateFlow<Double> = _totalSales

    private val _totalProfit = MutableStateFlow(0.0)
    val totalProfit: StateFlow<Double> = _totalProfit

    private val _selectedRange = MutableStateFlow(2) // default 1 Month
    val selectedRange: StateFlow<Int> = _selectedRange

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

    init {
        // Load initial range (1 Month default)
        loadForRange(2)
    }

    /**
     * 🔸 Load sales, profit and total stats for selected range.
     * Range index: 0 -> 1D | 1 -> 1W | 2 -> 1M | 3 -> 1Y
     */
    fun loadForRange(rangeIndex: Int) {
        _selectedRange.value = rangeIndex
        val (startMillis, endMillis) = computeRangeMillis(rangeIndex)

        viewModelScope.launch {
            val start = dateFormat.format(Date(startMillis))
            val end = dateFormat.format(Date(endMillis))

            // Parallel data loading for performance
            launch {
                repository.getSalesDataByDateRange(start, end).collect { data ->
                    _salesList.value = data
                }
            }

            launch {
                try {
                    _totalSales.value = repository.getTotalSalesByDateRange(start, end)
                } catch (e: Exception) {
                    _totalSales.value = _salesList.value.sumOf { it.totalSales }
                }
            }

            launch {
                try {
                    _totalProfit.value = repository.getTotalProfitByDateRange(start, end)
                } catch (e: Exception) {
                    _totalProfit.value = _salesList.value.sumOf { it.totalProfit }
                }
            }
        }
    }

    /**
     * 🔸 Compute range time (in millis) based on user selection.
     */
    private fun computeRangeMillis(rangeIndex: Int): Pair<Long, Long> {
        val cal = Calendar.getInstance()
        val end = cal.timeInMillis
        when (rangeIndex) {
            0 -> cal.add(Calendar.DAY_OF_YEAR, -1)   // 1D
            1 -> cal.add(Calendar.DAY_OF_YEAR, -7)   // 1W
            2 -> cal.add(Calendar.DAY_OF_YEAR, -30)  // 1M
            3 -> cal.add(Calendar.DAY_OF_YEAR, -365) // 1Y
            else -> cal.add(Calendar.DAY_OF_YEAR, -30)
        }
        val start = cal.timeInMillis
        return Pair(max(0L, start), max(start + 1, end))
    }

    /**
     * 🔸 Load all records (optional, for admin dashboard or reports)
     */
    fun loadAllSales() {
        viewModelScope.launch {
            repository.getAllSalesData().collect { data ->
                _salesList.value = data
                _totalSales.value = data.sumOf { it.totalSales }
                _totalProfit.value = data.sumOf { it.totalProfit }
            }
        }
    }
}

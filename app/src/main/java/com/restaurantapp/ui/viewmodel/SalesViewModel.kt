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

@HiltViewModel
class SalesViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _salesList = MutableStateFlow<List<SalesData>>(emptyList())
    val salesList: StateFlow<List<SalesData>> = _salesList

    private val _totalSales = MutableStateFlow(0.0)
    val totalSales: StateFlow<Double> = _totalSales

    private val _totalProfit = MutableStateFlow(0.0)
    val totalProfit: StateFlow<Double> = _totalProfit

    init {
        loadAllSales()
    }

    fun loadAllSales() {
        viewModelScope.launch {
            repository.getAllSalesData().collect { data ->
                _salesList.value = data
            }
        }
    }


    fun loadSalesByDateRange(startMillis: Long, endMillis: Long) {
        viewModelScope.launch {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val start = format.format(Date(startMillis))
            val end = format.format(Date(endMillis))
            repository.getSalesDataByDateRange(start, end).collect { data ->
                _salesList.value = data
            }
        }
    }

    fun loadTotalSales(startMillis: Long, endMillis: Long) {
        viewModelScope.launch {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val start = format.format(Date(startMillis))
            val end = format.format(Date(endMillis))
            _totalSales.value = repository.getTotalSalesByDateRange(start, end)
        }
    }

    fun loadTotalProfit(startMillis: Long, endMillis: Long) {
        viewModelScope.launch {
            val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val start = format.format(Date(startMillis))
            val end = format.format(Date(endMillis))
            _totalProfit.value = repository.getTotalProfitByDateRange(start, end)
        }
    }
}

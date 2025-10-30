package com.restaurantapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restaurantapp.data.entity.RestaurantTable
import com.restaurantapp.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdminTableViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _tables = MutableStateFlow<List<RestaurantTable>>(emptyList())
    val tables: StateFlow<List<RestaurantTable>> = _tables

    init {
        loadTables()
    }

    private fun loadTables() {
        viewModelScope.launch {
            repository.getAllTables().collect { list ->
                _tables.value = list
            }
        }
    }

    fun addTable(table: RestaurantTable) {
        viewModelScope.launch {
            repository.insertTable(table)
            loadTables()
        }
    }

    fun updateTable(table: RestaurantTable) {
        viewModelScope.launch {
            repository.updateTable(table)
            loadTables()
        }
    }

    fun deleteTable(table: RestaurantTable) {
        viewModelScope.launch {
            repository.deleteTable(table)
            loadTables()
        }
    }
}

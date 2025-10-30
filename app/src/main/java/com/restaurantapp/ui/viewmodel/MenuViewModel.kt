package com.restaurantapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restaurantapp.data.entity.MenuItem
import com.restaurantapp.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _menuItems = MutableStateFlow<List<MenuItem>>(emptyList())
    val menuItems: StateFlow<List<MenuItem>> = _menuItems.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedCategory = MutableStateFlow("All")
    val selectedCategory: StateFlow<String> = _selectedCategory.asStateFlow()

    init {
        loadMenuItems()
    }

    fun loadMenuItems() {
        viewModelScope.launch {
            repository.getAllMenuItems().collect { items ->
                _menuItems.value = filterMenu(items)
            }
        }
    }

    fun searchMenuItems(query: String) {
        _searchQuery.value = query
        viewModelScope.launch {
            repository.searchMenuItems(query).collect { items ->
                _menuItems.value = filterMenu(items)
            }
        }
    }

    fun filterByCategory(category: String) {
        _selectedCategory.value = category
        loadMenuItems()
    }

    private fun filterMenu(items: List<MenuItem>): List<MenuItem> {
        return items.filter { item ->
            (_selectedCategory.value == "All" || item.category == _selectedCategory.value) &&
                    (item.name.contains(_searchQuery.value, ignoreCase = true))
        }
    }

    fun toggleAvailability(item: MenuItem) {
        viewModelScope.launch {
            repository.updateMenuItem(item.copy(isAvailable = !item.isAvailable))
            loadMenuItems()
        }
    }

    fun addMenuItem(item: MenuItem) {
        viewModelScope.launch {
            repository.insertMenuItem(item)
            loadMenuItems()
        }
    }

    fun updateMenuItem(item: MenuItem) {
        viewModelScope.launch {
            repository.updateMenuItem(item)
            loadMenuItems()
        }
    }

    fun deleteMenuItem(item: MenuItem) {
        viewModelScope.launch {
            repository.deleteMenuItem(item)
            loadMenuItems()
        }
    }

    // ✅ NEW FUNCTION — FIXES THE ERROR
    fun addToCart(item: MenuItem) {
        viewModelScope.launch {
            try {
                // If your repository already supports cart, call it like below:
                repository.addToCart(item)
                println("✅ Added to cart: ${item.name}")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

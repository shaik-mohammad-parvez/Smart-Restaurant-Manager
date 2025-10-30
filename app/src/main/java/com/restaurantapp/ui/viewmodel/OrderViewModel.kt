package com.restaurantapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restaurantapp.data.entity.Order
import com.restaurantapp.data.entity.OrderItem
import com.restaurantapp.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    // All orders list
    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders.asStateFlow()

    // Map of orderId -> list of items
    private val _orderItems = MutableStateFlow<Map<Int, List<OrderItem>>>(emptyMap())
    val orderItems: StateFlow<Map<Int, List<OrderItem>>> = _orderItems.asStateFlow()

    init {
        loadOrders()
    }

    /**
     * Load all orders and their respective items
     */
    fun loadOrders() {
        viewModelScope.launch {
            repository.getAllOrders().collect { orderList ->
                _orders.value = orderList

                // Load items for each order
                val itemsMap = mutableMapOf<Int, List<OrderItem>>()
                for (order in orderList) {
                    repository.getOrderItemsForOrder(order.id).collect { items ->
                        itemsMap[order.id] = items
                    }
                }
                _orderItems.value = itemsMap
            }
        }
    }

    /**
     * Update order status (e.g., Completed / Cancelled)
     */
    fun updateOrderStatus(orderId: Int, newStatus: String) {
        viewModelScope.launch {
            val currentOrder = _orders.value.find { it.id == orderId }
            if (currentOrder != null) {
                val updatedOrder = currentOrder.copy(status = newStatus)
                repository.updateOrder(updatedOrder)
                loadOrders() // refresh after update
            }
        }
    }

    /**
     * Delete an order completely
     */
    fun deleteOrder(order: Order) {
        viewModelScope.launch {
            repository.deleteOrder(order)
            loadOrders()
        }
    }
}

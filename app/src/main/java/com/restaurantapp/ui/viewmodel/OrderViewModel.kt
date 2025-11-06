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
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders.asStateFlow()

    private val _orderItems = MutableStateFlow<Map<Int, List<OrderItem>>>(emptyMap())
    val orderItems: StateFlow<Map<Int, List<OrderItem>>> = _orderItems.asStateFlow()

    private val _selectedOrder = MutableStateFlow<Order?>(null)
    val selectedOrder: StateFlow<Order?> = _selectedOrder.asStateFlow()

    init {
        loadOrders()
    }

    // ✅ Fetch all orders + related items
    fun loadOrders() {
        viewModelScope.launch {
            repository.getAllOrders().collect { orderList ->
                _orders.value = orderList

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

    // ✅ Fetch a single order by ID
    fun loadOrderById(orderId: Int) {
        viewModelScope.launch {
            repository.getOrderById(orderId)?.let { order ->
                val items = repository.getOrderItemsForOrder(order.id)
                _selectedOrder.value = order.copy(items = items.firstOrNull() ?: emptyList())
            }
        }
    }

    // ✅ Update an order (used in OrderDetailScreen)
    fun updateOrder(order: Order) {
        viewModelScope.launch {
            repository.updateOrder(order)
            loadOrders()
            _selectedOrder.value = order
        }
    }

    // ✅ Change order status (e.g., Completed / Pending)
    fun updateOrderStatus(orderId: Int, newStatus: String) {
        viewModelScope.launch {
            val currentOrder = _orders.value.find { it.id == orderId }
            if (currentOrder != null) {
                val updatedOrder = currentOrder.copy(status = newStatus)
                repository.updateOrder(updatedOrder)
                loadOrders()
            }
        }
    }

    // ✅ Delete order
    fun deleteOrder(order: Order) {
        viewModelScope.launch {
            repository.deleteOrder(order)
            loadOrders()
        }
    }
}

package com.restaurantapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restaurantapp.data.entity.MenuItem
import com.restaurantapp.data.entity.Order
import com.restaurantapp.data.entity.OrderItem
import com.restaurantapp.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

data class CartItem(
    val menuItem: MenuItem,
    val quantity: Int = 1
)

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems

    private val _placingOrder = MutableStateFlow(false)
    val placingOrder: StateFlow<Boolean> = _placingOrder

    fun addToCart(item: MenuItem) {
        val current = _cartItems.value.toMutableList()
        val idx = current.indexOfFirst { it.menuItem.id == item.id }
        if (idx >= 0) {
            val existing = current[idx]
            current[idx] = existing.copy(quantity = existing.quantity + 1)
        } else {
            current.add(CartItem(menuItem = item, quantity = 1))
        }
        _cartItems.value = current
    }

    fun removeFromCart(menuItemId: Int) {
        _cartItems.value = _cartItems.value.filter { it.menuItem.id != menuItemId }
    }

    fun updateQuantity(menuItemId: Int, newQty: Int) {
        if (newQty <= 0) {
            removeFromCart(menuItemId); return
        }
        _cartItems.value = _cartItems.value.map {
            if (it.menuItem.id == menuItemId) it.copy(quantity = newQty) else it
        }
    }

    fun clearCart() {
        _cartItems.value = emptyList()
    }

    fun getTotal(): Double {
        return _cartItems.value.sumOf { it.menuItem.price * it.quantity }
    }

    /**
     * Places an order. customerName and customerEmail are provided by the UI
     * notes is optional. After success the cart is cleared.
     */
    fun placeOrder(customerName: String, customerEmail: String, notes: String? = null, onResult: (success: Boolean, orderId: Long?) -> Unit) {
        if (_cartItems.value.isEmpty()) {
            onResult(false, null)
            return
        }

        viewModelScope.launch {
            try {
                _placingOrder.value = true

                val total = getTotal()
                val order = Order(
                    date = System.currentTimeMillis(),
                    customerName = customerName,
                    status = "Pending",
                    totalAmount = total,
                    notes = notes
                )

                val items = _cartItems.value.map { cartItem ->
                    OrderItem(
                        orderId = 0, // will be replaced by repository.placeOrder
                        name = cartItem.menuItem.name,
                        quantity = cartItem.quantity,
                        price = cartItem.menuItem.price
                    )
                }

                val orderId = repository.placeOrder(order, items)
                clearCart()
                _placingOrder.value = false
                onResult(true, orderId)
            } catch (e: Exception) {
                _placingOrder.value = false
                onResult(false, null)
            }
        }
    }
}

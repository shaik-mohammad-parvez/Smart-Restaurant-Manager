package com.restaurantapp.data.repository

import com.restaurantapp.data.dao.OrderDao
import com.restaurantapp.data.entity.Order
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val orderDao: OrderDao
) {
    fun getAllOrders(): Flow<List<Order>> = orderDao.getAllOrders()
    suspend fun getOrderById(orderId: Int): Order? = orderDao.getOrderById(orderId)
    suspend fun insertOrder(order: Order) = orderDao.insertOrder(order)
    suspend fun updateOrder(order: Order) = orderDao.updateOrder(order)
    suspend fun deleteOrder(order: Order) = orderDao.deleteOrder(order)
    suspend fun updateOrderStatus(orderId: Int, status: String) =
        orderDao.updateOrderStatus(orderId, status)
}

package com.restaurantapp.data.repository

import com.restaurantapp.data.dao.*
import com.restaurantapp.data.entity.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RestaurantRepository @Inject constructor(
    private val userDao: UserDao,
    private val tableDao: TableDao,
    private val menuItemDao: MenuItemDao,
    private val orderDao: OrderDao,
    private val orderItemDao: OrderItemDao,
    private val salesDataDao: SalesDataDao,
    private val cartDao: CartDao
) {


    suspend fun authenticateUser(email: String, password: String): User? =
        userDao.authenticateUser(email, password)

    suspend fun getUserByEmail(email: String): User? = userDao.getUserByEmail(email)
    suspend fun getUserById(id: Int): User? = userDao.getUserById(id)
    suspend fun insertUser(user: User) = userDao.insertUser(user)
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    suspend fun getUserCount(): Int = userDao.getUserCount()


    fun getAllTables(): Flow<List<RestaurantTable>> = tableDao.getAllTables()
    suspend fun insertTable(table: RestaurantTable) = tableDao.insertTable(table)
    suspend fun updateTable(table: RestaurantTable) = tableDao.updateTable(table)
    suspend fun deleteTable(table: RestaurantTable) = tableDao.deleteTable(table)


    fun getAllMenuItems(): Flow<List<MenuItem>> = menuItemDao.getAllMenuItems()

    fun searchMenuItems(query: String): Flow<List<MenuItem>> =
        menuItemDao.searchMenuItems("%$query%")

    suspend fun insertMenuItem(item: MenuItem) = menuItemDao.insert(item)
    suspend fun updateMenuItem(item: MenuItem) = menuItemDao.update(item)
    suspend fun deleteMenuItem(item: MenuItem) = menuItemDao.delete(item)
    suspend fun getMenuItemById(id: Int): MenuItem? = menuItemDao.getMenuItemById(id)


    fun getAllOrders(): Flow<List<Order>> = orderDao.getAllOrders()
    fun getOrdersByStatus(status: String): Flow<List<Order>> = orderDao.getOrdersByStatus(status)
    suspend fun getOrderById(orderId: Int): Order? = orderDao.getOrderById(orderId)
    suspend fun insertOrder(order: Order): Long = orderDao.insertOrder(order)
    suspend fun updateOrder(order: Order) = orderDao.updateOrder(order)
    suspend fun deleteOrder(order: Order) = orderDao.deleteOrder(order)


    fun getOrderItemsForOrder(orderId: Int): Flow<List<OrderItem>> =
        orderItemDao.getOrderItemsByOrderId(orderId)

    suspend fun insertOrderItem(item: OrderItem) = orderItemDao.insertOrderItem(item)


    fun getAllSalesData(): Flow<List<SalesData>> = salesDataDao.getAllSalesData()

    fun getSalesDataByDateRange(startDate: String, endDate: String): Flow<List<SalesData>> =
        salesDataDao.getSalesDataByDateRange(startDate, endDate)

    suspend fun insertSalesData(salesData: SalesData) = salesDataDao.insertSalesData(salesData)

    suspend fun getTotalSalesByDateRange(startDate: String, endDate: String): Double {
        val list = salesDataDao.getSalesDataByDateRange(startDate, endDate).first()
        return list.sumOf { it.totalSales }
    }

    suspend fun getTotalProfitByDateRange(startDate: String, endDate: String): Double {
        val list = salesDataDao.getSalesDataByDateRange(startDate, endDate).first()
        return list.sumOf { it.totalProfit }
    }


    suspend fun placeOrder(order: Order, items: List<OrderItem>): Long {
        val orderId = insertOrder(order) // Insert order and get generated ID
        items.forEach { item ->
            insertOrderItem(item.copy(orderId = orderId.toInt()))
        }
        return orderId
    }


    suspend fun addToCart(item: MenuItem) {
        val cartItem = CartItem(
            menuItemId = item.id,
            name = item.name,
            price = item.price,
            quantity = 1
        )
        cartDao.insertCartItem(cartItem)
    }

    fun getAllCartItems(): Flow<List<CartItem>> = cartDao.getAllCartItems()

    suspend fun clearCart() = cartDao.clearCart()
}

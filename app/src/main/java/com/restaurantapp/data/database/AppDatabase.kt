package com.restaurantapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.restaurantapp.data.Converters
import com.restaurantapp.data.dao.*
import com.restaurantapp.data.entity.*
import com.restaurantapp.data.repository.MenuDataProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@Database(
    entities = [
        User::class,
        Order::class,
        OrderItem::class,
        SalesData::class,
        MenuItem::class,
        RestaurantTable::class,
        CartItem::class              // ✅ Added Cart Entity
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun orderDao(): OrderDao
    abstract fun orderItemDao(): OrderItemDao
    abstract fun salesDataDao(): SalesDataDao
    abstract fun menuItemDao(): MenuItemDao
    abstract fun tableDao(): TableDao
    abstract fun cartDao(): CartDao                  // ✅ Added Cart DAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "restaurant_db"
            )
                .fallbackToDestructiveMigration()
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        CoroutineScope(Dispatchers.IO).launch {
                            val database = getDatabase(context)
                            prepopulate(database)
                        }
                    }
                })
                .build()
        }

        private suspend fun prepopulate(db: AppDatabase) {
            // USERS: default admin + sample user
            val userDao = db.userDao()
            val admin = User(
                fullName = "Admin User",
                email = "admin@gmail.com",
                password = "admin123",
                phoneNumber = "9999999999",
                role = "Admin"
            )
            userDao.insertUser(admin)

            val sampleUser = User(
                fullName = "Demo User",
                email = "user@example.com",
                password = "password",
                phoneNumber = "9000000000",
                role = "Customer"
            )
            userDao.insertUser(sampleUser)

            // MENU ITEMS
            val menuDao = db.menuItemDao()
            val provider = MenuDataProvider.menuItems
            provider.forEach { menuDao.insert(it) }

            // TABLES
            val tableDao = db.tableDao()
            val tables = listOf(
                RestaurantTable(tableNumber = "T1", capacity = 2, location = "Window"),
                RestaurantTable(tableNumber = "T2", capacity = 4, location = "Center"),
                RestaurantTable(tableNumber = "T3", capacity = 6, location = "Patio")
            )
            tableDao.insertTables(tables)

            // ORDERS
            val orderDao = db.orderDao()
            val orderItemDao = db.orderItemDao()

            val order1 = Order(
                date = System.currentTimeMillis(),
                customerName = "Gautham",
                status = "Completed",
                totalAmount = 150.0,
                notes = "No onions"
            )
            val id1 = orderDao.insertOrder(order1).toInt()

            val oi1 = OrderItem(orderId = id1, name = "Burger", quantity = 1, price = 120.0)
            val oi2 = OrderItem(orderId = id1, name = "Coke", quantity = 1, price = 30.0)
            orderItemDao.insertOrderItems(listOf(oi1, oi2))

            val order2 = Order(
                date = System.currentTimeMillis() - 24L * 60 * 60 * 1000,
                customerName = "Asha",
                status = "Completed",
                totalAmount = 220.0,
                notes = ""
            )
            val id2 = orderDao.insertOrder(order2).toInt()
            orderItemDao.insertOrderItems(
                listOf(OrderItem(orderId = id2, name = "Paneer Masala", quantity = 1, price = 220.0))
            )

            // SALES DATA
            val salesDao = db.salesDataDao()
            val sdf = java.text.SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val today = sdf.format(Date())
            val yesterday = sdf.format(Date(System.currentTimeMillis() - 24L * 60 * 60 * 1000))

            salesDao.insertSalesData(SalesData(date = yesterday, totalSales = 370.0, totalProfit = 150.0))
            salesDao.insertSalesData(SalesData(date = today, totalSales = 580.0, totalProfit = 260.0))
        }
    }
}

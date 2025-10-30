package com.restaurantapp.di

import android.content.Context
import com.restaurantapp.data.database.AppDatabase
import com.restaurantapp.data.dao.*
import com.restaurantapp.data.repository.RestaurantRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return AppDatabase.getDatabase(appContext)
    }

    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.userDao()

    @Provides
    fun provideOrderDao(db: AppDatabase): OrderDao = db.orderDao()

    @Provides
    fun provideOrderItemDao(db: AppDatabase): OrderItemDao = db.orderItemDao()

    @Provides
    fun provideSalesDataDao(db: AppDatabase): SalesDataDao = db.salesDataDao()

    @Provides
    fun provideMenuItemDao(db: AppDatabase): MenuItemDao = db.menuItemDao()

    @Provides
    fun provideTableDao(db: AppDatabase): TableDao = db.tableDao()

    // ✅ Provide CartDao
    @Provides
    fun provideCartDao(db: AppDatabase): CartDao = db.cartDao()

    // ✅ Provide RestaurantRepository with CartDao included
    @Provides
    @Singleton
    fun provideRepository(
        userDao: UserDao,
        tableDao: TableDao,
        menuItemDao: MenuItemDao,
        orderDao: OrderDao,
        orderItemDao: OrderItemDao,
        salesDataDao: SalesDataDao,
        cartDao: CartDao
    ): RestaurantRepository {
        return RestaurantRepository(
            userDao = userDao,
            tableDao = tableDao,
            menuItemDao = menuItemDao,
            orderDao = orderDao,
            orderItemDao = orderItemDao,
            salesDataDao = salesDataDao,
            cartDao = cartDao
        )
    }
}

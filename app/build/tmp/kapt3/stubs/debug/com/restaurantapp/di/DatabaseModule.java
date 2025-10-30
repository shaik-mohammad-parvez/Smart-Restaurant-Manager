package com.restaurantapp.di;

import android.content.Context;
import com.restaurantapp.data.database.AppDatabase;
import com.restaurantapp.data.dao.*;
import com.restaurantapp.data.repository.RestaurantRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J@\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/restaurantapp/di/DatabaseModule;", "", "()V", "provideCartDao", "Lcom/restaurantapp/data/dao/CartDao;", "db", "Lcom/restaurantapp/data/database/AppDatabase;", "provideDatabase", "appContext", "Landroid/content/Context;", "provideMenuItemDao", "Lcom/restaurantapp/data/dao/MenuItemDao;", "provideOrderDao", "Lcom/restaurantapp/data/dao/OrderDao;", "provideOrderItemDao", "Lcom/restaurantapp/data/dao/OrderItemDao;", "provideRepository", "Lcom/restaurantapp/data/repository/RestaurantRepository;", "userDao", "Lcom/restaurantapp/data/dao/UserDao;", "tableDao", "Lcom/restaurantapp/data/dao/TableDao;", "menuItemDao", "orderDao", "orderItemDao", "salesDataDao", "Lcom/restaurantapp/data/dao/SalesDataDao;", "cartDao", "provideSalesDataDao", "provideTableDao", "provideUserDao", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class DatabaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.restaurantapp.di.DatabaseModule INSTANCE = null;
    
    private DatabaseModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.database.AppDatabase provideDatabase(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context appContext) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.dao.UserDao provideUserDao(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.database.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.dao.OrderDao provideOrderDao(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.database.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.dao.OrderItemDao provideOrderItemDao(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.database.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.dao.SalesDataDao provideSalesDataDao(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.database.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.dao.MenuItemDao provideMenuItemDao(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.database.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.dao.TableDao provideTableDao(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.database.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.dao.CartDao provideCartDao(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.database.AppDatabase db) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.restaurantapp.data.repository.RestaurantRepository provideRepository(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.TableDao tableDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.MenuItemDao menuItemDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.OrderDao orderDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.OrderItemDao orderItemDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.SalesDataDao salesDataDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.CartDao cartDao) {
        return null;
    }
}
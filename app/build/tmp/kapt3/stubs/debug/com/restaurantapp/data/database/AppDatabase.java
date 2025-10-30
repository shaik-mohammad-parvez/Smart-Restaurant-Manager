package com.restaurantapp.data.database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.restaurantapp.data.Converters;
import com.restaurantapp.data.dao.*;
import com.restaurantapp.data.entity.*;
import com.restaurantapp.data.repository.MenuDataProvider;
import kotlinx.coroutines.Dispatchers;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/restaurantapp/data/database/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "cartDao", "Lcom/restaurantapp/data/dao/CartDao;", "menuItemDao", "Lcom/restaurantapp/data/dao/MenuItemDao;", "orderDao", "Lcom/restaurantapp/data/dao/OrderDao;", "orderItemDao", "Lcom/restaurantapp/data/dao/OrderItemDao;", "salesDataDao", "Lcom/restaurantapp/data/dao/SalesDataDao;", "tableDao", "Lcom/restaurantapp/data/dao/TableDao;", "userDao", "Lcom/restaurantapp/data/dao/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.restaurantapp.data.entity.User.class, com.restaurantapp.data.entity.Order.class, com.restaurantapp.data.entity.OrderItem.class, com.restaurantapp.data.entity.SalesData.class, com.restaurantapp.data.entity.MenuItem.class, com.restaurantapp.data.entity.RestaurantTable.class, com.restaurantapp.data.entity.CartItem.class}, version = 1, exportSchema = false)
@androidx.room.TypeConverters(value = {com.restaurantapp.data.Converters.class})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.restaurantapp.data.database.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.restaurantapp.data.database.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.restaurantapp.data.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.restaurantapp.data.dao.OrderDao orderDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.restaurantapp.data.dao.OrderItemDao orderItemDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.restaurantapp.data.dao.SalesDataDao salesDataDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.restaurantapp.data.dao.MenuItemDao menuItemDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.restaurantapp.data.dao.TableDao tableDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.restaurantapp.data.dao.CartDao cartDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0082@\u00a2\u0006\u0002\u0010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/restaurantapp/data/database/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/restaurantapp/data/database/AppDatabase;", "buildDatabase", "context", "Landroid/content/Context;", "getDatabase", "prepopulate", "", "db", "(Lcom/restaurantapp/data/database/AppDatabase;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.restaurantapp.data.database.AppDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        private final com.restaurantapp.data.database.AppDatabase buildDatabase(android.content.Context context) {
            return null;
        }
        
        private final java.lang.Object prepopulate(com.restaurantapp.data.database.AppDatabase db, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}
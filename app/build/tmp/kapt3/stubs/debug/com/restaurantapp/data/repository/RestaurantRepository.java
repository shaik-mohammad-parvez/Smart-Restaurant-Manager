package com.restaurantapp.data.repository;

import com.restaurantapp.data.dao.*;
import com.restaurantapp.data.entity.*;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;
import javax.inject.Singleton;

@javax.inject.Singleton
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J \u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0086@\u00a2\u0006\u0002\u0010&J\u0012\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(J\u0012\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140)0(J\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0)0(J\u0012\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0)0(J\u0012\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0)0(J\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170)0(J\u0018\u00101\u001a\u0004\u0018\u00010\u00142\u0006\u00102\u001a\u000203H\u0086@\u00a2\u0006\u0002\u00104J\u0018\u00105\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u000203H\u0086@\u00a2\u0006\u0002\u00104J\u001a\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080)0(2\u0006\u00106\u001a\u000203J\u001a\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0)0(2\u0006\u0010:\u001a\u00020\u0019J\"\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0)0(2\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0019J\u001e\u0010>\u001a\u00020?2\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010@\u001a\u00020?2\u0006\u0010<\u001a\u00020\u00192\u0006\u0010=\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0018\u0010A\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u0004\u0018\u00010\u00172\u0006\u00102\u001a\u000203H\u0086@\u00a2\u0006\u0002\u00104J\u000e\u0010D\u001a\u000203H\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010E\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010F\u001a\u00020G2\u0006\u0010 \u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\"J\u0016\u0010H\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u000208H\u0086@\u00a2\u0006\u0002\u0010IJ\u0016\u0010J\u001a\u00020\u00122\u0006\u0010K\u001a\u00020.H\u0086@\u00a2\u0006\u0002\u0010LJ\u0016\u0010M\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0086@\u00a2\u0006\u0002\u0010&J\u0016\u0010N\u001a\u00020\u00122\u0006\u0010O\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010PJ$\u0010Q\u001a\u00020G2\u0006\u0010 \u001a\u00020!2\f\u0010R\u001a\b\u0012\u0004\u0012\u0002080)H\u0086@\u00a2\u0006\u0002\u0010SJ\u001a\u0010T\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140)0(2\u0006\u0010U\u001a\u00020\u0019J\u0016\u0010V\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010W\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010\"J\u0016\u0010X\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0086@\u00a2\u0006\u0002\u0010&R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Lcom/restaurantapp/data/repository/RestaurantRepository;", "", "userDao", "Lcom/restaurantapp/data/dao/UserDao;", "tableDao", "Lcom/restaurantapp/data/dao/TableDao;", "menuItemDao", "Lcom/restaurantapp/data/dao/MenuItemDao;", "orderDao", "Lcom/restaurantapp/data/dao/OrderDao;", "orderItemDao", "Lcom/restaurantapp/data/dao/OrderItemDao;", "salesDataDao", "Lcom/restaurantapp/data/dao/SalesDataDao;", "cartDao", "Lcom/restaurantapp/data/dao/CartDao;", "(Lcom/restaurantapp/data/dao/UserDao;Lcom/restaurantapp/data/dao/TableDao;Lcom/restaurantapp/data/dao/MenuItemDao;Lcom/restaurantapp/data/dao/OrderDao;Lcom/restaurantapp/data/dao/OrderItemDao;Lcom/restaurantapp/data/dao/SalesDataDao;Lcom/restaurantapp/data/dao/CartDao;)V", "addToCart", "", "item", "Lcom/restaurantapp/data/entity/MenuItem;", "(Lcom/restaurantapp/data/entity/MenuItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateUser", "Lcom/restaurantapp/data/entity/User;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMenuItem", "deleteOrder", "order", "Lcom/restaurantapp/data/entity/Order;", "(Lcom/restaurantapp/data/entity/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTable", "table", "Lcom/restaurantapp/data/entity/RestaurantTable;", "(Lcom/restaurantapp/data/entity/RestaurantTable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCartItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/restaurantapp/data/entity/CartItem;", "getAllMenuItems", "getAllOrders", "getAllSalesData", "Lcom/restaurantapp/data/entity/SalesData;", "getAllTables", "getAllUsers", "getMenuItemById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderById", "orderId", "getOrderItemsForOrder", "Lcom/restaurantapp/data/entity/OrderItem;", "getOrdersByStatus", "status", "getSalesDataByDateRange", "startDate", "endDate", "getTotalProfitByDateRange", "", "getTotalSalesByDateRange", "getUserByEmail", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserById", "getUserCount", "insertMenuItem", "insertOrder", "", "insertOrderItem", "(Lcom/restaurantapp/data/entity/OrderItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertSalesData", "salesData", "(Lcom/restaurantapp/data/entity/SalesData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertTable", "insertUser", "user", "(Lcom/restaurantapp/data/entity/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "placeOrder", "items", "(Lcom/restaurantapp/data/entity/Order;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchMenuItems", "query", "updateMenuItem", "updateOrder", "updateTable", "app_debug"})
public final class RestaurantRepository {
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.dao.UserDao userDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.dao.TableDao tableDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.dao.MenuItemDao menuItemDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.dao.OrderDao orderDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.dao.OrderItemDao orderItemDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.dao.SalesDataDao salesDataDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.dao.CartDao cartDao = null;
    
    @javax.inject.Inject
    public RestaurantRepository(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.UserDao userDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.TableDao tableDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.MenuItemDao menuItemDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.OrderDao orderDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.OrderItemDao orderItemDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.SalesDataDao salesDataDao, @org.jetbrains.annotations.NotNull
    com.restaurantapp.data.dao.CartDao cartDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object authenticateUser(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserByEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.User> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertUser(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.User user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.User>> getAllUsers() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getUserCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.RestaurantTable>> getAllTables() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.MenuItem>> getAllMenuItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.MenuItem>> searchMenuItems(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertMenuItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateMenuItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteMenuItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMenuItemById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.MenuItem> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.Order>> getAllOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.Order>> getOrdersByStatus(@org.jetbrains.annotations.NotNull
    java.lang.String status) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOrderById(int orderId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.Order> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.OrderItem>> getOrderItemsForOrder(int orderId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertOrderItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.OrderItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.SalesData>> getAllSalesData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.SalesData>> getSalesDataByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertSalesData(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.SalesData salesData, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalSalesByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalProfitByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object placeOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order, @org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.OrderItem> items, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object addToCart(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.CartItem>> getAllCartItems() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearCart(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}
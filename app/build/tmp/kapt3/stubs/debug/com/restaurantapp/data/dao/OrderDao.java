package com.restaurantapp.data.dao;

import androidx.room.*;
import com.restaurantapp.data.entity.Order;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0015\u001a\u00020\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u00a7@\u00a2\u0006\u0002\u0010\u001a\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001b\u00c0\u0006\u0001"}, d2 = {"Lcom/restaurantapp/data/dao/OrderDao;", "", "deleteAllOrders", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOrder", "order", "Lcom/restaurantapp/data/entity/Order;", "(Lcom/restaurantapp/data/entity/Order;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllOrders", "Lkotlinx/coroutines/flow/Flow;", "", "getOrderById", "orderId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrdersByStatus", "status", "", "insertOrder", "", "insertOrders", "orders", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOrder", "updateOrderStatus", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface OrderDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertOrders(@org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.Order> orders, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM orders")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllOrders(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM orders ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.Order>> getAllOrders();
    
    @androidx.room.Query(value = "SELECT * FROM orders WHERE id = :orderId LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOrderById(int orderId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.Order> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM orders WHERE status = :status ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.Order>> getOrdersByStatus(@org.jetbrains.annotations.NotNull
    java.lang.String status);
    
    @androidx.room.Query(value = "UPDATE orders SET status = :status WHERE id = :orderId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateOrderStatus(int orderId, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
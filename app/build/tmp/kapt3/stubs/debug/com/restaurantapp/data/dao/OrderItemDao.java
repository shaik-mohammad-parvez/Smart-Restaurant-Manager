package com.restaurantapp.data.dao;

import androidx.room.*;
import com.restaurantapp.data.entity.OrderItem;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\b\u001a\u00020\tH\'J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u0013\u00c0\u0006\u0001"}, d2 = {"Lcom/restaurantapp/data/dao/OrderItemDao;", "", "deleteOrderItem", "", "orderItem", "Lcom/restaurantapp/data/entity/OrderItem;", "(Lcom/restaurantapp/data/entity/OrderItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOrderItemsByOrderId", "orderId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderItemsByOrderId", "Lkotlinx/coroutines/flow/Flow;", "", "insertOrderItem", "insertOrderItems", "orderItems", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateOrderItem", "app_debug"})
@androidx.room.Dao
public abstract interface OrderItemDao {
    
    @androidx.room.Query(value = "SELECT * FROM order_items WHERE orderId = :orderId")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.OrderItem>> getOrderItemsByOrderId(int orderId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertOrderItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.OrderItem orderItem, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertOrderItems(@org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.OrderItem> orderItems, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateOrderItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.OrderItem orderItem, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteOrderItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.OrderItem orderItem, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM order_items WHERE orderId = :orderId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteOrderItemsByOrderId(int orderId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
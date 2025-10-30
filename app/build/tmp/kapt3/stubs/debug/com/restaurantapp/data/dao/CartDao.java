package com.restaurantapp.data.dao;

import androidx.room.*;
import com.restaurantapp.data.entity.CartItem;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0010\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nH\'J\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\b\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u000f\u00c0\u0006\u0001"}, d2 = {"Lcom/restaurantapp/data/dao/CartDao;", "", "clearCart", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCartItem", "item", "Lcom/restaurantapp/data/entity/CartItem;", "(Lcom/restaurantapp/data/entity/CartItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllCartItems", "Lkotlinx/coroutines/flow/Flow;", "", "getCartTotal", "", "insertCartItem", "app_debug"})
@androidx.room.Dao
public abstract interface CartDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertCartItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.CartItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM cart")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.CartItem>> getAllCartItems();
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteCartItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.CartItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM cart")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearCart(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(price * quantity) FROM cart")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getCartTotal();
}
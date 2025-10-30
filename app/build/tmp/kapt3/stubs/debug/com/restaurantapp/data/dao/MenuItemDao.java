package com.restaurantapp.data.dao;

import androidx.room.*;
import com.restaurantapp.data.entity.MenuItem;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0016\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u0017\u001a\u00020\u0012H\'J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001e\u0010\u0019\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00a2\u0006\u0002\u0010\u001c\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001d\u00c0\u0006\u0001"}, d2 = {"Lcom/restaurantapp/data/dao/MenuItemDao;", "", "clearMenuItems", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "item", "Lcom/restaurantapp/data/entity/MenuItem;", "(Lcom/restaurantapp/data/entity/MenuItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMenuItems", "Lkotlinx/coroutines/flow/Flow;", "", "getMenuItemById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMenuItemsByCategory", "category", "", "insert", "items", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchMenuItems", "query", "update", "updateAvailability", "isAvailable", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface MenuItemDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.MenuItem> items, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM menu_items")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.MenuItem>> getAllMenuItems();
    
    @androidx.room.Query(value = "SELECT * FROM menu_items WHERE name LIKE :query OR category LIKE :query")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.MenuItem>> searchMenuItems(@org.jetbrains.annotations.NotNull
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT * FROM menu_items WHERE category = :category")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.MenuItem>> getMenuItemsByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM menu_items WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMenuItemById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.MenuItem> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM menu_items")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearMenuItems(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE menu_items SET isAvailable = :isAvailable WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateAvailability(int id, boolean isAvailable, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
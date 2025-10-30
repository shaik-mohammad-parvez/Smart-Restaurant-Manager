package com.restaurantapp.data.dao;

import androidx.room.*;
import com.restaurantapp.data.entity.RestaurantTable;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0013\u001a\u00020\u0010H\'J\u001c\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0015\u001a\u00020\u0010H\'J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u001c\u00f8\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001\u00a8\u0006\u001d\u00c0\u0006\u0001"}, d2 = {"Lcom/restaurantapp/data/dao/TableDao;", "", "deleteTable", "", "table", "Lcom/restaurantapp/data/entity/RestaurantTable;", "(Lcom/restaurantapp/data/entity/RestaurantTable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTables", "Lkotlinx/coroutines/flow/Flow;", "", "getTableById", "tableId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTableByNumber", "tableNumber", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTablesByLocation", "location", "getTablesByStatus", "status", "insertTable", "insertTables", "tables", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTable", "updateTableStatus", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface TableDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertTables(@org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.RestaurantTable> tables, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tables")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.RestaurantTable>> getAllTables();
    
    @androidx.room.Query(value = "SELECT * FROM tables WHERE id = :tableId LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTableById(int tableId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.RestaurantTable> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tables WHERE tableNumber = :tableNumber LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTableByNumber(@org.jetbrains.annotations.NotNull
    java.lang.String tableNumber, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.restaurantapp.data.entity.RestaurantTable> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM tables WHERE status = :status")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.RestaurantTable>> getTablesByStatus(@org.jetbrains.annotations.NotNull
    java.lang.String status);
    
    @androidx.room.Query(value = "SELECT * FROM tables WHERE location = :location")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.restaurantapp.data.entity.RestaurantTable>> getTablesByLocation(@org.jetbrains.annotations.NotNull
    java.lang.String location);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE tables SET status = :status WHERE tableNumber = :tableNumber")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateTableStatus(@org.jetbrains.annotations.NotNull
    java.lang.String tableNumber, @org.jetbrains.annotations.NotNull
    java.lang.String status, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
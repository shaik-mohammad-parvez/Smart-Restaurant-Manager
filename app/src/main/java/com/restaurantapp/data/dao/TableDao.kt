package com.restaurantapp.data.dao

import androidx.room.*
import com.restaurantapp.data.entity.RestaurantTable
import kotlinx.coroutines.flow.Flow

@Dao
interface TableDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTable(table: RestaurantTable)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTables(tables: List<RestaurantTable>)

    @Query("SELECT * FROM tables")
    fun getAllTables(): Flow<List<RestaurantTable>>

    @Query("SELECT * FROM tables WHERE id = :tableId LIMIT 1")
    suspend fun getTableById(tableId: Int): RestaurantTable?

    @Query("SELECT * FROM tables WHERE tableNumber = :tableNumber LIMIT 1")
    suspend fun getTableByNumber(tableNumber: String): RestaurantTable?

    @Query("SELECT * FROM tables WHERE status = :status")
    fun getTablesByStatus(status: String): Flow<List<RestaurantTable>>

    @Query("SELECT * FROM tables WHERE location = :location")
    fun getTablesByLocation(location: String): Flow<List<RestaurantTable>>

    @Update
    suspend fun updateTable(table: RestaurantTable)

    @Query("UPDATE tables SET status = :status WHERE tableNumber = :tableNumber")
    suspend fun updateTableStatus(tableNumber: String, status: String)

    @Delete
    suspend fun deleteTable(table: RestaurantTable)
}

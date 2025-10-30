package com.restaurantapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.restaurantapp.data.entity.SalesData
import kotlinx.coroutines.flow.Flow

@Dao
interface SalesDataDao {

    @Insert
    suspend fun insertSalesData(salesData: SalesData)

    @Query("SELECT * FROM sales_data ORDER BY id DESC")
    fun getAllSalesData(): Flow<List<SalesData>>

    @Query("SELECT * FROM sales_data WHERE date BETWEEN :startDate AND :endDate ORDER BY id DESC")
    fun getSalesDataByDateRange(startDate: String, endDate: String): Flow<List<SalesData>>
}

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

    @Query("SELECT * FROM sales_data WHERE date BETWEEN :startDate AND :endDate ORDER BY date ASC")
    fun getSalesDataByDateRange(startDate: String, endDate: String): Flow<List<SalesData>>

    // Optional helpful queries (if you want to add them to your DAO / repository)
    // @Query("SELECT IFNULL(SUM(totalSales), 0) FROM sales_data WHERE date BETWEEN :startDate AND :endDate")
    // suspend fun getTotalSalesByDateRange(startDate: String, endDate: String): Double
    //
    // @Query("SELECT IFNULL(SUM(totalProfit), 0) FROM sales_data WHERE date BETWEEN :startDate AND :endDate")
    // suspend fun getTotalProfitByDateRange(startDate: String, endDate: String): Double
}

package com.restaurantapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sales_data")
data class SalesData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String, // expects "yyyy-MM-dd"
    val totalSales: Double = 0.0,
    val totalProfit: Double = 0.0
)

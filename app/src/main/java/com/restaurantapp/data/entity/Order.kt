package com.restaurantapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.restaurantapp.data.Converters

@Entity(tableName = "orders")
@TypeConverters(Converters::class)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: Long = System.currentTimeMillis(), // timestamp
    val customerName: String? = null,
    val status: String = "Pending", // Pending, InProgress, Completed, Cancelled
    val totalAmount: Double = 0.0,
    val tableNumber: Int = 1, // default value to prevent missing parameter
    val items: List<OrderItem> = emptyList(), // safe default to avoid build errors
    val notes: String? = null
)

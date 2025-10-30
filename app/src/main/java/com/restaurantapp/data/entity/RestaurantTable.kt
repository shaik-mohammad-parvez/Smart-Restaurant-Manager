package com.restaurantapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tables")
data class RestaurantTable(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tableNumber: String,
    val capacity: Int,
    val status: String = "Available",
    val location: String
)


package com.restaurantapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val menuItemId: Int,
    val name: String,
    val price: Double,
    val quantity: Int
)

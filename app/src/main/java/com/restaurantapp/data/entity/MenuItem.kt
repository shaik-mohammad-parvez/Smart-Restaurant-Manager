package com.restaurantapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "menu_items")
data class MenuItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String = "",
    val category: String = "",
    val stock: Int = 0,
    val isAvailable: Boolean = true
)

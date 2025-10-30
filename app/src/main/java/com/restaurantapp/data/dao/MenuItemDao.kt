package com.restaurantapp.data.dao

import androidx.room.*
import com.restaurantapp.data.entity.MenuItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MenuItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: MenuItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<MenuItem>)

    @Query("SELECT * FROM menu_items")
    fun getAllMenuItems(): Flow<List<MenuItem>>

    @Query("SELECT * FROM menu_items WHERE name LIKE :query OR category LIKE :query")
    fun searchMenuItems(query: String): Flow<List<MenuItem>>

    @Query("SELECT * FROM menu_items WHERE category = :category")
    fun getMenuItemsByCategory(category: String): Flow<List<MenuItem>>

    @Query("SELECT * FROM menu_items WHERE id = :id LIMIT 1")
    suspend fun getMenuItemById(id: Int): MenuItem?

    @Update
    suspend fun update(item: MenuItem)

    @Delete
    suspend fun delete(item: MenuItem)

    @Query("DELETE FROM menu_items")
    suspend fun clearMenuItems()

    @Query("UPDATE menu_items SET isAvailable = :isAvailable WHERE id = :id")
    suspend fun updateAvailability(id: Int, isAvailable: Boolean)
}

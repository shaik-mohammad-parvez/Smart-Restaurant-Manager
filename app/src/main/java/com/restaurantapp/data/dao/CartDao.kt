package com.restaurantapp.data.dao

import androidx.room.*
import com.restaurantapp.data.entity.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(item: CartItem)


    @Query("SELECT * FROM cart")
    fun getAllCartItems(): Flow<List<CartItem>>


    @Delete
    suspend fun deleteCartItem(item: CartItem)


    @Query("DELETE FROM cart")
    suspend fun clearCart()


    @Query("SELECT SUM(price * quantity) FROM cart")
    fun getCartTotal(): Flow<Double?>
}

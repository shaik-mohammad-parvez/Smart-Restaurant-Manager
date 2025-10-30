package com.restaurantapp.data.dao

import androidx.room.*
import com.restaurantapp.data.entity.CartItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    // ✅ Insert or update an item in the cart
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(item: CartItem)

    // ✅ Fetch all items currently in the cart
    @Query("SELECT * FROM cart")
    fun getAllCartItems(): Flow<List<CartItem>>

    // ✅ Delete a specific item from the cart
    @Delete
    suspend fun deleteCartItem(item: CartItem)

    // ✅ Clear all items from the cart
    @Query("DELETE FROM cart")
    suspend fun clearCart()

    // ✅ Optional: Get total price directly from DB (useful for checkout summary)
    @Query("SELECT SUM(price * quantity) FROM cart")
    fun getCartTotal(): Flow<Double?>
}

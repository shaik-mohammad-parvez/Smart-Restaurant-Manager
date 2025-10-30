package com.restaurantapp.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.restaurantapp.data.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertUser(user: User)

   @Query("SELECT * FROM users WHERE email = :email AND password = :password LIMIT 1")
   suspend fun authenticateUser(email: String, password: String): User?

   @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
   suspend fun getUserByEmail(email: String): User?

   @Query("SELECT * FROM users WHERE id = :userId LIMIT 1")
   suspend fun getUserById(userId: Int): User?

   @Query("SELECT COUNT(*) FROM users")
   suspend fun getUserCount(): Int

   @Query("SELECT * FROM users")
   fun getAllUsers(): Flow<List<User>>
}

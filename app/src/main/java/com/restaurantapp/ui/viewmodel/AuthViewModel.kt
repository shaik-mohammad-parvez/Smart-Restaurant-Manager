package com.restaurantapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.restaurantapp.data.entity.User
import com.restaurantapp.data.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    private val _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {

                if (email.trim() == "admin@gmail.com" && password == "admin123") {
                    _currentUser.value = User(
                        email = email,
                        fullName = "Admin",
                        password = password,
                        phoneNumber = "",
                        role = "Admin"
                    )
                    _isAuthenticated.value = true
                    _errorMessage.value = null
                    return@launch
                }


                val user = repository.authenticateUser(email, password)
                if (user != null) {
                    _currentUser.value = user.copy(role = "Customer")
                    _isAuthenticated.value = true
                    _errorMessage.value = null
                } else {
                    _errorMessage.value = "Invalid email or password"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Login failed: ${e.message}"
            }
        }
    }

    fun signUp(fullName: String, email: String, password: String, phoneNumber: String) {
        viewModelScope.launch {
            try {
                val existingUser = repository.getUserByEmail(email)
                if (existingUser != null) {
                    _errorMessage.value = "User already exists with this email"
                    return@launch
                }

                val user = User(
                    email = email,
                    fullName = fullName,
                    password = password,
                    phoneNumber = phoneNumber,
                    role = "Customer"
                )
                repository.insertUser(user)
                _currentUser.value = user
                _isAuthenticated.value = true
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = "Sign up failed: ${e.message}"
            }
        }
    }

    fun logout() {
        _isAuthenticated.value = false
        _currentUser.value = null
        _errorMessage.value = null
    }

    fun clearError() {
        _errorMessage.value = null
    }
}

package com.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import com.restaurantapp.navigation.RestaurantNavigation
import com.restaurantapp.ui.theme.RestaurantAppTheme
import com.restaurantapp.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RestaurantAppTheme {
                Surface {
                    val navController = rememberNavController()
                    val isAuthenticated = authViewModel.isAuthenticated.collectAsState().value
                    val currentUser = authViewModel.currentUser.collectAsState().value

                    RestaurantNavigation(
                        navController = navController,
                        isAuthenticated = isAuthenticated,
                        currentUser = currentUser,
                        authViewModel = authViewModel
                    )
                }
            }
        }
    }
}

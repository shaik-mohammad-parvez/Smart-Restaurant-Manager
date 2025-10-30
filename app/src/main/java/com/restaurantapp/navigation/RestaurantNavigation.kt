package com.restaurantapp.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.restaurantapp.data.entity.User
import com.restaurantapp.ui.screens.*
import com.restaurantapp.ui.screens.admin.*
import com.restaurantapp.ui.screens.customer.*
import com.restaurantapp.ui.viewmodel.AuthViewModel

@Composable
fun RestaurantNavigation(
    navController: NavHostController,
    isAuthenticated: Boolean,
    currentUser: User?,
    authViewModel: AuthViewModel = hiltViewModel()
) {

    val startDestination = if (!isAuthenticated) {
        Routes.SPLASH
    } else {
        if (currentUser?.role == "Admin") Routes.ADMIN_DASHBOARD else Routes.CUSTOMER_DASHBOARD
    }

    NavHost(navController = navController, startDestination = startDestination) {


        composable(Routes.SPLASH) {
            SplashScreen(navController = navController)
        }


        composable(Routes.LOGIN) {
            LoginScreen(navController, authViewModel)
        }
        composable(Routes.SIGNUP) {
            SignUpScreen(navController, authViewModel)
        }


        composable(Routes.ADMIN_DASHBOARD) {
            AdminDashboardScreen(
                navController = navController,
                onLogout = {
                    authViewModel.logout()
                    navController.navigate(Routes.LOGIN) { popUpTo(0) }
                }
            )
        }

        composable(Routes.CUSTOMER_DASHBOARD) {
            CustomerDashboardScreen(
                navController = navController,
                onLogout = {
                    authViewModel.logout()
                    navController.navigate(Routes.LOGIN) { popUpTo(0) }
                }
            )
        }


        composable(Routes.VIEW_MENU) {
            ViewMenuScreen(navController = navController)
        }

        composable(Routes.MY_ORDERS) {
            MyOrdersScreen(navController = navController)
        }


        composable(Routes.TABLE_LIST) {
            TableListScreen(navController = navController)
        }

        composable(Routes.ADD_TABLE) {
            AddTableScreen(navController = navController)
        }

        composable("${Routes.EDIT_TABLE}/{tableId}") { backStack ->
            val id = backStack.arguments?.getString("tableId")?.toIntOrNull()
            EditTableScreen(navController = navController, tableId = id)
        }


        composable(Routes.MANAGE_MENU) {
            ManageMenuScreen(navController = navController)
        }

        composable(Routes.ADD_MENU_ITEM) {
            AddMenuItemScreen(navController = navController)
        }

        composable("${Routes.EDIT_MENU_ITEM}/{menuId}") { backStack ->
            val id = backStack.arguments?.getString("menuId")?.toIntOrNull()
            EditMenuItemScreen(navController = navController, menuId = id)
        }


        composable(Routes.MANAGE_ORDERS) {
            ManageOrdersScreen(navController = navController)
        }

        composable(Routes.SALES_REPORT) {
            SalesReportScreen(navController = navController)
        }
    }
}

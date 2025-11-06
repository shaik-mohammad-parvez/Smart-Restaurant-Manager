package com.restaurantapp.navigation
import OrderMenuScreen
import com.restaurantapp.ui.screens.admin.SalesReportScreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.restaurantapp.data.entity.User
import com.restaurantapp.ui.screens.LoginScreen
import com.restaurantapp.ui.screens.SignUpScreen
import com.restaurantapp.ui.screens.SplashScreen
import com.restaurantapp.ui.screens.admin.AddMenuItemScreen
import com.restaurantapp.ui.screens.admin.AddTableScreen
import com.restaurantapp.ui.screens.admin.AdminDashboardScreen
import com.restaurantapp.ui.screens.admin.EditMenuItemScreen
import com.restaurantapp.ui.screens.admin.EditTableScreen
import com.restaurantapp.ui.screens.admin.ManageMenuScreen
import com.restaurantapp.ui.screens.admin.ManageOrdersScreen
import com.restaurantapp.ui.screens.admin.OrderDetailScreen

import com.restaurantapp.ui.screens.admin.TableListScreen
import com.restaurantapp.ui.screens.customer.CustomerDashboardScreen
import com.restaurantapp.ui.screens.customer.MyOrdersScreen
import com.restaurantapp.ui.screens.customer.ViewMenuScreen
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

        // Authentication
        composable(Routes.SPLASH) { SplashScreen(navController = navController) }
        composable(Routes.LOGIN) { LoginScreen(navController, authViewModel) }
        composable(Routes.SIGNUP) { SignUpScreen(navController, authViewModel) }

        // Admin
        composable(Routes.ADMIN_DASHBOARD) {
            AdminDashboardScreen(navController = navController)
        }
        // register Sales Report screen
        composable(Routes.SALES_REPORT) {
            // SalesReportScreen expects an onBack lambda; use navController.popBackStack() to go back
            SalesReportScreen(
                onBack = { navController.popBackStack() }
            )
        }


        // Customer
        composable(Routes.CUSTOMER_DASHBOARD) {
            CustomerDashboardScreen(
                navController = navController,
                onLogout = {
                    authViewModel.logout()
                    navController.navigate(Routes.LOGIN) { popUpTo(0) }
                }
            )
        }

        // Common Screens
        composable(Routes.VIEW_MENU) { ViewMenuScreen(navController = navController) }
        composable(Routes.MY_ORDERS) { MyOrdersScreen(navController = navController) }

        // Table Management
        composable(Routes.TABLE_LIST) { TableListScreen(navController = navController) }
        composable(Routes.ADD_TABLE) { AddTableScreen(navController = navController) }
        composable("${Routes.EDIT_TABLE}/{tableId}") { backStack ->
            val id = backStack.arguments?.getString("tableId")?.toIntOrNull()
            EditTableScreen(navController = navController, tableId = id)
        }

        // Menu Management
        composable(Routes.MANAGE_MENU) { ManageMenuScreen(navController = navController) }
        composable(Routes.ADD_MENU_ITEM) { AddMenuItemScreen(navController = navController) }
        composable("${Routes.EDIT_MENU_ITEM}/{menuId}") { backStack ->
            val id = backStack.arguments?.getString("menuId")?.toIntOrNull()
            EditMenuItemScreen(navController = navController, menuId = id)
        }

        // Orders
        composable(Routes.MANAGE_ORDERS) { ManageOrdersScreen(navController = navController) }
        composable("order_detail/{orderId}") { backStackEntry ->
            val orderId = backStackEntry.arguments?.getString("orderId")?.toIntOrNull() ?: 0
            OrderDetailScreen(
                orderId = orderId,
                onBack = { navController.popBackStack() },
                onProcessPayment = { subtotal, tax ->
                    // TODO: Add your payment logic here
                }
            )
        }


        // Modern Order Menu Screen
        composable(Routes.ORDER_MENU) {
            OrderMenuScreen(navController = navController)
        }
    }
}

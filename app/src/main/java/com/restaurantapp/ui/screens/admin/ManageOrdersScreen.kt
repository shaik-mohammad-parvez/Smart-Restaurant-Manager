package com.restaurantapp.ui.screens.admin

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.restaurantapp.data.entity.Order
import com.restaurantapp.navigation.Routes
import com.restaurantapp.ui.viewmodel.OrderViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManageOrdersScreen(
    navController: NavController,
    viewModel: OrderViewModel = hiltViewModel()
) {
    val orders by viewModel.orders.collectAsState()

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Order Management", color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
        ) {
            if (orders.isEmpty()) {
                Text(
                    text = "No orders yet",
                    color = Color.Gray,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    items(orders) { order ->

                        val validId = order.id ?: 0
                        OrderCard(order = order) {
                            if (validId > 0) {
                                Log.d("NAVIGATION", "Navigating to order_detail/$validId")
                                navController.navigate("${Routes.ORDER_DETAIL}/$validId")
                            } else {
                                Log.w("NAVIGATION", "Invalid order id, cannot navigate")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OrderCard(order: Order, onClick: () -> Unit) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Order #${order.id ?: "-"}",
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = order.status,
                    color = if (order.status == "Completed") Color(0xFF4CAF50) else Color(0xFFFFA000),
                    fontWeight = FontWeight.SemiBold
                )
            }

            Spacer(Modifier.height(6.dp))
            Text("Customer: ${order.customerName ?: "Walk-in"}", color = Color.DarkGray)
            Text("Table: ${order.tableNumber ?: "-"}", color = Color.Gray)
            Text(
                "Total: ₹${order.totalAmount}",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(Modifier.height(6.dp))
            Text(
                "Date: ${order.date ?: "-"}",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

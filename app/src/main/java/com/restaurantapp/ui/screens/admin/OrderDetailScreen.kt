package com.restaurantapp.ui.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.restaurantapp.data.entity.Order

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailScreen(
    navController: NavController,
    order: Order
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Order Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Order ID: ${order.id}", style = MaterialTheme.typography.titleMedium)
            Text("Customer: ${order.customerName}", fontWeight = FontWeight.Bold)
            Text("Table No: ${order.tableNumber}")
            Text("Items:", fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(4.dp))

            order.items.forEach { item ->
                Text("- ${item.name} × ${item.quantity}")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text("Total Amount: ₹${order.totalAmount}", fontWeight = FontWeight.Bold)
            Text("Status: ${order.status}")

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Back to Orders")
            }
        }
    }
}

package com.restaurantapp.ui.screens.customer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyOrdersScreen(
    navController: NavHostController,
    onBackClick: () -> Unit = { navController.popBackStack() }
) {
    val sampleOrders = remember {
        listOf(
            OrderItemUi(
                name = "Butter Chicken",
                price = 349.0,
                quantity = 1,
                imageUrl = "https://images.pexels.com/photos/2379004/pexels-photo-2379004.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
                status = "Delivered"
            ),
            OrderItemUi(
                name = "Grilled Sandwich",
                price = 149.0,
                quantity = 2,
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTs5LB5FwUKimrSpdGdgacjMIwQrLWKh3ENJA&s",
                status = "Preparing"
            ),
            OrderItemUi(
                name = "Cold Coffee",
                price = 129.0,
                quantity = 1,
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSuPLBYGwOr3c9YnBhNEU1KQ82IMOuMn9hEMw&s",
                status = "Delivered"
            )
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Orders", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Black)
            )
        },
        containerColor = Color(0xFF121212)
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF121212))
                .padding(padding)
        ) {
            if (sampleOrders.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "No Orders Yet 😔",
                        color = Color.Gray,
                        fontSize = 18.sp
                    )
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(sampleOrders) { order ->
                        MyOrderCard(order)
                    }
                }
            }
        }
    }
}

@Composable
fun MyOrderCard(order: OrderItemUi) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = rememberAsyncImagePainter(order.imageUrl),
                contentDescription = order.name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(MaterialTheme.shapes.medium),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(12.dp))


            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = order.name,
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Quantity: ${order.quantity}",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "₹${order.price}",
                    color = Color(0xFF4CAF50),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "Status: ${order.status}",
                    color = if (order.status == "Delivered") Color(0xFF00E676) else Color(0xFFFFC107),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


data class OrderItemUi(
    val name: String,
    val price: Double,
    val quantity: Int,
    val imageUrl: String,
    val status: String
)

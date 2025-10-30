package com.restaurantapp.ui.screens.customer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.restaurantapp.navigation.Routes
import com.restaurantapp.ui.viewmodel.CartViewModel
import com.restaurantapp.ui.viewmodel.AuthViewModel
import com.restaurantapp.ui.viewmodel.CartItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController,
    cartViewModel: CartViewModel = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val cartItems by cartViewModel.cartItems.collectAsState()
    val placing by cartViewModel.placingOrder.collectAsState()
    val currentUser by authViewModel.currentUser.collectAsState()

    var notes by remember { mutableStateOf("") }
    var showMessage by remember { mutableStateOf("") }

    if (showMessage.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = { showMessage = "" },
            confirmButton = {
                TextButton(onClick = { showMessage = "" }) { Text("OK") }
            },
            title = { Text("Order Status") },
            text = { Text(showMessage) }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Your Cart") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            if (cartItems.isEmpty()) {
                Text("Your cart is empty. Add items from the menu.")
                return@Column
            }

            LazyColumn(modifier = Modifier.weight(1f)) {
                items(cartItems) { item: CartItem ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(text = item.menuItem.name, style = MaterialTheme.typography.titleMedium)
                                Text(text = "₹${item.menuItem.price}  x ${item.quantity}")
                            }
                            Row {
                                TextButton(onClick = { cartViewModel.updateQuantity(item.menuItem.id, item.quantity - 1) }) {
                                    Text("-")
                                }
                                TextButton(onClick = { cartViewModel.updateQuantity(item.menuItem.id, item.quantity + 1) }) {
                                    Text("+")
                                }
                                TextButton(onClick = { cartViewModel.removeFromCart(item.menuItem.id) }) {
                                    Text("Remove")
                                }
                            }
                        }
                    }
                }
            }

            OutlinedTextField(
                value = notes,
                onValueChange = { notes = it },
                label = { Text("Notes (optional)") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(12.dp))

            val total = cartViewModel.getTotal()
            Text(text = "Total: ₹${"%.2f".format(total)}", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = {
                    val name = currentUser?.fullName ?: "Guest"
                    val email = currentUser?.email ?: "guest@restaurant.local"

                    cartViewModel.placeOrder(name, email, notes) { success, _ ->
                        if (success) {
                            showMessage = "Order placed successfully!"
                            navController.navigate(Routes.MY_ORDERS)
                        } else {
                            showMessage = "Failed to place order. Try again."
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = !placing
            ) {
                if (placing) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(18.dp),
                        strokeWidth = 2.dp
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(if (placing) "Placing..." else "Place Order")
            }
        }
    }
}

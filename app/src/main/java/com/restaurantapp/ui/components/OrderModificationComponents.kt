package com.restaurantapp.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderModificationDialog(
    isVisible: Boolean,
    currentModifications: String = "",
    currentSpecialRequests: String = "",
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var modifications by remember { mutableStateOf(currentModifications) }
    var specialRequests by remember { mutableStateOf(currentSpecialRequests) }

    if (isVisible) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = "Order Modifications",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Text(
                        text = "Common Modifications",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )

                    val commonMods = listOf(
                        "No Onions", "Extra Sauce", "No Spice", "Extra Spice",
                        "No Cheese", "Extra Cheese", "Well Done", "Medium Rare",
                        "No Salt", "Extra Salt", "No Sugar", "Extra Sugar"
                    )

                    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        items(commonMods) { mod ->
                            FilterChip(
                                onClick = {
                                    modifications = if (modifications.contains(mod)) {
                                        modifications.replace("$mod, ", "").replace(mod, "")
                                    } else {
                                        if (modifications.isEmpty()) mod else "$modifications, $mod"
                                    }
                                },
                                label = { Text(mod) },
                                selected = modifications.contains(mod),
                                colors = FilterChipDefaults.filterChipColors(
                                    selectedContainerColor = Color.Blue.copy(alpha = 0.2f),
                                    selectedLabelColor = Color.Blue,
                                    containerColor = Color.Gray.copy(alpha = 0.1f)
                                )
                            )
                        }
                    }

                    OutlinedTextField(
                        value = modifications,
                        onValueChange = { modifications = it },
                        label = { Text("Modifications") },
                        placeholder = { Text("e.g., No onions, extra sauce") },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 2
                    )

                    OutlinedTextField(
                        value = specialRequests,
                        onValueChange = { specialRequests = it },
                        label = { Text("Special Requests") },
                        placeholder = { Text("Any instructions for kitchen") },
                        modifier = Modifier.fillMaxWidth(),
                        maxLines = 3
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    onSave(modifications, specialRequests)
                    onDismiss()
                }) {
                    Text("Save")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text("Cancel")
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderItemWithModifications(
    menuItemName: String,
    quantity: Int,
    unitPrice: Double,
    modifications: String = "",
    specialRequests: String = "",
    onModifyClick: () -> Unit,
    onQuantityChange: (Int) -> Unit,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(menuItemName, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    Text("$${String.format("%.2f", unitPrice)}", fontSize = 14.sp, color = Color.Gray)
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { if (quantity > 1) onQuantityChange(quantity - 1) }) {
                        Icon(Icons.Default.Close, contentDescription = "Decrease", tint = Color.Red)
                    }

                    Text(
                        quantity.toString(),
                        fontSize = 16.sp,
                        modifier = Modifier.width(24.dp),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )

                    IconButton(onClick = { onQuantityChange(quantity + 1) }) {
                        Icon(Icons.Default.Add, contentDescription = "Increase", tint = Color.Green)
                    }

                    IconButton(onClick = onModifyClick) {
                        Icon(Icons.Default.Edit, contentDescription = "Modify", tint = Color.Blue)
                    }

                    IconButton(onClick = onRemove) {
                        Icon(Icons.Default.Delete, contentDescription = "Remove", tint = Color.Red)
                    }
                }
            }

            if (modifications.isNotEmpty()) {
                Text(
                    "Modifications: $modifications",
                    fontSize = 12.sp,
                    color = Color.Blue
                )
            }

            if (specialRequests.isNotEmpty()) {
                Text(
                    "Special Requests: $specialRequests",
                    fontSize = 12.sp,
                    color = Color(0xFFFF9800)
                )
            }
        }
    }
}

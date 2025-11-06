package com.restaurantapp.ui.screens.admin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.restaurantapp.data.entity.Order
import androidx.compose.ui.text.font.FontWeight

@Composable
fun MiniOrderPreview(order: Order, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .size(width = 160.dp, height = 84.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = order.customerName ?: "Guest", color = Color(0xFF111827), fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(6.dp))
            StatusChip(status = order.status)
        }
    }
}

@Composable
fun LargeOrderCard(
    order: Order,
    onComplete: () -> Unit,
    onCancel: () -> Unit,
    onDetails: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Text(text = "Order #${order.id}", color = Color(0xFF111827), fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Customer: ${order.customerName ?: "Guest"}", color = Color(0xFF6B7280))
            Spacer(modifier = Modifier.height(10.dp))
            StatusChip(status = order.status)

            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                // Primary complete button (pill)
                Button(
                    onClick = onComplete,
                    modifier = Modifier.weight(1f).height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF18A558)),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text("Complete", color = Color.White)
                }

                // Cancel button
                Button(
                    onClick = onCancel,
                    modifier = Modifier.weight(1f).height(48.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF1744)),
                    shape = RoundedCornerShape(28.dp)
                ) {
                    Text("Cancel", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedButton(onClick = onDetails, modifier = Modifier.weight(1f).height(44.dp), shape = RoundedCornerShape(12.dp)) {
                    Text("Details")
                }
                OutlinedButton(onClick = onDelete, modifier = Modifier.weight(1f).height(44.dp), shape = RoundedCornerShape(12.dp)) {
                    Text("Delete")
                }
            }
        }
    }
}

@Composable
fun StatusChip(status: String?) {
    val color = when (status?.lowercase()) {
        "completed", "delivered" -> Color(0xFF00E676)
        "preparing", "pending" -> Color(0xFFFFC107)
        "cancelled" -> Color(0xFFFF1744)
        else -> Color(0xFF90A4AE)
    }
    Surface(
        shape = RoundedCornerShape(20.dp),
        color = color.copy(alpha = 0.12f),
        modifier = Modifier.padding(top = 4.dp)
    ) {
        Text(
            text = status ?: "Unknown",
            color = color,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

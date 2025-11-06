package com.restaurantapp.ui.screens.admin

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

private val OuterBackground = Color(0xFFF0F2F4)
private val SurfaceWhite = Color.White
private val MainText = Color(0xFF0B0B0B)
private val SecondaryText = Color(0xFF6B7278)
private val MutedText = Color(0xFF9EA6AC)
private val AccentTeal = Color(0xFF0E9AA7)
private val DangerRed = Color(0xFFE74C3C)

data class SampleOrderItem(
    val title: String,
    val price: Int,
    val qty: Int,
    val imageUrl: String
)
@SuppressLint("UnrememberedMutableState")
@Composable
fun OrderDetailScreen(
    orderId: Int,
    onBack: () -> Unit = {},
    onProcessPayment: (subtotal: Double, tax: Double) -> Unit = { _, _ -> }
) {
    val initialItems = listOf(
        SampleOrderItem(
            "Crispy Dory",
            75,
            1,
            "https://images.unsplash.com/photo-1525351484163-7529414344d8?w=400&q=80"
        ),
        SampleOrderItem(
            "Sarapan Orang",
            70,
            2,
            "https://images.unsplash.com/photo-1525351484163-7529414344d8?w=400&q=80"
        )
    )

    val itemsState = remember { mutableStateListOf<SampleOrderItem>().also { it.addAll(initialItems) } }

    var customerName by rememberSaveable { mutableStateOf("") }
    var tableNo by rememberSaveable { mutableStateOf("") }
    var isDineIn by remember { mutableStateOf(true) }

    val subtotal by derivedStateOf { itemsState.sumOf { it.price * it.qty }.toDouble() }
    val tax by derivedStateOf { subtotal * 0.10 }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(OuterBackground)
            .padding(20.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(30.dp),
            colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp),
                    contentPadding = PaddingValues(bottom = 92.dp)
                ) {
                    item {
                        Spacer(modifier = Modifier.height(18.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = SurfaceWhite,
                                tonalElevation = 6.dp,
                                shadowElevation = 6.dp,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clickable { onBack() }
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Default.ArrowBack,
                                        contentDescription = "Back",
                                        tint = MainText
                                    )
                                }
                            }

                            Text(
                                text = "Order #$orderId",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MainText
                            )

                            Spacer(modifier = Modifier.size(40.dp))
                        }
                    }

                    item {
                        Spacer(modifier = Modifier.height(6.dp))
                        SegmentedSwitch(isDineIn = isDineIn, onSelect = { isDineIn = it })
                    }

                    item {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Customer Information", fontWeight = FontWeight.SemiBold, color = MainText)
                        Spacer(modifier = Modifier.height(8.dp))

                        OutlinedTextField(
                            value = customerName,
                            onValueChange = { customerName = it },
                            label = { Text("Customer Name", color = MutedText) },
                            placeholder = { Text("Enter name", color = MutedText) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            textStyle = LocalTextStyle.current.copy(color = Color.Black)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = tableNo,
                            onValueChange = { tableNo = it },
                            label = { Text("Table No.", color = MutedText) },
                            placeholder = { Text("Enter or select table", color = MutedText) },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            shape = RoundedCornerShape(12.dp),
                            textStyle = LocalTextStyle.current.copy(color = Color.Black)
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                    }

                    item {
                        Text("Items", fontSize = 16.sp, fontWeight = FontWeight.SemiBold, color = MainText)
                    }

                    itemsIndexed(itemsState) { index, item ->
                        OrderItemRow(
                            item = item,
                            index = index,
                            onQtyChange = { newQty ->
                                itemsState[index] = item.copy(qty = newQty)
                            },
                            onDelete = {
                                if (index != 0) itemsState.removeAt(index)
                            }
                        )
                    }

                    // Summary
                    item {
                        OrderSummary(subtotal, tax)
                    }
                }

                // Bottom Button
                Button(
                    onClick = { onProcessPayment(subtotal, tax) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .height(56.dp)
                        .align(Alignment.BottomCenter),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
                ) {
                    Text("Process Payment", fontSize = 16.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun SegmentedSwitch(isDineIn: Boolean, onSelect: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFF2F4F6))
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val selectedColor = SurfaceWhite
        val unselectedColor = Color(0xFFF2F4F6)

        Box(
            modifier = Modifier
                .weight(1f)
                .height(44.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(if (isDineIn) selectedColor else unselectedColor)
                .clickable { onSelect(true) },
            contentAlignment = Alignment.Center
        ) {
            Text("Dine In", color = if (isDineIn) MainText else MutedText)
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .height(44.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(if (!isDineIn) selectedColor else unselectedColor)
                .clickable { onSelect(false) },
            contentAlignment = Alignment.Center
        ) {
            Text("Take Away", color = if (!isDineIn) MainText else MutedText)
        }
    }
}

@Composable
fun OrderItemRow(
    item: SampleOrderItem,
    index: Int,
    onQtyChange: (Int) -> Unit,
    onDelete: () -> Unit
) {
    var qty by remember { mutableStateOf(item.qty) }
    var offsetX by remember { mutableStateOf(0f) }
    val swipeThreshold = 100f

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 96.dp)
            .pointerInput(Unit) {
                detectHorizontalDragGestures(
                    onDragEnd = {
                        if (index == 1 && offsetX < -swipeThreshold) offsetX = -150f else offsetX = 0f
                    },
                    onHorizontalDrag = { _, dragAmount ->
                        if (index == 1) {
                            val newOffset = (offsetX + dragAmount).coerceIn(-200f, 0f)
                            offsetX = newOffset
                        }
                    }
                )
            },
        contentAlignment = Alignment.CenterStart
    ) {
        if (index == 1) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(DangerRed.copy(alpha = 0.08f)),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = {
                        offsetX = 0f
                        onDelete()
                    },
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .size(48.dp)
                        .background(DangerRed.copy(alpha = 0.15f), RoundedCornerShape(12.dp))
                ) {
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = DangerRed)
                }
            }
        }

        Row(
            modifier = Modifier
                .offset(x = offsetX.dp)
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(12.dp))
                .padding(vertical = 8.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFF2F4F6)),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = item.imageUrl,
                    contentDescription = item.title,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    item.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MainText,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "$${item.price}",
                    color = AccentTeal,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            Surface(
                shape = RoundedCornerShape(28.dp),
                color = SurfaceWhite,
                tonalElevation = 8.dp,
                shadowElevation = 8.dp,
                modifier = Modifier.height(44.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = {
                            if (qty > 0) {
                                qty -= 1
                                onQtyChange(qty)
                            }
                        },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(Icons.Default.Remove, contentDescription = "Minus", tint = SecondaryText)
                    }

                    Text(
                        qty.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(horizontal = 6.dp)
                    )

                    IconButton(
                        onClick = {
                            qty += 1
                            onQtyChange(qty)
                        },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = "Plus", tint = AccentTeal)
                    }
                }
            }
        }
    }
}
@Composable
fun OrderSummary(subtotal: Double, tax: Double) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F9FB), RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Subtotal", color = SecondaryText)
            Text("$${"%.2f".format(subtotal)}", fontWeight = FontWeight.Bold)
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Tax (10%)", color = SecondaryText)
            Text("$${"%.2f".format(tax)}", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderDetail() {
    OrderDetailScreen(orderId = 101)
}

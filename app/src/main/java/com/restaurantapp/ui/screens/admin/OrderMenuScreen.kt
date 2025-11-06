
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.zIndex
import androidx.compose.ui.geometry.Offset
import com.restaurantapp.navigation.Routes
import androidx.compose.foundation.Canvas
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.geometry.Rect
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun OrderMenuScreen(navController: NavHostController) {
    val backgroundColor = Color(0xFFEEF2F5)
    val headerBg = Color(0xFF0D0D0F)
    val cardsOffset = (-30).dp

    val orders = listOf(
        OrderPreview(id = 12532, name = "Vinicius Bayu", subtitle = "3 Items • Table 3", status = "Ready to Serve"),
        OrderPreview(id = 12533, name = "Kylian Rex", subtitle = "2 Items • Table 5", status = "Waiting"),
        OrderPreview(id = 12534, name = "Ed Bermi", subtitle = "1 Item • Table 1", status = "Completed")
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {

        Card(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier.fillMaxSize(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(260.dp)
                        .align(Alignment.TopCenter),
                    color = headerBg,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        Canvas(modifier = Modifier.fillMaxSize()) {
                            val strokeWidth = size.minDimension * 0.006f
                            val alpha = 0.06f
                            val rings = 5
                            for (i in 0 until rings) {
                                val inset = i * (size.minDimension * 0.06f)
                                val rect = Rect(
                                    left = inset,
                                    top = inset,
                                    right = size.width - inset,
                                    bottom = size.height * 2f - inset
                                )
                                drawArc(
                                    color = Color.White.copy(alpha = alpha),
                                    startAngle = 180f,
                                    sweepAngle = 180f,
                                    useCenter = false,
                                    topLeft = Offset(rect.left, rect.top),
                                    size = androidx.compose.ui.geometry.Size(rect.width, rect.height),
                                    style = Stroke(width = strokeWidth)
                                )
                            }
                        }
                    }
                }

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 120.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        Column {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp, end = 20.dp, top = 18.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    AsyncImage(
                                        model = "https://images.unsplash.com/photo-1544005313-94ddf0286df2?w=300&q=60",
                                        contentDescription = "Header Image",
                                        modifier = Modifier
                                            .size(56.dp)
                                            .clip(CircleShape)
                                            .border(width = 2.dp, color = Color.White.copy(alpha = 0.08f), shape = CircleShape),
                                        contentScale = ContentScale.Crop
                                    )

                                    Spacer(modifier = Modifier.width(12.dp))
                                    Text(
                                        "Cheryl Sasaji",
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                    CircleIconButton(Icons.Default.Search) { }
                                    CircleIconButton(Icons.Default.Menu) { }
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "Order List",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White.copy(alpha = 0.95f)
                                )
                                Text(
                                    text = "See All",
                                    color = Color.Gray,
                                    fontSize = 14.sp
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            LazyRow(
                                modifier = Modifier
                                    .padding(start = 20.dp)
                                    .offset(y = cardsOffset)
                                    .zIndex(2f),
                                horizontalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(orders) { order ->
                                    OrderCardPreview(order = order) {
                                        Log.d("NAV", "Order card clicked -> ${order.id}")
                                        navController.navigate("${Routes.ORDER_DETAIL}/${order.id}")
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(28.dp))

                            var selected by remember { mutableStateOf("Food") }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 20.dp),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Surface(
                                    modifier = Modifier
                                        .height(50.dp)
                                        .width(220.dp),
                                    shape = RoundedCornerShape(25.dp),
                                    color = Color(0xFFF2F4F6)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                        SegmentedButton("Food", selected == "Food") {
                                            selected = "Food"
                                        }
                                        SegmentedButton("Beverage", selected == "Beverage") {
                                            selected = "Beverage"
                                        }
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(24.dp))

                            Text(
                                text = "Select Menu",
                                modifier = Modifier.padding(horizontal = 20.dp),
                                fontSize = 18.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    item {
                        val products = listOf(
                            Product(
                                "Crispy Dory Sambal Matah", "$70", 23,
                                "https://images.unsplash.com/photo-1617196039954-7d4f3e2d32d5?w=400&q=80"
                            ),
                            Product(
                                "Sarapan Orang Kaya", "$75", 23,
                                "https://images.unsplash.com/photo-1525351484163-7529414344d8?w=400&q=80"
                            ),
                            Product(
                                "Grilled Chicken", "$85", 20,
                                "https://images.unsplash.com/photo-1604908177225-6df98d82b0a6?w=400&q=80"
                            ),
                            Product(
                                "Beef Teriyaki Bowl", "$90", 18,
                                "https://images.unsplash.com/photo-1617196039954-7d4f3e2d32d5?w=400&q=80"
                            )
                        )

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(max = 1200.dp)
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            userScrollEnabled = false
                        ) {
                            items(products) { product ->
                                ProductCard(product)
                            }
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 12.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Spacer(modifier = Modifier.height(20.dp)) // prevents overlap
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                            .height(64.dp)
                            .clip(RoundedCornerShape(36.dp))
                            .background(Color.Black),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 18.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = Modifier.size(20.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "$245",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "3 Items",
                                color = Color.White.copy(alpha = 0.8f),
                                fontSize = 14.sp
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            Text(
                                text = "Process Transaction",
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                fontSize = 15.sp
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CircleIconButton(icon: ImageVector, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.12f))
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(icon, contentDescription = null, tint = Color.White)
    }
}

data class OrderPreview(val id: Int, val name: String, val subtitle: String, val status: String)

@Composable
fun OrderCardPreview(order: OrderPreview, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(180.dp)
            .height(120.dp)
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(order.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(order.subtitle, color = Color.Gray, fontSize = 13.sp)
            }
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(
                        when (order.status) {
                            "Ready to Serve" -> Color(0xFFE7F7F8)
                            "Waiting" -> Color(0xFFFFF1E8)
                            else -> Color(0xFFEAF4FF)
                        }
                    )
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    order.status,
                    color = when (order.status) {
                        "Ready to Serve" -> Color(0xFF0E9AA7)
                        "Waiting" -> Color(0xFFFF9F6B)
                        else -> Color(0xFF4A90E2)
                    },
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun SegmentedButton(label: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .height(36.dp)
            .width(90.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        color = if (selected) Color.White else Color(0xFFF2F4F6),
        tonalElevation = if (selected) 6.dp else 0.dp,
        shadowElevation = if (selected) 4.dp else 0.dp
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(
                text = label,
                color = if (selected) Color.Black else Color.Gray,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
            )
        }
    }
}

data class Product(val title: String, val price: String, val stock: Int, val imageUrl: String)

@Composable
fun ProductCard(product: Product) {
    Card(
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier.height(230.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(product.title, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
            Text(
                "Delicious and popular item loved by customers.",
                color = Color.Gray,
                fontSize = 12.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Stock: ${product.stock}", color = Color.Gray, fontSize = 12.sp)
                Text(product.price, color = Color(0xFF0E9AA7), fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFEEF2F5)
@Composable
fun PreviewOrderMenuScreen() {
    val navController = rememberNavController()
    OrderMenuScreen(navController = navController)
}
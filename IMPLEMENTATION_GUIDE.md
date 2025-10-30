# Restaurant Management App - Advanced Features Implementation Guide

This guide provides step-by-step instructions for implementing advanced features in the Restaurant Management App using Android Studio.

## 📋 **Prerequisites**

- Android Studio Hedgehog (2023.1.1) or later
- Android SDK API Level 24+ (Android 7.0)
- Kotlin 1.9.10+
- Basic knowledge of Android development
- Existing Restaurant Management App project

## 🚀 **Feature Implementation Guide**

### **1. Dark Mode Support** ⭐⭐⭐⭐⭐

#### **Step 1: Update Theme Files**

**File: `app/src/main/java/com/restaurantapp/ui/theme/Color.kt`**
```kotlin
package com.restaurantapp.ui.theme

import androidx.compose.ui.graphics.Color

// Light Theme Colors
val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

// Dark Theme Colors
val DarkBackground = Color(0xFF121212)
val DarkSurface = Color(0xFF1E1E1E)
val DarkPrimary = Color(0xFFBB86FC)
val DarkSecondary = Color(0xFF03DAC6)
val DarkError = Color(0xFFCF6679)
val DarkOnBackground = Color(0xFFFFFFFF)
val DarkOnSurface = Color(0xFFFFFFFF)
val DarkOnPrimary = Color(0xFF000000)
val DarkOnSecondary = Color(0xFF000000)
val DarkOnError = Color(0xFF000000)

// Restaurant App Specific Colors
val RestaurantDarkBackground = Color(0xFF1A1A1A)
val RestaurantDarkSurface = Color(0xFF2D2D2D)
val RestaurantDarkPrimary = Color(0xFF4CAF50)
val RestaurantDarkSecondary = Color(0xFF2196F3)
val RestaurantDarkText = Color(0xFFE0E0E0)
val RestaurantDarkTextSecondary = Color(0xFFB0B0B0)
```

**File: `app/src/main/java/com/restaurantapp/ui/theme/Theme.kt`**
```kotlin
package com.restaurantapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = RestaurantDarkPrimary,
    secondary = RestaurantDarkSecondary,
    tertiary = RestaurantDarkSecondary,
    background = RestaurantDarkBackground,
    surface = RestaurantDarkSurface,
    onPrimary = DarkOnPrimary,
    onSecondary = DarkOnSecondary,
    onBackground = RestaurantDarkText,
    onSurface = RestaurantDarkText,
    onSurfaceVariant = RestaurantDarkTextSecondary
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun RestaurantAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
```

#### **Step 2: Add Dark Mode Toggle**

**File: `app/src/main/java/com/restaurantapp/ui/components/DarkModeToggle.kt`**
```kotlin
package com.restaurantapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

@Composable
fun DarkModeToggle(
    isDarkMode: Boolean,
    onToggle: (Boolean) -> Unit
) {
    IconButton(
        onClick = { onToggle(!isDarkMode) }
    ) {
        Icon(
            imageVector = if (isDarkMode) Icons.Default.LightMode else Icons.Default.DarkMode,
            contentDescription = if (isDarkMode) "Light Mode" else "Dark Mode",
            tint = Color.Unspecified
        )
    }
}
```

#### **Step 3: Update MainActivity**

**File: `app/src/main/java/com/restaurantapp/MainActivity.kt`**
```kotlin
package com.restaurantapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.restaurantapp.navigation.RestaurantNavigation
import com.restaurantapp.ui.theme.RestaurantAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by remember { mutableStateOf(false) }
            
            RestaurantAppTheme(darkTheme = isDarkMode) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    RestaurantNavigation(navController = navController)
                }
            }
        }
    }
}
```

---

### **2. QR Code Menu Integration** ⭐⭐⭐⭐⭐

#### **Step 1: Add Dependencies**

**File: `app/build.gradle.kts`**
```kotlin
dependencies {
    // Existing dependencies...
    
    // QR Code generation and scanning
    implementation("com.journeyapps:zxing-android-embedded:4.3.0")
    implementation("com.google.zxing:core:3.5.2")
    
    // Camera for QR scanning
    implementation("androidx.camera:camera-core:1.3.1")
    implementation("androidx.camera:camera-camera2:1.3.1")
    implementation("androidx.camera:camera-lifecycle:1.3.1")
    implementation("androidx.camera:camera-view:1.3.1")
}
```

#### **Step 2: Add Permissions**

**File: `app/src/main/AndroidManifest.xml`**
```xml
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.INTERNET" />
```

#### **Step 3: Create QR Code Components**

**File: `app/src/main/java/com/restaurantapp/ui/components/QRCodeComponents.kt`**
```kotlin
package com.restaurantapp.ui.components

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter
import java.util.*

@Composable
fun QRCodeGenerator(
    data: String,
    size: Int = 200,
    modifier: Modifier = Modifier
) {
    val bitmap = remember(data, size) {
        generateQRCode(data, size)
    }
    
    bitmap?.let {
        Card(
            modifier = modifier,
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    bitmap = it.asImageBitmap(),
                    contentDescription = "QR Code",
                    modifier = Modifier.size(size.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Scan to view menu",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

private fun generateQRCode(data: String, size: Int): Bitmap? {
    return try {
        val writer = QRCodeWriter()
        val hints = EnumMap<EncodeHintType, Any>(EncodeHintType::class.java)
        hints[EncodeHintType.CHARACTER_SET] = "UTF-8"
        hints[EncodeHintType.MARGIN] = 1
        
        val bitMatrix = writer.encode(data, BarcodeFormat.QR_CODE, size, size, hints)
        val width = bitMatrix.width
        val height = bitMatrix.height
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
        
        for (x in 0 until width) {
            for (y in 0 until height) {
                bitmap.setPixel(x, y, if (bitMatrix[x, y]) Color.BLACK else Color.WHITE)
            }
        }
        bitmap
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}

@Composable
fun QRCodeScanner(
    onQRCodeScanned: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // QR Scanner implementation using ZXing
    // This would integrate with the camera to scan QR codes
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "QR Scanner Placeholder",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
```

#### **Step 4: Create QR Menu Screen**

**File: `app/src/main/java/com/restaurantapp/ui/screens/QRMenuScreen.kt`**
```kotlin
package com.restaurantapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.restaurantapp.ui.components.MenuItemImage
import com.restaurantapp.ui.components.QRCodeGenerator
import com.restaurantapp.ui.viewmodel.OrderListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QRMenuScreen(
    navController: NavController,
    viewModel: OrderListViewModel = hiltViewModel()
) {
    val menuItems by viewModel.menuItems.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    
    val menuUrl = "https://restaurant-app.com/menu?table=current"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header
        TopAppBar(
            title = {
                Text(
                    text = "QR Code Menu",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // QR Code Section
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Scan QR Code to Access Digital Menu",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        
                        Spacer(modifier = Modifier.height(16.dp))
                        
                        QRCodeGenerator(
                            data = menuUrl,
                            size = 200,
                            modifier = Modifier.fillMaxWidth()
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "Point your camera at the QR code to view our digital menu",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

            // Menu Preview
            item {
                Text(
                    text = "Menu Preview",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            items(menuItems.take(4)) { menuItem ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        MenuItemImage(
                            menuItem = menuItem,
                            modifier = Modifier.size(60.dp)
                        )
                        
                        Spacer(modifier = Modifier.width(12.dp))
                        
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = menuItem.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = menuItem.description,
                                fontSize = 12.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                maxLines = 2
                            )
                        }
                        
                        Text(
                            text = "$${String.format("%.0f", menuItem.price)}",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}
```

---

### **3. Push Notifications** ⭐⭐⭐⭐⭐

#### **Step 1: Add Firebase Dependencies**

**File: `app/build.gradle.kts`**
```kotlin
plugins {
    // Existing plugins...
    id("com.google.gms.google-services") version "4.4.0" apply false
}

dependencies {
    // Existing dependencies...
    
    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
}
```

#### **Step 2: Create Firebase Service**

**File: `app/src/main/java/com/restaurantapp/services/NotificationService.kt`**
```kotlin
package com.restaurantapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.restaurantapp.MainActivity
import com.restaurantapp.R

class NotificationService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        // Handle data payload
        remoteMessage.data.isNotEmpty().let {
            val title = remoteMessage.data["title"] ?: "Restaurant Notification"
            val body = remoteMessage.data["body"] ?: "You have a new notification"
            val type = remoteMessage.data["type"] ?: "general"
            
            showNotification(title, body, type)
        }

        // Handle notification payload
        remoteMessage.notification?.let {
            showNotification(
                it.title ?: "Restaurant Notification",
                it.body ?: "You have a new notification",
                "general"
            )
        }
    }

    private fun showNotification(title: String, body: String, type: String) {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("notification_type", type)
        }

        val pendingIntent = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val channelId = "restaurant_channel"
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle(title)
            .setContentText(body)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Restaurant Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notifications for restaurant operations"
            }
            notificationManager.createNotificationChannel(channel)
        }

        notificationManager.notify(0, notificationBuilder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        // Send token to server
        sendTokenToServer(token)
    }

    private fun sendTokenToServer(token: String) {
        // Implement token sending to your server
        // This is where you'd save the token for sending notifications
    }
}
```

#### **Step 3: Add Notification Icon**

**File: `app/src/main/res/drawable/ic_notification.xml`**
```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24"
    android:tint="?attr/colorOnSurface">
  <path
      android:fillColor="@android:color/white"
      android:pathData="M12,22c1.1,0 2,-0.9 2,-2h-4c0,1.1 0.9,2 2,2zM18,16v-5c0,-3.07 -1.64,-5.64 -4.5,-6.32V4c0,-0.83 -0.67,-1.5 -1.5,-1.5s-1.5,0.67 -1.5,1.5v0.68C7.63,5.36 6,7.92 6,11v5l-2,2v1h16v-1l-2,-2z"/>
</vector>
```

#### **Step 4: Update AndroidManifest**

**File: `app/src/main/AndroidManifest.xml`**
```xml
<application>
    <!-- Existing application content -->
    
    <service
        android:name=".services.NotificationService"
        android:exported="false">
        <intent-filter>
            <action android:name="com.google.firebase.MESSAGING_EVENT" />
        </intent-filter>
    </service>
</application>
```

---

### **4. Enhanced Analytics Dashboard** ⭐⭐⭐⭐

#### **Step 1: Create Advanced Chart Components**

**File: `app/src/main/java/com/restaurantapp/ui/components/AdvancedCharts.kt`**
```kotlin
package com.restaurantapp.ui.components

import android.content.Context
import android.graphics.Color
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.restaurantapp.data.entity.SalesData

@Composable
fun SalesBarChart(
    salesData: List<SalesData>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    AndroidView(
        factory = { context ->
            BarChart(context).apply {
                setupBarChart()
            }
        },
        update = { chart ->
            chart.setupBarChart()
            chart.setBarData(salesData)
        },
        modifier = modifier.height(250.dp)
    )
}

private fun BarChart.setupBarChart() {
    description.isEnabled = false
    setTouchEnabled(true)
    isDragEnabled = true
    setScaleEnabled(true)
    setPinchZoom(true)
    
    setBackgroundColor(Color.WHITE)
    legend.isEnabled = false
    
    xAxis.apply {
        position = XAxis.XAxisPosition.BOTTOM
        setDrawGridLines(false)
        setDrawAxisLine(true)
        textColor = Color.BLACK
        textSize = 12f
    }
    
    axisLeft.apply {
        setDrawGridLines(true)
        setDrawAxisLine(true)
        textColor = Color.BLACK
        textSize = 12f
        axisMinimum = 0f
    }
    
    axisRight.isEnabled = false
    animateY(1000)
}

private fun BarChart.setBarData(salesData: List<SalesData>) {
    if (salesData.isEmpty()) return
    
    val entries = mutableListOf<BarEntry>()
    val labels = mutableListOf<String>()
    
    salesData.sortedBy { it.date }.forEachIndexed { index, data ->
        entries.add(BarEntry(index.toFloat(), data.totalSales.toFloat()))
        
        val dateFormat = java.text.SimpleDateFormat("MMM dd", java.util.Locale.getDefault())
        val date = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault()).parse(data.date)
        labels.add(dateFormat.format(date ?: java.util.Date()))
    }
    
    val dataSet = BarDataSet(entries, "Sales").apply {
        color = Color.parseColor("#4CAF50")
        setDrawValues(false)
    }
    
    val barData = BarData(dataSet)
    data = barData
    
    xAxis.valueFormatter = object : ValueFormatter() {
        override fun getFormattedValue(value: Float): String {
            val index = value.toInt()
            return if (index < labels.size) labels[index] else ""
        }
    }
    
    invalidate()
}

@Composable
fun CategoryPieChart(
    foodSales: Double,
    beverageSales: Double,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    AndroidView(
        factory = { context ->
            PieChart(context).apply {
                setupPieChart()
            }
        },
        update = { chart ->
            chart.setupPieChart()
            chart.setPieData(foodSales, beverageSales)
        },
        modifier = modifier.height(250.dp)
    )
}

private fun PieChart.setupPieChart() {
    description.isEnabled = false
    setTouchEnabled(true)
    isRotationEnabled = true
    isHighlightPerTapEnabled = true
    
    setBackgroundColor(Color.WHITE)
    legend.isEnabled = true
    legend.textSize = 12f
    
    animateY(1000)
}

private fun PieChart.setPieData(foodSales: Double, beverageSales: Double) {
    val entries = listOf(
        PieEntry(foodSales.toFloat(), "Food"),
        PieEntry(beverageSales.toFloat(), "Beverage")
    )
    
    val dataSet = PieDataSet(entries, "Sales by Category").apply {
        colors = listOf(
            Color.parseColor("#4CAF50"),
            Color.parseColor("#2196F3")
        )
        setDrawValues(true)
        valueTextSize = 12f
        valueTextColor = Color.WHITE
    }
    
    val pieData = PieData(dataSet)
    data = pieData
    
    invalidate()
}
```

---

### **5. Inventory Management** ⭐⭐⭐⭐

#### **Step 1: Create Inventory Entity**

**File: `app/src/main/java/com/restaurantapp/data/entity/Inventory.kt`**
```kotlin
package com.restaurantapp.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inventory")
data class InventoryItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val category: String, // "Food", "Beverage", "Supplies"
    val currentStock: Int,
    val minimumStock: Int,
    val unit: String, // "kg", "liters", "pieces"
    val costPerUnit: Double,
    val supplier: String,
    val lastUpdated: Long = System.currentTimeMillis(),
    val expiryDate: Long? = null
)

@Entity(tableName = "stock_movements")
data class StockMovement(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val inventoryItemId: Int,
    val movementType: String, // "IN", "OUT", "ADJUSTMENT"
    val quantity: Int,
    val reason: String,
    val timestamp: Long = System.currentTimeMillis(),
    val performedBy: String
)
```

#### **Step 2: Create Inventory DAO**

**File: `app/src/main/java/com/restaurantapp/data/dao/InventoryDao.kt`**
```kotlin
package com.restaurantapp.data.dao

import androidx.room.*
import com.restaurantapp.data.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {
    @Query("SELECT * FROM inventory ORDER BY name ASC")
    fun getAllInventoryItems(): Flow<List<InventoryItem>>

    @Query("SELECT * FROM inventory WHERE currentStock <= minimumStock")
    fun getLowStockItems(): Flow<List<InventoryItem>>

    @Query("SELECT * FROM inventory WHERE category = :category")
    fun getInventoryByCategory(category: String): Flow<List<InventoryItem>>

    @Query("SELECT * FROM inventory WHERE id = :id")
    suspend fun getInventoryItemById(id: Int): InventoryItem?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInventoryItem(item: InventoryItem)

    @Update
    suspend fun updateInventoryItem(item: InventoryItem)

    @Delete
    suspend fun deleteInventoryItem(item: InventoryItem)

    @Query("UPDATE inventory SET currentStock = :newStock WHERE id = :id")
    suspend fun updateStock(id: Int, newStock: Int)

    // Stock Movements
    @Query("SELECT * FROM stock_movements WHERE inventoryItemId = :itemId ORDER BY timestamp DESC")
    fun getStockMovements(itemId: Int): Flow<List<StockMovement>>

    @Insert
    suspend fun insertStockMovement(movement: StockMovement)
}
```

---

## 🔧 **Implementation Steps**

### **Step 1: Project Setup**
1. Open Android Studio
2. Open your existing Restaurant Management App project
3. Ensure all dependencies are synced

### **Step 2: Feature Implementation Order**
1. **Dark Mode** (30 minutes)
2. **QR Code Menu** (1-2 hours)
3. **Push Notifications** (2-3 hours)
4. **Enhanced Analytics** (1-2 hours)
5. **Inventory Management** (3-4 hours)

### **Step 3: Testing**
1. Test each feature individually
2. Test feature interactions
3. Test on different devices
4. Test in different orientations

### **Step 4: Deployment**
1. Build release APK
2. Test on production devices
3. Deploy to Google Play Store

## 📱 **Testing Checklist**

### **Dark Mode Testing**
- [ ] Toggle works correctly
- [ ] All screens adapt to dark theme
- [ ] Text remains readable
- [ ] Images display properly
- [ ] Charts work in dark mode

### **QR Code Testing**
- [ ] QR code generates correctly
- [ ] QR code is scannable
- [ ] Menu displays properly
- [ ] Navigation works
- [ ] Works on different screen sizes

### **Push Notifications Testing**
- [ ] Notifications appear
- [ ] Clicking notification opens app
- [ ] Different notification types work
- [ ] Background notifications work
- [ ] Notification settings work

## 🚨 **Common Issues & Solutions**

### **Build Errors**
```bash
# Clean and rebuild
./gradlew clean
./gradlew build

# Invalidate caches
File → Invalidate Caches and Restart
```

### **Permission Issues**
```xml
<!-- Add to AndroidManifest.xml -->
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.INTERNET" />
```

### **Firebase Setup**
1. Create Firebase project
2. Add Android app
3. Download `google-services.json`
4. Place in `app/` directory

## 📚 **Additional Resources**

- [Android Developer Documentation](https://developer.android.com/)
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Firebase Documentation](https://firebase.google.com/docs)
- [MPAndroidChart Documentation](https://github.com/PhilJay/MPAndroidChart)

## 🎯 **Next Steps**

After implementing these features:

1. **User Testing**: Get feedback from restaurant staff
2. **Performance Optimization**: Monitor app performance
3. **Feature Refinement**: Improve based on usage
4. **Additional Features**: Implement more advanced features
5. **Deployment**: Deploy to production

---

**Happy Coding! 🚀**

This guide provides a comprehensive roadmap for implementing advanced features in your Restaurant Management App. Each feature is designed to enhance the user experience and provide real-world restaurant management capabilities.

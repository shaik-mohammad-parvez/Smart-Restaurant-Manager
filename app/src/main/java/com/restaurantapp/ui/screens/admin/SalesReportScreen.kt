package com.restaurantapp.ui.screens.admin

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.restaurantapp.ui.components.SalesChart
import com.restaurantapp.ui.components.ProfitChart
import com.restaurantapp.ui.viewmodel.SalesViewModel
import com.restaurantapp.ui.screens.admin.components.SummaryCard
import com.restaurantapp.utils.PdfGenerator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalesReportScreen(
    navController: NavController,
    viewModel: SalesViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val salesData by viewModel.salesList.collectAsState()

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (!isGranted) {
            Toast.makeText(context, "Permission Required To Save PDF!", Toast.LENGTH_LONG).show()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sales Report", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1E1E1E)
                )
            )
        },
        containerColor = Color.Transparent
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF000000), Color(0xFF2B0000))
                    )
                )
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🔹 Title
            Text(
                text = "Sales Analytics",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 🔹 Summary Cards
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SummaryCard(
                    title = "Total Sales",
                    value = "₹${salesData.sumOf { it.totalSales }}",
                    modifier = Modifier.weight(1f),
                    titleColor = Color.White,
                    valueColor = Color(0xFFFF1744)
                )
                SummaryCard(
                    title = "Total Profit",
                    value = "₹${salesData.sumOf { it.totalProfit }}",
                    modifier = Modifier.weight(1f),
                    titleColor = Color.White,
                    valueColor = Color(0xFF00E676)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // 🔹 Charts Section
            Text(
                text = "Sales Trend",
                fontSize = 18.sp,
                color = Color(0xFFFF1744),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            SalesChart(salesData = salesData, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Profit Trend",
                fontSize = 18.sp,
                color = Color(0xFF00E676),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(8.dp))
            ProfitChart(salesData = salesData, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(32.dp))

            // 🔹 Download PDF Button
            Button(
                onClick = {
                    if (ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        val pdfPath = PdfGenerator.generateSalesReport(context, salesData)
                        Toast.makeText(context, "PDF Saved to: $pdfPath", Toast.LENGTH_LONG).show()
                    } else {
                        requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF1744)),
                shape = RoundedCornerShape(40.dp)
            ) {
                Text(
                    text = "Download Sales Report PDF",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

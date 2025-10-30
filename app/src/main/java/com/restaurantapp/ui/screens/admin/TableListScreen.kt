package com.restaurantapp.ui.screens.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.restaurantapp.data.entity.RestaurantTable
import com.restaurantapp.navigation.Routes
import com.restaurantapp.ui.viewmodel.AdminTableViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TableListScreen(
    navController: NavHostController,
    viewModel: AdminTableViewModel = hiltViewModel()
) {
    val tableList by viewModel.tables.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Manage Tables", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1E1E1E)
                ),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(Routes.ADD_TABLE) }) {
                        Icon(Icons.Default.Add, contentDescription = "Add Table", tint = Color.White)
                    }
                }
            )
        },
        containerColor = Color.Transparent
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color(0xFF000000), Color(0xFF2B0000))
                    )
                )
                .padding(padding)
        ) {
            if (tableList.isEmpty()) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("No tables found. Add new tables.", color = Color.LightGray)
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(tableList) { table ->
                        TableItemRow(
                            table = table,
                            onEdit = { navController.navigate("${Routes.EDIT_TABLE}/${table.id}") },
                            onDelete = { viewModel.deleteTable(table) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TableItemRow(
    table: RestaurantTable,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Table No: ${table.tableNumber}",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Capacity: ${table.capacity}",
                color = Color(0xFFFF1744),
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Location: ${table.location}",
                color = Color(0xFFBDBDBD)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onEdit,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2979FF)),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Edit", color = Color.White)
                }

                Spacer(modifier = Modifier.width(12.dp))

                Button(
                    onClick = onDelete,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF1744)),
                    shape = RoundedCornerShape(30.dp),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Delete", color = Color.White)
                }
            }
        }
    }
}

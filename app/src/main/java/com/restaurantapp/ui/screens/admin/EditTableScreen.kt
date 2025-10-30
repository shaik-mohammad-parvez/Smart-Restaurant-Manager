package com.restaurantapp.ui.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.restaurantapp.data.entity.RestaurantTable
import com.restaurantapp.ui.viewmodel.AdminTableViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTableScreen(
    navController: NavHostController,
    tableId: Int?,
    viewModel: AdminTableViewModel = hiltViewModel()
) {
    val tableList by viewModel.tables.collectAsState()
    val selectedTable = tableList.find { it.id == tableId }

    var tableNumber by remember { mutableStateOf(selectedTable?.tableNumber ?: "") }
    var capacity by remember { mutableStateOf(selectedTable?.capacity?.toString() ?: "") }
    var location by remember { mutableStateOf(selectedTable?.location ?: "") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Edit Table") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (selectedTable == null) {
            Box(modifier = Modifier.padding(padding).fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("Table not found")
            }
        } else {
            Column(modifier = Modifier.padding(padding).padding(16.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                OutlinedTextField(value = tableNumber, onValueChange = { tableNumber = it }, label = { Text("Table Number") }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = capacity, onValueChange = { capacity = it }, label = { Text("Capacity") }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") }, modifier = Modifier.fillMaxWidth())
                Spacer(Modifier.height(16.dp))

                Button(onClick = {
                    val updated = RestaurantTable(id = selectedTable.id, tableNumber = tableNumber, capacity = capacity.toIntOrNull() ?: 1, location = location)
                    viewModel.updateTable(updated)
                    navController.popBackStack()
                }, modifier = Modifier.fillMaxWidth()) {
                    Text("Update Table")
                }
            }
        }
    }
}

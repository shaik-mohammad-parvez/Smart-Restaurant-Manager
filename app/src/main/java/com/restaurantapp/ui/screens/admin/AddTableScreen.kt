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
fun AddTableScreen(
    navController: NavHostController,
    viewModel: AdminTableViewModel = hiltViewModel()
) {
    var tableNumber by remember { mutableStateOf("") }
    var capacity by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Table") },
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
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(value = tableNumber, onValueChange = { tableNumber = it }, label = { Text("Table Number") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(value = capacity, onValueChange = { capacity = it }, label = { Text("Capacity") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(value = location, onValueChange = { location = it }, label = { Text("Location") }, modifier = Modifier.fillMaxWidth())
            Spacer(Modifier.height(16.dp))

            Button(onClick = {
                if (tableNumber.isNotBlank() && capacity.isNotBlank()) {
                    val table = RestaurantTable(tableNumber = tableNumber, capacity = capacity.toIntOrNull() ?: 1, location = location)
                    viewModel.addTable(table)
                    navController.popBackStack()
                }
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Save Table")
            }
        }
    }
}

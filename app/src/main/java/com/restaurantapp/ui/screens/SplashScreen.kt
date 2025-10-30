package com.restaurantapp.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val appName = "RestaurantApp 🍽️"
    var displayedText by remember { mutableStateOf("") }
    var finishedTyping by remember { mutableStateOf(false) }
    var visible by remember { mutableStateOf(false) }

    // Fade-out animation
    val alpha by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(durationMillis = 1000),
        label = "fadeAlpha"
    )

    // Typing animation
    LaunchedEffect(Unit) {
        for (i in appName.indices) {
            displayedText = appName.substring(0, i + 1)
            delay(120) // typing speed per letter
        }
        delay(1000)
        finishedTyping = true
        delay(500)
        visible = true
        delay(1000)
        navController.navigate("login") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Background restaurant image
        Image(
            painter = rememberAsyncImagePainter("https://images.unsplash.com/photo-1555396273-367ea4eb4db5"),
            contentDescription = "Restaurant Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Dark overlay for contrast
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xAA000000))
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.alpha(alpha)
        ) {
            Text(
                text = displayedText,
                color = Color(0xFFFFD700),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            if (finishedTyping) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Deliciousness at your fingertips 😋",
                    color = Color.White,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

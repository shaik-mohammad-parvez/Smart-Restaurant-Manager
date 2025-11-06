package com.restaurantapp.ui.screens.admin.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.restaurantapp.ui.theme.CardBackground
import androidx.compose.ui.graphics.Color

@Composable
fun SummaryCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
    titleColor: Color = Color(0xFF9CA3AF),
    valueColor: Color = Color(0xFF2EA6F0)
) {
    Card(
        modifier = modifier
            .height(96.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = title, color = titleColor, fontSize = 12.sp)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(text = value, color = valueColor, fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
            }
        }
    }
}

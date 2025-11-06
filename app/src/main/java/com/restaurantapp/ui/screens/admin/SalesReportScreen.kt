// SalesReportScreen.kt
package com.restaurantapp.ui.screens.admin

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocalCafe
import androidx.compose.material.icons.filled.LocalDining
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.max

// ---------- Colors ----------
private val OuterBackground = Color(0xFFF0F2F4)
private val SurfaceWhite = Color(0xFFFFFFFF)
private val MainText = Color(0xFF0B0B0B)
private val MutedText = Color(0xFF9EA6AC)
private val SegmentedUnselected = Color(0xFFF2F4F6)
private val AccentTeal = Color(0xFF0E9AA7)
private val AccentTealStroke = Color(0xFF0B8F88)
private val CardTintTeal = Color(0xFFE9F9F7)
private val CardTintPurple = Color(0xFFF6EEF9)
private val CardTintPeach = Color(0xFFFFF6F2)
private val CardTintBlue = Color(0xFFEEF7FF)
// -----------------------------

/*
  IMPORTANT: this SAMPLE_VALUES array controls the exact polygon that becomes the green line.
  I've selected values to make a sharp, jagged shape close to your red overlay while keeping:
  - start near $1K
  - mid-week peak between $10k-$15k
  - end about $15k
  Edit these numbers to nudge the shape pixel-for-pixel.
*/
private val SAMPLE_DAYS = listOf("S", "M", "T", "W", "T", "F", "S")

// UPDATED: intentionally jagged values to follow the red trace closely (straight segments)
private val SAMPLE_VALUES = listOf(
    3000f,  // S -> $1K start
    3000f,  // M -> same $1K to make a perfectly horizontal line
    5200f,  // T -> jump up sharply (forms first corner)
    11400f, // W -> peak ~11.4K
    800f,   // T -> sharp drop
    10500f, // F -> steep climb
    10500f  // S -> final ~15K
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SalesReportScreen(
    modifier: Modifier = Modifier,
    days: List<String> = SAMPLE_DAYS,
    values: List<Float> = SAMPLE_VALUES,
    onBack: () -> Unit = {}
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(OuterBackground)
    ) { _ ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.94f),
                shape = RoundedCornerShape(28.dp),
                colors = CardDefaults.cardColors(containerColor = SurfaceWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)
                        .padding(top = 18.dp, bottom = 20.dp)
                ) {
                    // Top bar
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            modifier = Modifier
                                .size(40.dp)
                                .clickable { onBack() }, // TODO: wire navigation back
                            shape = CircleShape,
                            color = SurfaceWhite,
                            tonalElevation = 6.dp,
                            shadowElevation = 6.dp
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = MainText,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }

                        Text(
                            text = "Sales Statistic",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = MainText
                        )

                        Spacer(modifier = Modifier.size(40.dp))
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    // Segmented control
                    var selectedRange by remember { mutableStateOf("1W") }
                    TimeRangeSegmentedControl(selected = selectedRange, onSelect = { selectedRange = it })

                    Spacer(modifier = Modifier.height(18.dp))

                    // Chart area (ChartComposable draws axis & chart)
                    val chartHeight = 260.dp
                    Box(modifier = Modifier.fillMaxWidth()) {
                        ChartComposable(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(chartHeight),
                            data = values,
                            days = days,
                            peakLabel = "11.4K Income"
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Metric cards (icons top)
                    Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            MetricCardTopIcon(
                                modifier = Modifier.weight(1f),
                                tint = CardTintTeal,
                                iconVector = Icons.Default.AccountBalanceWallet,
                                label = "Total profit",
                                value = "$3,423",
                                caption = null
                            )
                            MetricCardTopIcon(
                                modifier = Modifier.weight(1f),
                                tint = CardTintPurple,
                                iconVector = Icons.Default.ShowChart,
                                label = "Average sale",
                                value = "$2,423",
                                caption = null
                            )
                        }

                        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            MetricCardTopIcon(
                                modifier = Modifier.weight(1f),
                                tint = CardTintPeach,
                                iconVector = Icons.Default.LocalDining,
                                label = "Food sales",
                                value = "$1,753",
                                caption = "75 items"
                            )
                            MetricCardTopIcon(
                                modifier = Modifier.weight(1f),
                                tint = CardTintBlue,
                                iconVector = Icons.Default.LocalCafe,
                                label = "Beverage sales",
                                value = "$1,670",
                                caption = "28 items"
                            )
                        }
                    }
                }
            }
        }
    }
}

// Segmented control (unchanged)
@Composable
fun TimeRangeSegmentedControl(
    modifier: Modifier = Modifier,
    selected: String,
    onSelect: (String) -> Unit
) {
    val options = listOf("1D", "1W", "1M", "1Y")
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(SegmentedUnselected)
            .padding(4.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize()) {
            options.forEach { opt ->
                val isSelected = opt == selected
                Surface(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(24.dp))
                        .clickable { onSelect(opt) }
                        .padding(4.dp),
                    color = if (isSelected) SurfaceWhite else SegmentedUnselected,
                    tonalElevation = if (isSelected) 6.dp else 0.dp,
                    shadowElevation = if (isSelected) 6.dp else 0.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = opt,
                            fontSize = 14.sp,
                            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                            color = if (isSelected) MainText else MutedText
                        )
                    }
                }
            }
        }
    }
}

/**
 * ChartComposable: draws straight-segment polyline (sharp corners) — green line follows SAMPLE_VALUES.
 * Peak pill is positioned visually between 10k and 15k gridlines by mapping value->y.
 */
@Composable
fun ChartComposable(
    modifier: Modifier = Modifier,
    data: List<Float>,
    days: List<String>,
    peakLabel: String
) {
    require(data.size == days.size) { "data and days length must match" }

    Box(modifier = modifier) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            // left label reserve and paddings
            val leftLabelWidth = 56.dp.toPx()
            val innerLeftPadding = 8.dp.toPx()
            val leftPadding = leftLabelWidth + innerLeftPadding
            val rightPadding = 18.dp.toPx()
            val topPadding = 12.dp.toPx()
            val bottomPadding = 28.dp.toPx()

            val usableWidth = canvasWidth - leftPadding - rightPadding
            val usableHeight = canvasHeight - topPadding - bottomPadding

            val pointCount = data.size
            val xStep = if (pointCount > 1) usableWidth / (pointCount - 1) else usableWidth

            val minVal = data.minOrNull() ?: 0f
            val maxVal = max(1f, data.maxOrNull() ?: 1f)

            // Map points -> offsets
            val points = List(pointCount) { i ->
                val x = leftPadding + i * xStep
                val normalized = (data[i] - minVal) / (maxVal - minVal + 0.0001f)
                val y = topPadding + (1f - normalized) * usableHeight
                Offset(x, y)
            }

            // gridlines + left labels
            val gridColor = Color(0xFFF0F2F4)
            val gridCount = 6
            val axisLabels = listOf("$20k", "$15k", "$10k", "$5K", "$1K", "$500")
            for (i in 0 until gridCount) {
                val y = topPadding + i * (usableHeight / (gridCount - 1))
                drawLine(
                    color = gridColor,
                    start = Offset(leftPadding, y),
                    end = Offset(canvasWidth - rightPadding, y),
                    strokeWidth = 1f
                )
                val label = axisLabels.getOrNull(i) ?: ""
                val paint = Paint().asFrameworkPaint().apply {
                    isAntiAlias = true
                    textSize = 12.sp.toPx()
                    color = android.graphics.Color.parseColor("#9EA6AC")
                    textAlign = android.graphics.Paint.Align.LEFT
                }
                val textX = 4.dp.toPx()
                val textY = y - paint.fontMetrics.ascent / 2f - paint.fontMetrics.descent / 2f
                drawContext.canvas.nativeCanvas.drawText(label, textX, textY, paint)
            }

            // Build straight polyline path (sharp corners)
            val linePath = Path().apply {
                if (points.isNotEmpty()) {
                    moveTo(points[0].x, points[0].y)
                    for (i in 1 until points.size) {
                        val p = points[i]
                        lineTo(p.x, p.y) // straight segments -> sharp corners
                    }
                }
            }

            // Fill area under the line
            if (points.isNotEmpty()) {
                val fillPath = Path().apply {
                    addPath(linePath)
                    val last = points.last()
                    val first = points.first()
                    lineTo(last.x, topPadding + usableHeight + 2f)
                    lineTo(first.x, topPadding + usableHeight + 2f)
                    close()
                }
                drawPath(
                    path = fillPath,
                    brush = Brush.verticalGradient(
                        colors = listOf(Color(0xFFDFF5F3), Color.Transparent),
                        startY = topPadding,
                        endY = topPadding + usableHeight
                    ),
                    style = Fill
                )
            }

            // Stroke (outer bold + inner highlight + thin bright center for crispness)
            val outerStroke = 6.dp.toPx()
            drawPath(
                path = linePath,
                color = AccentTealStroke,
                style = Stroke(width = outerStroke, cap = StrokeCap.Butt, join = StrokeJoin.Miter)
            )
            drawPath(
                path = linePath,
                color = AccentTeal,
                style = Stroke(width = outerStroke * 0.6f, cap = StrokeCap.Butt, join = StrokeJoin.Miter)
            )
            drawPath(
                path = linePath,
                color = AccentTeal.copy(alpha = 0.98f),
                style = Stroke(width = outerStroke * 0.28f, cap = StrokeCap.Butt, join = StrokeJoin.Miter)
            )

            // Peak anchored to index 3 (W)
            val peakIndex = 3.coerceIn(0, points.lastIndex)
            val peakPoint = points[peakIndex]

            // Translucent rounded vertical pill under the peak
            val barWidth = xStep * 0.68f
            drawRoundRect(
                color = AccentTeal.copy(alpha = 0.08f),
                topLeft = Offset(peakPoint.x - barWidth / 2f, topPadding),
                size = Size(barWidth, usableHeight),
                cornerRadius = CornerRadius(barWidth / 2f, barWidth / 2f)
            )

            // Dot: halo + white ring + teal center
            val dotRadius = 6.dp.toPx()
            drawCircle(color = AccentTeal.copy(alpha = 0.12f), radius = dotRadius + 8.dp.toPx(), center = peakPoint)
            drawCircle(color = SurfaceWhite, radius = dotRadius + 4.dp.toPx(), center = peakPoint)
            drawCircle(color = AccentTeal, radius = dotRadius, center = peakPoint)

            // Floating pill label: position between $10k and $15k gridlines (visually)
            fun yForValue(v: Float): Float {
                val normalized = (v - minVal) / (maxVal - minVal + 0.0001f)
                return topPadding + (1f - normalized) * usableHeight
            }
            val y10k = yForValue(10000f)
            val y15k = yForValue(15000f)
            val pillPaddingH = 8.dp.toPx()
            val pillPaddingV = 6.dp.toPx()
            val paint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                textSize = 12.sp.toPx()
            }
            val labelText = peakLabel
            val textWidth = paint.measureText(labelText)
            val pillWidth = textWidth + pillPaddingH * 2f
            val pillHeight = 12.sp.toPx() + pillPaddingV * 2f
            val pillX = (peakPoint.x - pillWidth / 2f).coerceIn(leftPadding, canvasWidth - rightPadding - pillWidth)
            val pillY = ((y10k + y15k) / 2f) - (pillHeight / 2f) - 6.dp.toPx() // between 10k & 15k

            drawRoundRect(
                color = SurfaceWhite,
                topLeft = Offset(pillX, pillY),
                size = Size(pillWidth, pillHeight),
                cornerRadius = CornerRadius(16.dp.toPx(), 16.dp.toPx())
            )
            drawContext.canvas.nativeCanvas.apply {
                val textX = pillX + pillPaddingH
                val textY = pillY + pillPaddingV - paint.fontMetrics.ascent
                paint.color = android.graphics.Color.parseColor("#0E9AA7")
                drawText(labelText, textX, textY, paint)
            }

            // X-axis labels aligned to chart internals
            val xLabelPaint = Paint().asFrameworkPaint().apply {
                isAntiAlias = true
                textSize = 12.sp.toPx()
                color = android.graphics.Color.parseColor("#9EA6AC")
            }
            val xLabelY = topPadding + usableHeight + 18.dp.toPx()
            for (i in days.indices) {
                val x = leftPadding + i * xStep
                val text = days[i]
                val textWidthPx = xLabelPaint.measureText(text)
                val textX = x - textWidthPx / 2f
                drawContext.canvas.nativeCanvas.drawText(text, textX, xLabelY, xLabelPaint)
            }
        }
    }
}

// Metric card with icon at top
@Composable
fun MetricCardTopIcon(
    modifier: Modifier = Modifier,
    tint: Color,
    iconVector: ImageVector,
    label: String,
    value: String,
    caption: String?
) {
    Surface(
        modifier = modifier
            .height(110.dp)
            .clip(RoundedCornerShape(12.dp)),
        color = tint,
        tonalElevation = 4.dp,
        shadowElevation = 4.dp
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Surface(
                modifier = Modifier.size(36.dp),
                shape = RoundedCornerShape(10.dp),
                color = Color.White.copy(alpha = 0.8f)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = iconVector,
                        contentDescription = label,
                        tint = MainText,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center) {
                Text(text = label, fontSize = 13.sp, color = MutedText)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = value, fontSize = 18.sp, color = MainText, fontWeight = FontWeight.Bold)
            }

            if (!caption.isNullOrEmpty()) {
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = caption, fontSize = 12.sp, color = MutedText, modifier = Modifier.align(Alignment.End))
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F2F4)
@Composable
fun SalesStatisticScreenPreview() {
    MaterialTheme {
        SalesReportScreen()
    }
}

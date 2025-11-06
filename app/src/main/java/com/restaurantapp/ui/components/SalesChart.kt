package com.restaurantapp.ui.components

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.ViewGroup
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.restaurantapp.data.entity.SalesData
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

// Helper to choose label format based on selected range
private fun labelFormatterForRange(range: Int): SimpleDateFormat {
    return when (range) {
        0 -> SimpleDateFormat("HH:mm", Locale.getDefault())   // 1 Day
        1 -> SimpleDateFormat("EEE", Locale.getDefault())     // 1 Week
        2 -> SimpleDateFormat("dd MMM", Locale.getDefault())  // 1 Month
        3 -> SimpleDateFormat("MMM", Locale.getDefault())     // 1 Year
        else -> SimpleDateFormat("dd MMM", Locale.getDefault())
    }
}

@Composable
fun SalesLineChart(
    salesData: List<SalesData>,
    range: Int = 2,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { ctx ->
            LineChart(ctx).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                description.isEnabled = false
                legend.isEnabled = false
                setTouchEnabled(false)
                setScaleEnabled(false)
                axisRight.isEnabled = false
                setDrawGridBackground(false)
                setBackgroundColor(Color.TRANSPARENT)
                setExtraOffsets(8f, 8f, 8f, 8f)

                xAxis.apply {
                    position = XAxis.XAxisPosition.BOTTOM
                    setDrawGridLines(false)
                    textColor = Color.LTGRAY
                    textSize = 12f
                    granularity = 1f
                }

                axisLeft.apply {
                    setDrawGridLines(true)
                    gridColor = Color.parseColor("#1E2A38")
                    gridLineWidth = 1f
                    textColor = Color.LTGRAY
                    setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
                    axisMinimum = 0f
                }

                setNoDataText("No data available")
            }
        },
        update = { chart ->
            if (salesData.isEmpty()) {
                chart.clear()
                chart.invalidate()
                return@AndroidView
            }

            val dateIn = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateOut = labelFormatterForRange(range)
            val sorted = salesData.sortedBy { it.date }

            val entries = ArrayList<Entry>()
            val labels = ArrayList<String>()

            sorted.forEachIndexed { idx, sd ->
                entries.add(Entry(idx.toFloat(), sd.totalSales.toFloat()))
                val d = try { dateIn.parse(sd.date) } catch (_: Exception) { Date() }
                labels.add(dateOut.format(d ?: Date()))
            }

            val dataSet = LineDataSet(entries, "Sales").apply {
                mode = LineDataSet.Mode.CUBIC_BEZIER
                cubicIntensity = 0.25f
                color = Color.parseColor("#2EA6F0")
                lineWidth = 3f
                setDrawCircles(true)
                circleRadius = 5f
                setCircleColor(Color.WHITE)
                setCircleHoleColor(Color.parseColor("#2EA6F0"))
                circleHoleRadius = 2.5f
                setDrawValues(false)
                highLightColor = Color.parseColor("#2EA6F0")
                setDrawFilled(true)

                val gradient = GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    intArrayOf(
                        Color.argb(180, 46, 166, 240),
                        Color.argb(10, 46, 166, 240)
                    )
                )
                fillDrawable = gradient
            }

            chart.xAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    val i = value.roundToInt()
                    return if (i in labels.indices) labels[i] else ""
                }
            }

            chart.data = LineData(dataSet)
            chart.animateY(800)
            chart.invalidate()
        },
        modifier = modifier.height(220.dp)
    )
}

@Composable
fun ProfitLineChart(
    salesData: List<SalesData>,
    range: Int = 2,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { ctx ->
            LineChart(ctx).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                description.isEnabled = false
                legend.isEnabled = false
                setTouchEnabled(false)
                setScaleEnabled(false)
                axisRight.isEnabled = false
                setDrawGridBackground(false)
                setBackgroundColor(Color.TRANSPARENT)
                setExtraOffsets(8f, 8f, 8f, 8f)

                xAxis.apply {
                    position = XAxis.XAxisPosition.BOTTOM
                    setDrawGridLines(false)
                    textColor = Color.LTGRAY
                    textSize = 12f
                    granularity = 1f
                }

                axisLeft.apply {
                    setDrawGridLines(true)
                    gridColor = Color.parseColor("#1E2A38")
                    gridLineWidth = 1f
                    textColor = Color.LTGRAY
                    setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART)
                    axisMinimum = 0f
                }

                setNoDataText("No data available")
            }
        },
        update = { chart ->
            if (salesData.isEmpty()) {
                chart.clear()
                chart.invalidate()
                return@AndroidView
            }

            val dateIn = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val dateOut = labelFormatterForRange(range)
            val sorted = salesData.sortedBy { it.date }

            val entries = ArrayList<Entry>()
            val labels = ArrayList<String>()

            sorted.forEachIndexed { idx, sd ->
                entries.add(Entry(idx.toFloat(), sd.totalProfit.toFloat()))
                val d = try { dateIn.parse(sd.date) } catch (_: Exception) { Date() }
                labels.add(dateOut.format(d ?: Date()))
            }

            val dataSet = LineDataSet(entries, "Profit").apply {
                mode = LineDataSet.Mode.CUBIC_BEZIER
                cubicIntensity = 0.25f
                color = Color.parseColor("#18A558")
                lineWidth = 3f
                setDrawCircles(true)
                circleRadius = 5f
                setCircleColor(Color.WHITE)
                setCircleHoleColor(Color.parseColor("#18A558"))
                circleHoleRadius = 2.5f
                setDrawValues(false)
                highLightColor = Color.parseColor("#18A558")
                setDrawFilled(true)

                val gradient = GradientDrawable(
                    GradientDrawable.Orientation.TOP_BOTTOM,
                    intArrayOf(
                        Color.argb(180, 24, 165, 88),
                        Color.argb(10, 24, 165, 88)
                    )
                )
                fillDrawable = gradient
            }

            chart.xAxis.valueFormatter = object : ValueFormatter() {
                override fun getFormattedValue(value: Float): String {
                    val i = value.roundToInt()
                    return if (i in labels.indices) labels[i] else ""
                }
            }

            chart.data = LineData(dataSet)
            chart.animateY(800)
            chart.invalidate()
        },
        modifier = modifier.height(200.dp)
    )
}

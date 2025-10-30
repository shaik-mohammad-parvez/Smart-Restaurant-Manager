package com.restaurantapp.ui.components

import android.graphics.Color
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.restaurantapp.data.entity.SalesData
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun SalesChart(
    salesData: List<SalesData>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    AndroidView(
        factory = { LineChart(context).apply { setupChart() } },
        update = { chart ->
            chart.setupChart()
            chart.setSalesData(salesData)
        },
        modifier = modifier.height(200.dp)
    )
}

private fun LineChart.setupChart() {
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
        textColor = Color.BLACK
        textSize = 12f
    }

    axisLeft.apply {
        setDrawGridLines(true)
        gridColor = Color.LTGRAY
        textColor = Color.BLACK
        textSize = 12f
        axisMinimum = 0f
    }
    axisRight.isEnabled = false
    animateX(800)
}

private fun LineChart.setSalesData(salesData: List<SalesData>) {
    if (salesData.isEmpty()) return

    val entries = ArrayList<Entry>()
    val labels = ArrayList<String>()
    val dateInputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val dateOutputDate = SimpleDateFormat("dd MMM", Locale.getDefault())

    salesData.sortedBy { it.date }.forEachIndexed { index, data ->
        val date = dateInputFormat.parse(data.date)
        labels.add(dateOutputDate.format(date ?: Date()))
        entries.add(Entry(index.toFloat(), data.totalSales.toFloat()))
    }

    val dataSet = LineDataSet(entries, "Sales").apply {
        color = Color.parseColor("#FF5722")
        setCircleColor(Color.parseColor("#FF5722"))
        lineWidth = 2.5f
        circleRadius = 4f
        setDrawValues(false)
    }

    xAxis.valueFormatter = object : ValueFormatter() {
        override fun getFormattedValue(value: Float): String {
            val index = value.toInt()
            return if (index in labels.indices) labels[index] else ""
        }
    }

    data = LineData(dataSet)
    invalidate()
}

@Composable
fun ProfitChart(
    salesData: List<SalesData>,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    AndroidView(
        factory = { LineChart(context).apply { setupChart() } },
        update = { chart ->
            chart.setupChart()
            chart.setProfitData(salesData)
        },
        modifier = modifier.height(200.dp)
    )
}

private fun LineChart.setProfitData(salesData: List<SalesData>) {
    if (salesData.isEmpty()) return

    val entries = ArrayList<Entry>()
    val labels = ArrayList<String>()
    val dateInputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val dateOutputDate = SimpleDateFormat("dd MMM", Locale.getDefault())

    salesData.sortedBy { it.date }.forEachIndexed { index, data ->
        val date = dateInputFormat.parse(data.date)
        labels.add(dateOutputDate.format(date ?: Date()))
        entries.add(Entry(index.toFloat(), data.totalProfit.toFloat()))
    }

    val dataSet = LineDataSet(entries, "Profit").apply {
        color = Color.parseColor("#4CAF50")
        setCircleColor(Color.parseColor("#4CAF50"))
        lineWidth = 2.5f
        circleRadius = 4f
        setDrawValues(false)
    }

    xAxis.valueFormatter = object : ValueFormatter() {
        override fun getFormattedValue(value: Float): String {
            val index = value.toInt()
            return if (index in labels.indices) labels[index] else ""
        }
    }

    data = LineData(dataSet)
    invalidate()
}

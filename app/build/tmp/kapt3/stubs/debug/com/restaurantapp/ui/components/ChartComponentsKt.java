package com.restaurantapp.ui.components;

import android.graphics.Color;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Modifier;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.restaurantapp.data.entity.SalesData;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a \u0010\u0007\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\f\u0010\u000b\u001a\u00020\u0001*\u00020\tH\u0002\u00a8\u0006\f"}, d2 = {"ProfitChart", "", "salesData", "", "Lcom/restaurantapp/data/entity/SalesData;", "modifier", "Landroidx/compose/ui/Modifier;", "SalesChart", "setProfitData", "Lcom/github/mikephil/charting/charts/LineChart;", "setSalesData", "setupChart", "app_debug"})
public final class ChartComponentsKt {
    
    @androidx.compose.runtime.Composable
    public static final void SalesChart(@org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.SalesData> salesData, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    private static final void setupChart(com.github.mikephil.charting.charts.LineChart $this$setupChart) {
    }
    
    private static final void setSalesData(com.github.mikephil.charting.charts.LineChart $this$setSalesData, java.util.List<com.restaurantapp.data.entity.SalesData> salesData) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ProfitChart(@org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.SalesData> salesData, @org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier) {
    }
    
    private static final void setProfitData(com.github.mikephil.charting.charts.LineChart $this$setProfitData, java.util.List<com.restaurantapp.data.entity.SalesData> salesData) {
    }
}
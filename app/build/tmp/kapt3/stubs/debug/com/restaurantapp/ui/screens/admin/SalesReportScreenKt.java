package com.restaurantapp.ui.screens.admin;

import android.annotation.SuppressLint;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.*;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.tooling.preview.Preview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a6\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0018\u001a\u00020\rH\u0007\u001aF\u0010\u0019\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\rH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001aB\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u000e\b\u0002\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130%H\u0007\u001a\b\u0010&\u001a\u00020\u0013H\u0007\u001a.\u0010\'\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0006\u0010(\u001a\u00020\r2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00130*H\u0007\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0011\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006+"}, d2 = {"AccentTeal", "Landroidx/compose/ui/graphics/Color;", "J", "AccentTealStroke", "CardTintBlue", "CardTintPeach", "CardTintPurple", "CardTintTeal", "MainText", "MutedText", "OuterBackground", "SAMPLE_DAYS", "", "", "SAMPLE_VALUES", "", "SegmentedUnselected", "SurfaceWhite", "ChartComposable", "", "modifier", "Landroidx/compose/ui/Modifier;", "data", "days", "peakLabel", "MetricCardTopIcon", "tint", "iconVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "label", "value", "caption", "MetricCardTopIcon-3IgeMak", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "SalesReportScreen", "values", "onBack", "Lkotlin/Function0;", "SalesStatisticScreenPreview", "TimeRangeSegmentedControl", "selected", "onSelect", "Lkotlin/Function1;", "app_debug"})
public final class SalesReportScreenKt {
    private static final long OuterBackground = 0L;
    private static final long SurfaceWhite = 0L;
    private static final long MainText = 0L;
    private static final long MutedText = 0L;
    private static final long SegmentedUnselected = 0L;
    private static final long AccentTeal = 0L;
    private static final long AccentTealStroke = 0L;
    private static final long CardTintTeal = 0L;
    private static final long CardTintPurple = 0L;
    private static final long CardTintPeach = 0L;
    private static final long CardTintBlue = 0L;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> SAMPLE_DAYS = null;
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.Float> SAMPLE_VALUES = null;
    
    @android.annotation.SuppressLint(value = {"UnusedMaterial3ScaffoldPaddingParameter"})
    @androidx.compose.runtime.Composable
    public static final void SalesReportScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> days, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Float> values, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TimeRangeSegmentedControl(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.lang.String selected, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSelect) {
    }
    
    /**
     * ChartComposable: draws straight-segment polyline (sharp corners) — green line follows SAMPLE_VALUES.
     * Peak pill is positioned visually between 10k and 15k gridlines by mapping value->y.
     */
    @androidx.compose.runtime.Composable
    public static final void ChartComposable(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Float> data, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> days, @org.jetbrains.annotations.NotNull
    java.lang.String peakLabel) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, backgroundColor = 4293980916L)
    @androidx.compose.runtime.Composable
    public static final void SalesStatisticScreenPreview() {
    }
}
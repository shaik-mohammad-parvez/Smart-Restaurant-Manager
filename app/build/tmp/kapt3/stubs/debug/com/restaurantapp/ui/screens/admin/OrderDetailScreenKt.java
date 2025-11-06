package com.restaurantapp.ui.screens.admin;

import android.annotation.SuppressLint;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.*;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.Preview;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aZ\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e28\b\u0002\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\n0\u0010H\u0007\u001a:\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u000eH\u0007\u001a\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0007\u001a\b\u0010\u001e\u001a\u00020\nH\u0007\u001a$\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\n0\u001bH\u0007\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\b\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0002\u00a8\u0006#"}, d2 = {"AccentTeal", "Landroidx/compose/ui/graphics/Color;", "J", "DangerRed", "MainText", "MutedText", "OuterBackground", "SecondaryText", "SurfaceWhite", "OrderDetailScreen", "", "orderId", "", "onBack", "Lkotlin/Function0;", "onProcessPayment", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "subtotal", "tax", "OrderItemRow", "item", "Lcom/restaurantapp/ui/screens/admin/SampleOrderItem;", "index", "onQtyChange", "Lkotlin/Function1;", "onDelete", "OrderSummary", "PreviewOrderDetail", "SegmentedSwitch", "isDineIn", "", "onSelect", "app_debug"})
public final class OrderDetailScreenKt {
    private static final long OuterBackground = 0L;
    private static final long SurfaceWhite = 0L;
    private static final long MainText = 0L;
    private static final long SecondaryText = 0L;
    private static final long MutedText = 0L;
    private static final long AccentTeal = 0L;
    private static final long DangerRed = 0L;
    
    @android.annotation.SuppressLint(value = {"UnrememberedMutableState"})
    @androidx.compose.runtime.Composable
    public static final void OrderDetailScreen(int orderId, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Double, ? super java.lang.Double, kotlin.Unit> onProcessPayment) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void SegmentedSwitch(boolean isDineIn, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onSelect) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OrderItemRow(@org.jetbrains.annotations.NotNull
    com.restaurantapp.ui.screens.admin.SampleOrderItem item, int index, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onQtyChange, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OrderSummary(double subtotal, double tax) {
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable
    public static final void PreviewOrderDetail() {
    }
}
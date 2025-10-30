package com.restaurantapp.ui.screens.admin;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.material3.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.text.font.FontWeight;
import androidx.navigation.NavHostController;
import com.restaurantapp.data.entity.RestaurantTable;
import com.restaurantapp.navigation.Routes;
import com.restaurantapp.ui.viewmodel.AdminTableViewModel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u00a8\u0006\f"}, d2 = {"TableItemRow", "", "table", "Lcom/restaurantapp/data/entity/RestaurantTable;", "onEdit", "Lkotlin/Function0;", "onDelete", "TableListScreen", "navController", "Landroidx/navigation/NavHostController;", "viewModel", "Lcom/restaurantapp/ui/viewmodel/AdminTableViewModel;", "app_debug"})
public final class TableListScreenKt {
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void TableListScreen(@org.jetbrains.annotations.NotNull
    androidx.navigation.NavHostController navController, @org.jetbrains.annotations.NotNull
    com.restaurantapp.ui.viewmodel.AdminTableViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void TableItemRow(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
}
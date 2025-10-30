package com.restaurantapp.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.restaurantapp.data.entity.SalesData;
import com.restaurantapp.data.repository.RestaurantRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/restaurantapp/ui/viewmodel/SalesViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/restaurantapp/data/repository/RestaurantRepository;", "(Lcom/restaurantapp/data/repository/RestaurantRepository;)V", "_salesList", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/restaurantapp/data/entity/SalesData;", "_totalProfit", "", "_totalSales", "salesList", "Lkotlinx/coroutines/flow/StateFlow;", "getSalesList", "()Lkotlinx/coroutines/flow/StateFlow;", "totalProfit", "getTotalProfit", "totalSales", "getTotalSales", "loadAllSales", "", "loadSalesByDateRange", "startMillis", "", "endMillis", "loadTotalProfit", "loadTotalSales", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SalesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.repository.RestaurantRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.restaurantapp.data.entity.SalesData>> _salesList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.SalesData>> salesList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Double> _totalSales = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Double> totalSales = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Double> _totalProfit = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Double> totalProfit = null;
    
    @javax.inject.Inject
    public SalesViewModel(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.repository.RestaurantRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.SalesData>> getSalesList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Double> getTotalSales() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Double> getTotalProfit() {
        return null;
    }
    
    public final void loadAllSales() {
    }
    
    public final void loadSalesByDateRange(long startMillis, long endMillis) {
    }
    
    public final void loadTotalSales(long startMillis, long endMillis) {
    }
    
    public final void loadTotalProfit(long startMillis, long endMillis) {
    }
}
package com.restaurantapp.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.restaurantapp.data.entity.RestaurantTable;
import com.restaurantapp.data.repository.RestaurantRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0011\u001a\u00020\u000eH\u0002J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0013"}, d2 = {"Lcom/restaurantapp/ui/viewmodel/AdminTableViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/restaurantapp/data/repository/RestaurantRepository;", "(Lcom/restaurantapp/data/repository/RestaurantRepository;)V", "_tables", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/restaurantapp/data/entity/RestaurantTable;", "tables", "Lkotlinx/coroutines/flow/StateFlow;", "getTables", "()Lkotlinx/coroutines/flow/StateFlow;", "addTable", "", "table", "deleteTable", "loadTables", "updateTable", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class AdminTableViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.repository.RestaurantRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.restaurantapp.data.entity.RestaurantTable>> _tables = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.RestaurantTable>> tables = null;
    
    @javax.inject.Inject
    public AdminTableViewModel(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.repository.RestaurantRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.RestaurantTable>> getTables() {
        return null;
    }
    
    private final void loadTables() {
    }
    
    public final void addTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table) {
    }
    
    public final void updateTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table) {
    }
    
    public final void deleteTable(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.RestaurantTable table) {
    }
}
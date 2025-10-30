package com.restaurantapp.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.restaurantapp.data.entity.MenuItem;
import com.restaurantapp.data.repository.RestaurantRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\nJ\u001c\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0006\u0010\u001d\u001a\u00020\u0015J\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\bR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\""}, d2 = {"Lcom/restaurantapp/ui/viewmodel/MenuViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/restaurantapp/data/repository/RestaurantRepository;", "(Lcom/restaurantapp/data/repository/RestaurantRepository;)V", "_menuItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/restaurantapp/data/entity/MenuItem;", "_searchQuery", "", "_selectedCategory", "menuItems", "Lkotlinx/coroutines/flow/StateFlow;", "getMenuItems", "()Lkotlinx/coroutines/flow/StateFlow;", "searchQuery", "getSearchQuery", "selectedCategory", "getSelectedCategory", "addMenuItem", "", "item", "addToCart", "deleteMenuItem", "filterByCategory", "category", "filterMenu", "items", "loadMenuItems", "searchMenuItems", "query", "toggleAvailability", "updateMenuItem", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class MenuViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.repository.RestaurantRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.restaurantapp.data.entity.MenuItem>> _menuItems = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.MenuItem>> menuItems = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _selectedCategory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> selectedCategory = null;
    
    @javax.inject.Inject
    public MenuViewModel(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.repository.RestaurantRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.MenuItem>> getMenuItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSearchQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getSelectedCategory() {
        return null;
    }
    
    public final void loadMenuItems() {
    }
    
    public final void searchMenuItems(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void filterByCategory(@org.jetbrains.annotations.NotNull
    java.lang.String category) {
    }
    
    private final java.util.List<com.restaurantapp.data.entity.MenuItem> filterMenu(java.util.List<com.restaurantapp.data.entity.MenuItem> items) {
        return null;
    }
    
    public final void toggleAvailability(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item) {
    }
    
    public final void addMenuItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item) {
    }
    
    public final void updateMenuItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item) {
    }
    
    public final void deleteMenuItem(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item) {
    }
    
    public final void addToCart(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item) {
    }
}
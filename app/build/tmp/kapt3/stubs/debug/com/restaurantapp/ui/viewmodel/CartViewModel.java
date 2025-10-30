package com.restaurantapp.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.restaurantapp.data.entity.MenuItem;
import com.restaurantapp.data.entity.Order;
import com.restaurantapp.data.entity.OrderItem;
import com.restaurantapp.data.repository.RestaurantRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.util.*;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0017J\\\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001a28\u0010\u001d\u001a4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\"\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00120\u001eJ\u000e\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&J\u0016\u0010\'\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&2\u0006\u0010(\u001a\u00020&R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/restaurantapp/ui/viewmodel/CartViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/restaurantapp/data/repository/RestaurantRepository;", "(Lcom/restaurantapp/data/repository/RestaurantRepository;)V", "_cartItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/restaurantapp/ui/viewmodel/CartItem;", "_placingOrder", "", "cartItems", "Lkotlinx/coroutines/flow/StateFlow;", "getCartItems", "()Lkotlinx/coroutines/flow/StateFlow;", "placingOrder", "getPlacingOrder", "addToCart", "", "item", "Lcom/restaurantapp/data/entity/MenuItem;", "clearCart", "getTotal", "", "placeOrder", "customerName", "", "customerEmail", "notes", "onResult", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "success", "", "orderId", "removeFromCart", "menuItemId", "", "updateQuantity", "newQty", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class CartViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.repository.RestaurantRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.restaurantapp.ui.viewmodel.CartItem>> _cartItems = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.ui.viewmodel.CartItem>> cartItems = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _placingOrder = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> placingOrder = null;
    
    @javax.inject.Inject
    public CartViewModel(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.repository.RestaurantRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.ui.viewmodel.CartItem>> getCartItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getPlacingOrder() {
        return null;
    }
    
    public final void addToCart(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.MenuItem item) {
    }
    
    public final void removeFromCart(int menuItemId) {
    }
    
    public final void updateQuantity(int menuItemId, int newQty) {
    }
    
    public final void clearCart() {
    }
    
    public final double getTotal() {
        return 0.0;
    }
    
    /**
     * Places an order. customerName and customerEmail are provided by the UI
     * notes is optional. After success the cart is cleared.
     */
    public final void placeOrder(@org.jetbrains.annotations.NotNull
    java.lang.String customerName, @org.jetbrains.annotations.NotNull
    java.lang.String customerEmail, @org.jetbrains.annotations.Nullable
    java.lang.String notes, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.Long, kotlin.Unit> onResult) {
    }
}
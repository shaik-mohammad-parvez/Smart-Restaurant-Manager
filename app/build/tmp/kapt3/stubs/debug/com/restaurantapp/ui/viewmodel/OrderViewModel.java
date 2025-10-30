package com.restaurantapp.ui.viewmodel;

import androidx.lifecycle.ViewModel;
import com.restaurantapp.data.entity.Order;
import com.restaurantapp.data.entity.OrderItem;
import com.restaurantapp.data.repository.RestaurantRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\u0014J\u0016\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aR&\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\r\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/restaurantapp/ui/viewmodel/OrderViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/restaurantapp/data/repository/RestaurantRepository;", "(Lcom/restaurantapp/data/repository/RestaurantRepository;)V", "_orderItems", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "", "Lcom/restaurantapp/data/entity/OrderItem;", "_orders", "Lcom/restaurantapp/data/entity/Order;", "orderItems", "Lkotlinx/coroutines/flow/StateFlow;", "getOrderItems", "()Lkotlinx/coroutines/flow/StateFlow;", "orders", "getOrders", "deleteOrder", "", "order", "loadOrders", "updateOrderStatus", "orderId", "newStatus", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class OrderViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.restaurantapp.data.repository.RestaurantRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.restaurantapp.data.entity.Order>> _orders = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.Order>> orders = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.Integer, java.util.List<com.restaurantapp.data.entity.OrderItem>>> _orderItems = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.Integer, java.util.List<com.restaurantapp.data.entity.OrderItem>>> orderItems = null;
    
    @javax.inject.Inject
    public OrderViewModel(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.repository.RestaurantRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.restaurantapp.data.entity.Order>> getOrders() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.Integer, java.util.List<com.restaurantapp.data.entity.OrderItem>>> getOrderItems() {
        return null;
    }
    
    /**
     * Load all orders and their respective items
     */
    public final void loadOrders() {
    }
    
    /**
     * Update order status (e.g., Completed / Cancelled)
     */
    public final void updateOrderStatus(int orderId, @org.jetbrains.annotations.NotNull
    java.lang.String newStatus) {
    }
    
    /**
     * Delete an order completely
     */
    public final void deleteOrder(@org.jetbrains.annotations.NotNull
    com.restaurantapp.data.entity.Order order) {
    }
}
package com.restaurantapp.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/restaurantapp/utils/PermissionUtils;", "", "()V", "STORAGE_PERMISSION_CODE", "", "hasStoragePermission", "", "activity", "Landroid/app/Activity;", "requestStoragePermission", "", "app_debug"})
public final class PermissionUtils {
    private static final int STORAGE_PERMISSION_CODE = 1001;
    @org.jetbrains.annotations.NotNull
    public static final com.restaurantapp.utils.PermissionUtils INSTANCE = null;
    
    private PermissionUtils() {
        super();
    }
    
    public final boolean hasStoragePermission(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        return false;
    }
    
    public final void requestStoragePermission(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
    }
}
package com.restaurantapp.utils;

import android.content.Context;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.restaurantapp.data.entity.SalesData;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\n\u001a\u00020\u0004H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/restaurantapp/utils/PdfGenerator;", "", "()V", "generateSalesReport", "", "context", "Landroid/content/Context;", "salesData", "", "Lcom/restaurantapp/data/entity/SalesData;", "getCurrentDate", "app_debug"})
public final class PdfGenerator {
    @org.jetbrains.annotations.NotNull
    public static final com.restaurantapp.utils.PdfGenerator INSTANCE = null;
    
    private PdfGenerator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String generateSalesReport(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.List<com.restaurantapp.data.entity.SalesData> salesData) {
        return null;
    }
    
    private final java.lang.String getCurrentDate() {
        return null;
    }
}
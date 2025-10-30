package com.restaurantapp.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.restaurantapp.data.entity.SalesData;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SalesDataDao_Impl implements SalesDataDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<SalesData> __insertionAdapterOfSalesData;

  public SalesDataDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfSalesData = new EntityInsertionAdapter<SalesData>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `sales_data` (`id`,`date`,`totalSales`,`totalProfit`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final SalesData entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDate());
        }
        statement.bindDouble(3, entity.getTotalSales());
        statement.bindDouble(4, entity.getTotalProfit());
      }
    };
  }

  @Override
  public Object insertSalesData(final SalesData salesData,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfSalesData.insert(salesData);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<SalesData>> getAllSalesData() {
    final String _sql = "SELECT * FROM sales_data ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sales_data"}, new Callable<List<SalesData>>() {
      @Override
      @NonNull
      public List<SalesData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTotalSales = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSales");
          final int _cursorIndexOfTotalProfit = CursorUtil.getColumnIndexOrThrow(_cursor, "totalProfit");
          final List<SalesData> _result = new ArrayList<SalesData>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SalesData _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final double _tmpTotalSales;
            _tmpTotalSales = _cursor.getDouble(_cursorIndexOfTotalSales);
            final double _tmpTotalProfit;
            _tmpTotalProfit = _cursor.getDouble(_cursorIndexOfTotalProfit);
            _item = new SalesData(_tmpId,_tmpDate,_tmpTotalSales,_tmpTotalProfit);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<SalesData>> getSalesDataByDateRange(final String startDate,
      final String endDate) {
    final String _sql = "SELECT * FROM sales_data WHERE date BETWEEN ? AND ? ORDER BY id DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"sales_data"}, new Callable<List<SalesData>>() {
      @Override
      @NonNull
      public List<SalesData> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfTotalSales = CursorUtil.getColumnIndexOrThrow(_cursor, "totalSales");
          final int _cursorIndexOfTotalProfit = CursorUtil.getColumnIndexOrThrow(_cursor, "totalProfit");
          final List<SalesData> _result = new ArrayList<SalesData>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final SalesData _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final double _tmpTotalSales;
            _tmpTotalSales = _cursor.getDouble(_cursorIndexOfTotalSales);
            final double _tmpTotalProfit;
            _tmpTotalProfit = _cursor.getDouble(_cursorIndexOfTotalProfit);
            _item = new SalesData(_tmpId,_tmpDate,_tmpTotalSales,_tmpTotalProfit);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

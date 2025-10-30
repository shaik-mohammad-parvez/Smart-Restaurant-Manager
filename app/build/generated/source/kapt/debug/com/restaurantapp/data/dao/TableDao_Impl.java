package com.restaurantapp.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.restaurantapp.data.entity.RestaurantTable;
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
public final class TableDao_Impl implements TableDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<RestaurantTable> __insertionAdapterOfRestaurantTable;

  private final EntityDeletionOrUpdateAdapter<RestaurantTable> __deletionAdapterOfRestaurantTable;

  private final EntityDeletionOrUpdateAdapter<RestaurantTable> __updateAdapterOfRestaurantTable;

  private final SharedSQLiteStatement __preparedStmtOfUpdateTableStatus;

  public TableDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRestaurantTable = new EntityInsertionAdapter<RestaurantTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `tables` (`id`,`tableNumber`,`capacity`,`status`,`location`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final RestaurantTable entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTableNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTableNumber());
        }
        statement.bindLong(3, entity.getCapacity());
        if (entity.getStatus() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStatus());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocation());
        }
      }
    };
    this.__deletionAdapterOfRestaurantTable = new EntityDeletionOrUpdateAdapter<RestaurantTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `tables` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final RestaurantTable entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfRestaurantTable = new EntityDeletionOrUpdateAdapter<RestaurantTable>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `tables` SET `id` = ?,`tableNumber` = ?,`capacity` = ?,`status` = ?,`location` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @Nullable final RestaurantTable entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTableNumber() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTableNumber());
        }
        statement.bindLong(3, entity.getCapacity());
        if (entity.getStatus() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStatus());
        }
        if (entity.getLocation() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getLocation());
        }
        statement.bindLong(6, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateTableStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE tables SET status = ? WHERE tableNumber = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertTable(final RestaurantTable table,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRestaurantTable.insert(table);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertTables(final List<RestaurantTable> tables,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRestaurantTable.insert(tables);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteTable(final RestaurantTable table,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRestaurantTable.handle(table);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTable(final RestaurantTable table,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfRestaurantTable.handle(table);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateTableStatus(final String tableNumber, final String status,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateTableStatus.acquire();
        int _argIndex = 1;
        if (status == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, status);
        }
        _argIndex = 2;
        if (tableNumber == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, tableNumber);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateTableStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<RestaurantTable>> getAllTables() {
    final String _sql = "SELECT * FROM tables";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tables"}, new Callable<List<RestaurantTable>>() {
      @Override
      @NonNull
      public List<RestaurantTable> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTableNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "tableNumber");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final List<RestaurantTable> _result = new ArrayList<RestaurantTable>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RestaurantTable _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTableNumber;
            if (_cursor.isNull(_cursorIndexOfTableNumber)) {
              _tmpTableNumber = null;
            } else {
              _tmpTableNumber = _cursor.getString(_cursorIndexOfTableNumber);
            }
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item = new RestaurantTable(_tmpId,_tmpTableNumber,_tmpCapacity,_tmpStatus,_tmpLocation);
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
  public Object getTableById(final int tableId,
      final Continuation<? super RestaurantTable> $completion) {
    final String _sql = "SELECT * FROM tables WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, tableId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<RestaurantTable>() {
      @Override
      @Nullable
      public RestaurantTable call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTableNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "tableNumber");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final RestaurantTable _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTableNumber;
            if (_cursor.isNull(_cursorIndexOfTableNumber)) {
              _tmpTableNumber = null;
            } else {
              _tmpTableNumber = _cursor.getString(_cursorIndexOfTableNumber);
            }
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _result = new RestaurantTable(_tmpId,_tmpTableNumber,_tmpCapacity,_tmpStatus,_tmpLocation);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getTableByNumber(final String tableNumber,
      final Continuation<? super RestaurantTable> $completion) {
    final String _sql = "SELECT * FROM tables WHERE tableNumber = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (tableNumber == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tableNumber);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<RestaurantTable>() {
      @Override
      @Nullable
      public RestaurantTable call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTableNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "tableNumber");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final RestaurantTable _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTableNumber;
            if (_cursor.isNull(_cursorIndexOfTableNumber)) {
              _tmpTableNumber = null;
            } else {
              _tmpTableNumber = _cursor.getString(_cursorIndexOfTableNumber);
            }
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _result = new RestaurantTable(_tmpId,_tmpTableNumber,_tmpCapacity,_tmpStatus,_tmpLocation);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<RestaurantTable>> getTablesByStatus(final String status) {
    final String _sql = "SELECT * FROM tables WHERE status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tables"}, new Callable<List<RestaurantTable>>() {
      @Override
      @NonNull
      public List<RestaurantTable> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTableNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "tableNumber");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final List<RestaurantTable> _result = new ArrayList<RestaurantTable>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RestaurantTable _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTableNumber;
            if (_cursor.isNull(_cursorIndexOfTableNumber)) {
              _tmpTableNumber = null;
            } else {
              _tmpTableNumber = _cursor.getString(_cursorIndexOfTableNumber);
            }
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item = new RestaurantTable(_tmpId,_tmpTableNumber,_tmpCapacity,_tmpStatus,_tmpLocation);
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
  public Flow<List<RestaurantTable>> getTablesByLocation(final String location) {
    final String _sql = "SELECT * FROM tables WHERE location = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (location == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, location);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"tables"}, new Callable<List<RestaurantTable>>() {
      @Override
      @NonNull
      public List<RestaurantTable> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTableNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "tableNumber");
          final int _cursorIndexOfCapacity = CursorUtil.getColumnIndexOrThrow(_cursor, "capacity");
          final int _cursorIndexOfStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "status");
          final int _cursorIndexOfLocation = CursorUtil.getColumnIndexOrThrow(_cursor, "location");
          final List<RestaurantTable> _result = new ArrayList<RestaurantTable>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final RestaurantTable _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTableNumber;
            if (_cursor.isNull(_cursorIndexOfTableNumber)) {
              _tmpTableNumber = null;
            } else {
              _tmpTableNumber = _cursor.getString(_cursorIndexOfTableNumber);
            }
            final int _tmpCapacity;
            _tmpCapacity = _cursor.getInt(_cursorIndexOfCapacity);
            final String _tmpStatus;
            if (_cursor.isNull(_cursorIndexOfStatus)) {
              _tmpStatus = null;
            } else {
              _tmpStatus = _cursor.getString(_cursorIndexOfStatus);
            }
            final String _tmpLocation;
            if (_cursor.isNull(_cursorIndexOfLocation)) {
              _tmpLocation = null;
            } else {
              _tmpLocation = _cursor.getString(_cursorIndexOfLocation);
            }
            _item = new RestaurantTable(_tmpId,_tmpTableNumber,_tmpCapacity,_tmpStatus,_tmpLocation);
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

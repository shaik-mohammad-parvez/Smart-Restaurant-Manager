package com.restaurantapp.data.database;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.restaurantapp.data.dao.CartDao;
import com.restaurantapp.data.dao.CartDao_Impl;
import com.restaurantapp.data.dao.MenuItemDao;
import com.restaurantapp.data.dao.MenuItemDao_Impl;
import com.restaurantapp.data.dao.OrderDao;
import com.restaurantapp.data.dao.OrderDao_Impl;
import com.restaurantapp.data.dao.OrderItemDao;
import com.restaurantapp.data.dao.OrderItemDao_Impl;
import com.restaurantapp.data.dao.SalesDataDao;
import com.restaurantapp.data.dao.SalesDataDao_Impl;
import com.restaurantapp.data.dao.TableDao;
import com.restaurantapp.data.dao.TableDao_Impl;
import com.restaurantapp.data.dao.UserDao;
import com.restaurantapp.data.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UserDao _userDao;

  private volatile OrderDao _orderDao;

  private volatile OrderItemDao _orderItemDao;

  private volatile SalesDataDao _salesDataDao;

  private volatile MenuItemDao _menuItemDao;

  private volatile TableDao _tableDao;

  private volatile CartDao _cartDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `users` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fullName` TEXT NOT NULL, `email` TEXT NOT NULL, `password` TEXT NOT NULL, `phoneNumber` TEXT, `role` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `orders` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` INTEGER NOT NULL, `customerName` TEXT, `status` TEXT NOT NULL, `totalAmount` REAL NOT NULL, `tableNumber` INTEGER NOT NULL, `items` TEXT NOT NULL, `notes` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `order_items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `orderId` INTEGER NOT NULL, `name` TEXT NOT NULL, `quantity` INTEGER NOT NULL, `price` REAL NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `sales_data` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` TEXT NOT NULL, `totalSales` REAL NOT NULL, `totalProfit` REAL NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `menu_items` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `price` REAL NOT NULL, `imageUrl` TEXT NOT NULL, `category` TEXT NOT NULL, `stock` INTEGER NOT NULL, `isAvailable` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `tables` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `tableNumber` TEXT NOT NULL, `capacity` INTEGER NOT NULL, `status` TEXT NOT NULL, `location` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `cart` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `menuItemId` INTEGER NOT NULL, `name` TEXT NOT NULL, `price` REAL NOT NULL, `quantity` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '84ed479e5234dda4e6eabe2f71dc0202')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `users`");
        db.execSQL("DROP TABLE IF EXISTS `orders`");
        db.execSQL("DROP TABLE IF EXISTS `order_items`");
        db.execSQL("DROP TABLE IF EXISTS `sales_data`");
        db.execSQL("DROP TABLE IF EXISTS `menu_items`");
        db.execSQL("DROP TABLE IF EXISTS `tables`");
        db.execSQL("DROP TABLE IF EXISTS `cart`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsers = new HashMap<String, TableInfo.Column>(6);
        _columnsUsers.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("fullName", new TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("email", new TableInfo.Column("email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("password", new TableInfo.Column("password", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsers.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsers = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsers = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsers = new TableInfo("users", _columnsUsers, _foreignKeysUsers, _indicesUsers);
        final TableInfo _existingUsers = TableInfo.read(db, "users");
        if (!_infoUsers.equals(_existingUsers)) {
          return new RoomOpenHelper.ValidationResult(false, "users(com.restaurantapp.data.entity.User).\n"
                  + " Expected:\n" + _infoUsers + "\n"
                  + " Found:\n" + _existingUsers);
        }
        final HashMap<String, TableInfo.Column> _columnsOrders = new HashMap<String, TableInfo.Column>(8);
        _columnsOrders.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("customerName", new TableInfo.Column("customerName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("totalAmount", new TableInfo.Column("totalAmount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("tableNumber", new TableInfo.Column("tableNumber", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("items", new TableInfo.Column("items", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrders.put("notes", new TableInfo.Column("notes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrders = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOrders = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrders = new TableInfo("orders", _columnsOrders, _foreignKeysOrders, _indicesOrders);
        final TableInfo _existingOrders = TableInfo.read(db, "orders");
        if (!_infoOrders.equals(_existingOrders)) {
          return new RoomOpenHelper.ValidationResult(false, "orders(com.restaurantapp.data.entity.Order).\n"
                  + " Expected:\n" + _infoOrders + "\n"
                  + " Found:\n" + _existingOrders);
        }
        final HashMap<String, TableInfo.Column> _columnsOrderItems = new HashMap<String, TableInfo.Column>(5);
        _columnsOrderItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("orderId", new TableInfo.Column("orderId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsOrderItems.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOrderItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOrderItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOrderItems = new TableInfo("order_items", _columnsOrderItems, _foreignKeysOrderItems, _indicesOrderItems);
        final TableInfo _existingOrderItems = TableInfo.read(db, "order_items");
        if (!_infoOrderItems.equals(_existingOrderItems)) {
          return new RoomOpenHelper.ValidationResult(false, "order_items(com.restaurantapp.data.entity.OrderItem).\n"
                  + " Expected:\n" + _infoOrderItems + "\n"
                  + " Found:\n" + _existingOrderItems);
        }
        final HashMap<String, TableInfo.Column> _columnsSalesData = new HashMap<String, TableInfo.Column>(4);
        _columnsSalesData.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesData.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesData.put("totalSales", new TableInfo.Column("totalSales", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsSalesData.put("totalProfit", new TableInfo.Column("totalProfit", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSalesData = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSalesData = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSalesData = new TableInfo("sales_data", _columnsSalesData, _foreignKeysSalesData, _indicesSalesData);
        final TableInfo _existingSalesData = TableInfo.read(db, "sales_data");
        if (!_infoSalesData.equals(_existingSalesData)) {
          return new RoomOpenHelper.ValidationResult(false, "sales_data(com.restaurantapp.data.entity.SalesData).\n"
                  + " Expected:\n" + _infoSalesData + "\n"
                  + " Found:\n" + _existingSalesData);
        }
        final HashMap<String, TableInfo.Column> _columnsMenuItems = new HashMap<String, TableInfo.Column>(8);
        _columnsMenuItems.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenuItems.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenuItems.put("description", new TableInfo.Column("description", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenuItems.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenuItems.put("imageUrl", new TableInfo.Column("imageUrl", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenuItems.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenuItems.put("stock", new TableInfo.Column("stock", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsMenuItems.put("isAvailable", new TableInfo.Column("isAvailable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysMenuItems = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesMenuItems = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoMenuItems = new TableInfo("menu_items", _columnsMenuItems, _foreignKeysMenuItems, _indicesMenuItems);
        final TableInfo _existingMenuItems = TableInfo.read(db, "menu_items");
        if (!_infoMenuItems.equals(_existingMenuItems)) {
          return new RoomOpenHelper.ValidationResult(false, "menu_items(com.restaurantapp.data.entity.MenuItem).\n"
                  + " Expected:\n" + _infoMenuItems + "\n"
                  + " Found:\n" + _existingMenuItems);
        }
        final HashMap<String, TableInfo.Column> _columnsTables = new HashMap<String, TableInfo.Column>(5);
        _columnsTables.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTables.put("tableNumber", new TableInfo.Column("tableNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTables.put("capacity", new TableInfo.Column("capacity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTables.put("status", new TableInfo.Column("status", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTables.put("location", new TableInfo.Column("location", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTables = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTables = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTables = new TableInfo("tables", _columnsTables, _foreignKeysTables, _indicesTables);
        final TableInfo _existingTables = TableInfo.read(db, "tables");
        if (!_infoTables.equals(_existingTables)) {
          return new RoomOpenHelper.ValidationResult(false, "tables(com.restaurantapp.data.entity.RestaurantTable).\n"
                  + " Expected:\n" + _infoTables + "\n"
                  + " Found:\n" + _existingTables);
        }
        final HashMap<String, TableInfo.Column> _columnsCart = new HashMap<String, TableInfo.Column>(5);
        _columnsCart.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("menuItemId", new TableInfo.Column("menuItemId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCart.put("quantity", new TableInfo.Column("quantity", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCart = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCart = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCart = new TableInfo("cart", _columnsCart, _foreignKeysCart, _indicesCart);
        final TableInfo _existingCart = TableInfo.read(db, "cart");
        if (!_infoCart.equals(_existingCart)) {
          return new RoomOpenHelper.ValidationResult(false, "cart(com.restaurantapp.data.entity.CartItem).\n"
                  + " Expected:\n" + _infoCart + "\n"
                  + " Found:\n" + _existingCart);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "84ed479e5234dda4e6eabe2f71dc0202", "c3498388abdd08110ee11c296ef5862e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "users","orders","order_items","sales_data","menu_items","tables","cart");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `users`");
      _db.execSQL("DELETE FROM `orders`");
      _db.execSQL("DELETE FROM `order_items`");
      _db.execSQL("DELETE FROM `sales_data`");
      _db.execSQL("DELETE FROM `menu_items`");
      _db.execSQL("DELETE FROM `tables`");
      _db.execSQL("DELETE FROM `cart`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderDao.class, OrderDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(OrderItemDao.class, OrderItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SalesDataDao.class, SalesDataDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(MenuItemDao.class, MenuItemDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TableDao.class, TableDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CartDao.class, CartDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public OrderDao orderDao() {
    if (_orderDao != null) {
      return _orderDao;
    } else {
      synchronized(this) {
        if(_orderDao == null) {
          _orderDao = new OrderDao_Impl(this);
        }
        return _orderDao;
      }
    }
  }

  @Override
  public OrderItemDao orderItemDao() {
    if (_orderItemDao != null) {
      return _orderItemDao;
    } else {
      synchronized(this) {
        if(_orderItemDao == null) {
          _orderItemDao = new OrderItemDao_Impl(this);
        }
        return _orderItemDao;
      }
    }
  }

  @Override
  public SalesDataDao salesDataDao() {
    if (_salesDataDao != null) {
      return _salesDataDao;
    } else {
      synchronized(this) {
        if(_salesDataDao == null) {
          _salesDataDao = new SalesDataDao_Impl(this);
        }
        return _salesDataDao;
      }
    }
  }

  @Override
  public MenuItemDao menuItemDao() {
    if (_menuItemDao != null) {
      return _menuItemDao;
    } else {
      synchronized(this) {
        if(_menuItemDao == null) {
          _menuItemDao = new MenuItemDao_Impl(this);
        }
        return _menuItemDao;
      }
    }
  }

  @Override
  public TableDao tableDao() {
    if (_tableDao != null) {
      return _tableDao;
    } else {
      synchronized(this) {
        if(_tableDao == null) {
          _tableDao = new TableDao_Impl(this);
        }
        return _tableDao;
      }
    }
  }

  @Override
  public CartDao cartDao() {
    if (_cartDao != null) {
      return _cartDao;
    } else {
      synchronized(this) {
        if(_cartDao == null) {
          _cartDao = new CartDao_Impl(this);
        }
        return _cartDao;
      }
    }
  }
}

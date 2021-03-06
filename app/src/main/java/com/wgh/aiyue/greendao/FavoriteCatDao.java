package com.wgh.aiyue.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.wgh.aiyue.model.FavoriteCat;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.ArrayList;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FAVORITE_CAT".
*/
public class FavoriteCatDao extends AbstractDao<FavoriteCat, Long> {

    public static final String TABLENAME = "FAVORITE_CAT";

    /**
     * Properties of entity FavoriteCat.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property CategoryKey = new Property(1, String.class, "categoryKey", false, "CATEGORY_KEY");
        public final static Property FavoriteUrls = new Property(2, String.class, "favoriteUrls", false, "FAVORITE_URLS");
    }

    private final ListConverter favoriteUrlsConverter = new ListConverter();

    public FavoriteCatDao(DaoConfig config) {
        super(config);
    }
    
    public FavoriteCatDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FAVORITE_CAT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CATEGORY_KEY\" TEXT," + // 1: categoryKey
                "\"FAVORITE_URLS\" TEXT);"); // 2: favoriteUrls
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FAVORITE_CAT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, FavoriteCat entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String categoryKey = entity.getCategoryKey();
        if (categoryKey != null) {
            stmt.bindString(2, categoryKey);
        }
 
        ArrayList favoriteUrls = entity.getFavoriteUrls();
        if (favoriteUrls != null) {
            stmt.bindString(3, favoriteUrlsConverter.convertToDatabaseValue(favoriteUrls));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, FavoriteCat entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String categoryKey = entity.getCategoryKey();
        if (categoryKey != null) {
            stmt.bindString(2, categoryKey);
        }
 
        ArrayList favoriteUrls = entity.getFavoriteUrls();
        if (favoriteUrls != null) {
            stmt.bindString(3, favoriteUrlsConverter.convertToDatabaseValue(favoriteUrls));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public FavoriteCat readEntity(Cursor cursor, int offset) {
        FavoriteCat entity = new FavoriteCat( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // categoryKey
            cursor.isNull(offset + 2) ? null : favoriteUrlsConverter.convertToEntityProperty(cursor.getString(offset + 2)) // favoriteUrls
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, FavoriteCat entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCategoryKey(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFavoriteUrls(cursor.isNull(offset + 2) ? null : favoriteUrlsConverter.convertToEntityProperty(cursor.getString(offset + 2)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(FavoriteCat entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(FavoriteCat entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(FavoriteCat entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}

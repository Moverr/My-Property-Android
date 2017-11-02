package myproperty.codemovers.myproperty.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Manny on 11/3/2017.
 */

interface DatabaseHelperInt {
    void onCreate(SQLiteDatabase db);

    void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion);

}

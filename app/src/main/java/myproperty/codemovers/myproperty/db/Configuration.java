package myproperty.codemovers.myproperty.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Manny on 11/3/2017.
 */

public class Configuration extends dbHelper {
    public Configuration(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        super.onCreate(db);
    }



}

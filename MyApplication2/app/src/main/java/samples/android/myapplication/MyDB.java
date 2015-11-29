package samples.android.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by krishna on 11/18/15.
 */
public class MyDB extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    String tableName = "NOVEMBERBATCH";

    public MyDB(Context context, String name) {
        super(context, name, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String studentTable = "CREATE TABLE "+tableName+" ( id INTEGER ,  name TEXT, grade TEXT)";
        db.execSQL(studentTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}

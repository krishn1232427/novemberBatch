package samples.android.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        SQLiteOpenHelper sqLiteOpenHelper = new MyDB(MainActivity2.this, "MyDB");

        SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", 1);
        contentValues.put("name", "john");
        contentValues.put("grade", "A");
        sqLiteDatabase.insert("NOVEMBERBATCH", null, contentValues);

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put("id", 2);
        contentValues2.put("name", "mike");
        long rowNumber = sqLiteDatabase.insert("NOVEMBERBATCH", null, contentValues2);
        printDBRecords(sqLiteDatabase);
        Cursor cursor = sqLiteDatabase.query("NOVEMBERBATCH", null, "id = ?", new String[]{"2"}, null, null, null);
        printDBRecords(cursor);
        ContentValues contentValues3 = new ContentValues();
        contentValues3.put("name", "Vicky");
        printDBRecords(sqLiteDatabase);
        sqLiteDatabase.update("NOVEMBERBATCH", contentValues3, "id = ?", new String[]{"1"});
        printDBRecords(sqLiteDatabase);
        sqLiteDatabase.delete("NOVEMBERBATCH", "id = ?", new String[]{"2"});
        printDBRecords(sqLiteDatabase);
       Cursor cursor3 = getContentResolver().query(MyContentProvider.CONTENT_BASE_URI,null, null, null, null);
        Log.i("MainActivity2", "CONTENT PROVIDER OUTPUT-----------------------------------------");
        printDBRecords(cursor3);

    }

    public void printDBRecords(SQLiteDatabase sqLiteDatabase){
        Log.i("MainActivity2", "-----------------------------------------");
        Cursor cursor = sqLiteDatabase.query("NOVEMBERBATCH", null, null, null, null, null, null);
        printDBRecords(cursor);

    }
   public void printDBRecords(Cursor cursor) {
       if ( cursor != null ) {
           cursor.moveToFirst();
           do {
               int id = cursor.getInt(cursor.getColumnIndex("id"));
               String name = cursor.getString(cursor.getColumnIndex("name"));
               String grade = cursor.getString(cursor.getColumnIndex("grade"));
               Log.i("MainActivity2", "id :" + id + "name :" + name + "grade :" + grade);
           } while(cursor.moveToNext());

       }
    }
}

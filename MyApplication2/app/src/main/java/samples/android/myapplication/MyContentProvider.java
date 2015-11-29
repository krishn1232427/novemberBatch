package samples.android.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by krishna on 11/25/15.
 */
public class MyContentProvider extends ContentProvider {
    private static final String AUTHORITY = "samples.android.myapplication.MyContentPro";
    private static final Uri CONTENT_URI = Uri.parse("content://"+ AUTHORITY);
    static final Uri CONTENT_BASE_URI = Uri.parse("content://"+ AUTHORITY+"/"+"NOVEMBERBATCH");
    private static final UriMatcher myUriMatMATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final String NOVEMBERBATCH = "NOVEMBERBATCH";
    private static final String DECEMBERBATCH = "DECEMBERBATCH";
    static final int NOVEMBER_NUMBER = 10;
    static final int DECEMBER_NUMBER = 20;
    static {
        myUriMatMATCHER.addURI(AUTHORITY, NOVEMBERBATCH, NOVEMBER_NUMBER);
        myUriMatMATCHER.addURI(AUTHORITY, DECEMBERBATCH, DECEMBER_NUMBER);
    }


    MyDB myDB;
    SQLiteDatabase sqLiteDatabase;

    @Override
    public boolean onCreate() {
        //remember getContext is used to get context in content provider.
        myDB = new MyDB(getContext(), "MyDB");
        sqLiteDatabase = myDB.getWritableDatabase();
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
       Cursor cursor = null;

        switch (myUriMatMATCHER.match(uri)) {
           case NOVEMBER_NUMBER:
               cursor = sqLiteDatabase.query("NOVEMBERBATCH", projection, selection, selectionArgs,null ,null, sortOrder);
               break;
           case DECEMBER_NUMBER:
               break;
           default:
               break;
       }
           return cursor;

      // }
        //
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
       long row =  sqLiteDatabase.insert("NOVEMBERBATCH", null, values);
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
       return sqLiteDatabase.delete("NOVEMBERBATCH", selection, selectionArgs);

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
       return sqLiteDatabase.update("NOVEMBERBATCH", values, selection,selectionArgs);
    }
}

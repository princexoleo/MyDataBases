package com.practice.uiu.mydatabases.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.practice.uiu.mydatabases.model.UsersInfo;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String COL_NAME ="NAME";
    private static final String COL_ID = "ID";
    private static final String COL_CITY = "CITY" ;
    private static final String COL_COUNTRY = "COUNTRY" ;
    private static final String COL_PASSWORD = "PASSWORD";
    private String CREATE_TABLE;
   // private static String SELECT_ALL="SELECT * FROM "+TABLE_NAME;

    private static final String DATABASE_NAME="usersinfo";
    private static final String TABLE_NAME = "user_info";
    private static final int DB_VERSION=1;

    private SQLiteDatabase database;
    private Context context;

    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,DB_VERSION);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        CREATE_TABLE="CREATE TABLE "+ TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +COL_NAME+" TEXT," +COL_PASSWORD+" TEXT," + COL_CITY + " TEXT," +COL_COUNTRY+ " TEXT );" ;

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addUserInfo(UsersInfo usersInfo)
    {
         database=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_NAME,usersInfo.getName());
        values.put(COL_PASSWORD, usersInfo.getPassword());
        values.put(COL_CITY, usersInfo.getCity());
        values.put(COL_COUNTRY, usersInfo.getCountry());

        database.insert(TABLE_NAME,null,values);
        database.close();

        Toast.makeText(context, "Info insert Successfully", Toast.LENGTH_SHORT).show();

    }

    public ArrayList<UsersInfo> showDataALL() {
        ArrayList<UsersInfo>infoArrayList=new ArrayList<>();

        database=this.getReadableDatabase();
        Cursor cursor=database.query(TABLE_NAME,null,null,null,null,
                null,null);

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext())
        {
            String id=cursor.getString(cursor.getColumnIndex(COL_ID));
            String name=cursor.getString(cursor.getColumnIndex(COL_NAME));
            String password=cursor.getString(cursor.getColumnIndex(COL_PASSWORD));
            String city=cursor.getString(cursor.getColumnIndex(COL_CITY));
            String country=cursor.getString(cursor.getColumnIndex(COL_COUNTRY));

            UsersInfo usersInfo=new UsersInfo(name,password,city,country,id);

            infoArrayList.add(usersInfo);
        }
        database.close();
        return infoArrayList;
    }
}

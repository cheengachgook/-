package com.example.dnevnik;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class OpenHelper extends SQLiteOpenHelper {
    private static final String TBUsers = "Users";
    private static final String TBRoles = "Roles";
    private static final String TBUserRoles = "User_Roles";
    private static final String ColRolename = "Rolename";
    private static final String ColId = "ID";
    private static final String ColIdUser = "ID_User";
    private static final String ColIdRole = "ID_Role";
    private static final String ColLog = "Login";
    private static final String ColPass = "Password";
    private static final String ColPerm = "Permission";
    private static final String ColName = "Name";
    private static final String ColSur = "Surname";
    private static final String DBName = "database";
    private static final int DBVersion = 1;

    OpenHelper(Context context) {
        super(context, DBName, null, DBVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TBUsers + " (" +
                ColId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ColLog +  " TEXT, " +
                ColPass + " TEXT, " +
                ColName + " TEXT, " +
                ColSur +  " TEXT); ");

        db.execSQL("CREATE TABLE " + TBRoles + " (" +
                ColId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ColRolename + " TEXT); ");

        db.execSQL("CREATE TABLE " + TBUserRoles + " (" +
                ColId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ColIdUser + " INTEGER, " +
                ColIdRole + " INTEGER, " +
                "FOREIGN KEY("+ColIdUser+") REFERENCES "+TBUsers+"("+ColId+")," +
                "FOREIGN KEY("+ColIdRole+") REFERENCES "+TBRoles+"("+ColId+"));");

        ContentValues cv1 = new ContentValues();
        ContentValues cv2 = new ContentValues();
        ContentValues cv3 = new ContentValues();
        cv1.put(ColRolename, "student");
        cv2.put(ColRolename, "teacher");
        cv3.put(ColRolename, "admin");

        db.insert(TBRoles, null, cv1);
        db.insert(TBRoles, null, cv2);
        db.insert(TBRoles, null, cv3);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TBUsers);
        db.execSQL("DROP TABLE IF EXISTS " + TBRoles);
        db.execSQL("DROP TABLE IF EXISTS " + TBUserRoles);
        onCreate(db);
    }

    public String GetName(SQLiteDatabase db){
        Cursor curs = db.query(OpenHelper.TBUsers, null, null, null, null, null, null);
        curs.moveToLast();
        @SuppressLint("Range") String name = curs.getString(curs.getColumnIndex(ColName));
        return name;
    }



    @SuppressLint("Range")
    public int Search(SQLiteDatabase db, String l, String p){
            Cursor curs = db.query(OpenHelper.TBUsers, null, null, null, null, null, null);
            Cursor curs1 = db.query(TBUserRoles, null, null, null ,null ,null, null);

            curs1.moveToFirst();

            while (curs.moveToNext()) {
                @SuppressLint("Range") String lCheck = curs.getString(curs.getColumnIndex(ColLog));
                @SuppressLint("Range") String pCheck = curs.getString(curs.getColumnIndex(ColPass));
                if (lCheck.equals(l) && pCheck.equals(p)) {
                    curs.close();
                    return curs1.getInt(curs1.getColumnIndex(ColIdRole));
                }
                curs1.moveToNext();
            }
            curs.close();
            return -1;
        }



    @SuppressLint("Range")
    public int Add(SQLiteDatabase db, String l, String p, String n, String s, int per){

        Cursor curs = db.query(OpenHelper.TBUsers, null, null, null, null, null, null);

            while (curs.moveToNext()) {
                @SuppressLint("Range") String lCheck = curs.getString(curs.getColumnIndex(ColLog));
                if (lCheck.equals(l)) {
                    curs.close();
                    return -1;
                }
                MainActivity.testing = lCheck + " " + curs.getString(curs.getColumnIndex(ColPass));
            }
            curs.close();

        ContentValues cv = new ContentValues();
        cv.put(ColLog, l);
        cv.put(ColPass, p);
        cv.put(ColName, n);
        cv.put(ColSur, s);
        db.insert(TBUsers, null, cv);

        Cursor curs1 = db.query(OpenHelper.TBUsers, null, null, null, null, null, null);
        curs1.moveToLast();
        Cursor curs2 = db.query(OpenHelper.TBUsers, null, null, null, null, null, null);
        curs2.moveToLast();

        ContentValues cv1 = new ContentValues();
        cv1.put(ColIdUser, curs1.getInt(curs.getColumnIndex(ColId)));
        cv1.put(ColIdRole, per);

        db.insert(TBUserRoles, null, cv1);

        curs1.close();
        curs2.close();

        return 0;
    }
}
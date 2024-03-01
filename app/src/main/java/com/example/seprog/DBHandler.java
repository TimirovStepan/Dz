package com.example.seprog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {


    private static final String DB_NAME = "bd";


    private static final int DB_VERSION = 1;


    private static final String TABLE_NAME = "tilt";


    private static final String ID_COL = "id";


    private static final String TITLE_COL = "title";


    private static final String NUMBER_COL = "number";



    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE_COL + " TEXT,"
                + NUMBER_COL  + " TEXT)"
                ;


        db.execSQL(query);
    }


    public void addNewCourse(String courseTitle, String courseNumber) {


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();

        values.put(TITLE_COL, courseTitle);
        values.put(NUMBER_COL , courseNumber);


        db.insert(TABLE_NAME, null, values);


        db.close();
    }

    public ArrayList<CourseModal> readCourses()
    {

        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursorCourses
                = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);


        ArrayList<CourseModal> courseModalArrayList
                = new ArrayList<>();


        if (cursorCourses.moveToFirst()) {
            do {

                courseModalArrayList.add(new CourseModal(
                        cursorCourses.getString(1),

                        cursorCourses.getString(2)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return courseModalArrayList;
    }

    public void updateCourse(String originalCourseTitle, String courseTitle, String courseNumber) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(TITLE_COL, courseTitle);
        values.put(NUMBER_COL , courseNumber);



        db.update(TABLE_NAME, values, "title=?", new String[]{originalCourseTitle});
        db.close();
    }

    public void deleteCourse(String courseTitle) {


        SQLiteDatabase db = this.getWritableDatabase();


        db.delete(TABLE_NAME, "title=?", new String[]{courseTitle});
        db.close();
    }




    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

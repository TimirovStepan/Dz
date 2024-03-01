package com.example.seprog;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewCoursesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_courses);



        ArrayList<CourseModal> courseModalArrayList;
        DBHandler dbHandler = new DBHandler(ViewCoursesActivity.this);


        courseModalArrayList = dbHandler.readCourses();


        CourseRVAdapter courseRVAdapter = new CourseRVAdapter(courseModalArrayList, ViewCoursesActivity.this);
        RecyclerView coursesRV = findViewById(R.id.idRVCourses);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ViewCoursesActivity.this, RecyclerView.VERTICAL, false);
        coursesRV.setLayoutManager(linearLayoutManager);


        coursesRV.setAdapter(courseRVAdapter);
    }
}

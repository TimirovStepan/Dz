package com.example.seprog;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateCourseActivity extends AppCompatActivity {


    private EditText courseTitleEdt, courseNumberEdt;
    private DBHandler dbHandler;
    String courseTitle, courseNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_course);


        courseTitleEdt = findViewById(R.id.idtit);
        courseNumberEdt = findViewById(R.id.idnum);

        Button updateCourseBtn = findViewById(R.id.idBtnUpdateCourse);
        Button deleteCourseBtn = findViewById(R.id.idBtnDelete);


        dbHandler = new DBHandler(UpdateCourseActivity.this);


        courseTitle = getIntent().getStringExtra("Pozicia");
        courseNumber = getIntent().getStringExtra("Kolicestvo");



        courseTitleEdt.setText(courseTitle);
        courseNumberEdt.setText(courseNumber);


        // Кто прочел тот лох))))))
        updateCourseBtn.setOnClickListener(v -> {


            dbHandler.updateCourse(courseTitle, courseTitleEdt.getText().toString(), courseNumberEdt.getText().toString());


            Toast.makeText(UpdateCourseActivity.this, "Update", Toast.LENGTH_SHORT).show();


            Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
            startActivity(i);
        });

        deleteCourseBtn.setOnClickListener(v -> {

            dbHandler.deleteCourse(courseTitle);
            Toast.makeText(UpdateCourseActivity.this, "Delete", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(UpdateCourseActivity.this, MainActivity.class);
            startActivity(i);
        });

    }
}

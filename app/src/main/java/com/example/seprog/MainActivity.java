package com.example.seprog;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText courseTitleEdt,  courseNumberEdt;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseTitleEdt = findViewById(R.id.idtit);

        courseNumberEdt = findViewById(R.id.idnum);

        Button addCourseBtn = findViewById(R.id.idBtnAddCourse);
        Button readCourseBtn = findViewById(R.id.idBtnReadCourse);


        dbHandler = new DBHandler(MainActivity.this);


        addCourseBtn.setOnClickListener(v -> {


            String courseTitle = courseTitleEdt.getText().toString();

            String courseNumber = courseNumberEdt.getText().toString();



            if (courseTitle.isEmpty()  && courseNumber.isEmpty() ) {
                Toast.makeText(MainActivity.this, "Its not vse..", Toast.LENGTH_SHORT).show();
                return;
            }


            dbHandler.addNewCourse(courseTitle, courseNumber);


            Toast.makeText(MainActivity.this, "Gotovo.", Toast.LENGTH_SHORT).show();
            courseTitleEdt.setText("");
            courseNumberEdt.setText("");


        });
        readCourseBtn.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this, ViewCoursesActivity.class);
            startActivity(i);
        });

    }
}

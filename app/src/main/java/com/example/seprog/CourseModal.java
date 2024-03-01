package com.example.seprog;

public class CourseModal {


    private String courseTitle;
    private String courseNumber;

    private int id;


    public String getCourseTitle() { return courseTitle; }

    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }

    public String getCourseNumber()
    {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber)
    {
        this.courseNumber = courseNumber;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public CourseModal(String courseTitle,
                       String courseNumber)
    {
        this.courseTitle = courseTitle;
        this.courseNumber = courseNumber;

    }
}


package com.example.drawerlayout;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Student
{
    @SerializedName("name")
    private String stuName;

    @SerializedName("roll")
    private int stuRollNo;

    @SerializedName("subject")
    private String stuSubject;

    public Student(String stuName, int stuRollNo, String stuSubject) {
        this.stuName = stuName;
        this.stuRollNo = stuRollNo;
        this.stuSubject = stuSubject;
    }

    public String getStuName() {
        return stuName;
    }

    public int getStuRollNo() {
        return stuRollNo;
    }

    public String getStuSubject() {
        return stuSubject;
    }
}

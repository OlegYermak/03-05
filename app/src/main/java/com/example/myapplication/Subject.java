package com.example.myapplication;

import java.io.Serializable;

public class Subject implements Serializable {
    private String subjectName; // Назва предмета
    private int subjectCode;     // Код предмета
    private float credits;       // Кількість кредитів

    public Subject(String subjectName, int subjectCode, float credits) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.credits = credits;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectCode() {
        return subjectCode;
    }

    public float getCredits() {
        return credits;
    }
}

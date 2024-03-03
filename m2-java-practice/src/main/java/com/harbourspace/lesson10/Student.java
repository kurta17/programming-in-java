package com.harbourspace.lesson10;

import java.time.LocalDate;


public class Student {
    Long id;
    String fullName;
    Integer course;
    Boolean isEnrolled;
    LocalDate admissionDate;
    LocalDate graduationDate;
    Double grade;

    public Student(Long id, String fullName, Integer course, Boolean isEnrolled, LocalDate admissionDate, LocalDate graduationDate, Double grade) {
        this.id = id;
        this.fullName = fullName;
        this.course = course;
        this.isEnrolled = isEnrolled;
        this.admissionDate = admissionDate;
        this.graduationDate = graduationDate;
        this.grade = grade;
    }



}



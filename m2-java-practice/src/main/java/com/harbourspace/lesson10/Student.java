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

    // Getters for private fields to be used in tests
    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public Integer getCourse() {
        return course;
    }

    public Boolean getIsEnrolled() {
        return isEnrolled;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public Double getGrade() {
        return grade;
    }
}


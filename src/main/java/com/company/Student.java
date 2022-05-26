package com.company;

import java.util.Objects;

/**
 * 2. Напишите производный класс com.company.Student с добавленными полями университет, факультет,
 * специальность.
 */
public class Student extends Human {
    private String university, faculty, major;


    public Student() {
        super();
        this.university = "university";
        this.faculty = "faculty";
        this.major = "major";
    }

    public Student(String name, String surname, String patronymic, int age, Gender gender, String university, String faculty, String major) {
        super(name, surname, patronymic, age, gender);
        setUniversity(university);
        setFaculty(faculty);
        setMajor(major);
    }

    public Student(String university, String faculty, String major) {
        super();
        setUniversity(university);
        setFaculty(faculty);
        setMajor(major);
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        if (university == null) throw new IllegalArgumentException("university is null");
        if (university.isEmpty()) throw new IllegalArgumentException("university is empty");
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        if (faculty == null) throw new IllegalArgumentException("faculty is null");
        if (faculty.isEmpty()) throw new IllegalArgumentException("faculty is empty");
        this.faculty = faculty;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (major == null) throw new IllegalArgumentException("major is null");
        if (major.isEmpty()) throw new IllegalArgumentException("major is empty");
        this.major = major;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(university, student.university) && Objects.equals(faculty, student.faculty) && Objects.equals(major, student.major);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), university, faculty, major);
    }

    @Override
    public String toString() {
        return "com.company.Student{" +
                "university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}

package org.leoho;

public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId;

    public enum Gender {
        MALE, FEMALE
    }
}

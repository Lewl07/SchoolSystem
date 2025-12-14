package org.leoho;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId;

    /**
     * Registers a course, adds the course to the student's registeredCourses list
     * appends a null for the scores of each assignment of the course.
     * If the course is already registered (exists in the student's registeredCourses list)
     * directly returns false without adding anything
     * @param course
     * @return
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (int i = 0; i < course.getAssignments().size(); i++) {
            scores.add(null);
        }

        return true;
    }

    public enum Gender {
        MALE, FEMALE
    }
}

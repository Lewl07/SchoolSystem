package org.leoho;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

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
    private static int nextId = 1;

    /**
     * Registers a course, adds the course to the student's registeredCourses list
     * appends a null for the scores of each assignment of the course.
     * If the course is already registered (exists in the student's registeredCourses list)
     * directly returns false without adding anything
     * @param course
     * @return whether the course has been registered or not.
     */
    public boolean registerCourse(Course course) {
        if (this.registeredCourses.contains(course)) {
            return false;
        }

        this.registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (int i = 0; i < course.getAssignments().size(); i++) {
            course.getAssignments().get(i).getScores().add(null);
        }

        return true;
    }

    /**
     *  Drops a course, remove the course from the student's registeredCourses list,
     *  and remove the student from the course's registeredStudents list.
     *  If the course is not registered yet (not in the student's registeredCourses list),
     *  directly returns false without removing anything.
     * @param course the course
     * @return whether the course has been dropped or not.
     */
    public boolean dropCourse(Course course) {
        if (!this.registeredCourses.contains(course)) {
            return false;
        }

        this.registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        return true;
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Converts a student to a simple string with only the studentId,
     * the studentName, and departmentName.
     * This method is called in Course toString().
     * @return The simplified string.
     */
    public String toSimplifiedString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
//                ", registeredCourses=" + registeredCourses +      only courseId, courseName, departmentName
                '}';
    }

    public enum Gender {
        MALE, FEMALE
    }
}

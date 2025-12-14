package org.leoho;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;        // 2 digits C-dptID-courseId
    private String courseName;
    private double credits;         // 1.5, 2.0, 2.5, 3.0
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;


    /**
     * Checks if the sum of weights of all assignments of that course equals to 100%.
     * @return whether it is valid or not.
     */
    public boolean isAssignmentWeightValid() {

        return true;
    }

    /**
     * Adds a student to the student list of the course,
     * also add a new null element to each assignment of this course,
     * and add a new null element for the finalScores.
     * @param student the student profile
     * @return whether the student has successfully registered for the course.
     */
    public boolean registerStudent(Student student) {
        this.registeredStudents.add(student);


        return true;
    }

    /**
     * Calculates the weighted average score of a student.
     * @return the weighted average score of the student.
     */
    public int[] calcStudentsAverage() {


        return null;
    }

    /**
     * Adds a new assignment to a course.
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     * @param maxScore the max score of the assignment
     * @return whether a new assignment has been successfully added to the course.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {


        return true;
    }

    /**
     * Generates random scores for each assignment and student
     * and calculates the final score for each student.
     */
    public void generateScores() {

    }



    public Course(String courseName, double credits, Department department, ArrayList<Assignment> assignments, ArrayList<Student> registeredStudents) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = assignments;
        this.registeredStudents = registeredStudents;
    }
}

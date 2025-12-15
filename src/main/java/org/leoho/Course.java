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
        if (assignments.isEmpty()) {
            return false;
        }

        double sum = 0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return sum == 100;
    }

    /**
     * Adds a student to the student list of the course,
     * also add a new null element to each assignment of this course,
     * and add a new null element for the finalScores.
     * @param student the student profile
     * @return whether the student has successfully registered for the course.
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        this.registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * Calculates the weighted average score of a student.
     * @return the weighted average score of the student.
     */
    public int[] calcStudentsAverage() {
        int[] groupAvg = new int[getRegisteredStudents().size()];
        // [i, j]       i: #assignment j: the student
        // [0, 0]       [1st A, Leo]
        // [1, 0]       [2nd A, Leo]
        // [2, 0]       [Exam1, Leo]

        // [0, 1]
        // [1, 1]
        // [2, 1]

        for (int i = 0; i < getRegisteredStudents().size(); i++) {
            int sum = 0;
            for (int j = 0; j < assignments.size(); i++) {
                sum += (assignments.get(j).getScores().get(i)) * (assignments.get(j).getWeight() / 100);
            }

            groupAvg[i] = sum / assignments.size();
        }

        return groupAvg;
    }

    /**
     * Adds a new assignment to a course.
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     * @param maxScore the max score of the assignment
     * @return whether a new assignment has been successfully added to the course.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        assignments.add(new Assignment(assignmentName, weight));

        return true;
    }

    /**
     * Generates random scores for each assignment and student
     * and calculates the final score for each student.
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
    }

    /**
     * Displays the scores of a course in a table, with the assignment averages and
     * student weighted averages.
     */
    public void displayScores() {
        System.out.println(String.format("Course: %s (%s)", courseName, courseId));


    }


    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }
}

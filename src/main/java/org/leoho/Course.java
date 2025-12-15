package org.leoho;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import util.Util;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;

    /**
     * Checks if the sum of weights of all assignments of that course equals to 100%.
     * @return whether it is valid or not.
     */
    public boolean isAssignmentWeightValid() {
        if (assignments == null || assignments.isEmpty()) {
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
        if (student == null || registeredStudents.contains(student)) {
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
        if (assignments == null || assignments.isEmpty()) {
            return null;
        }

        int[] studentsAvg = new int[getRegisteredStudents().size()];
        for (int i = 0; i < getRegisteredStudents().size(); i++) {
            int sum = 0;
            for (int j = 0; j < assignments.size(); j++) {
                sum += (assignments.get(j).getScores().get(i)) * (assignments.get(j).getWeight() / 100);
            }

            studentsAvg[i] = sum / assignments.size();
        }

        return studentsAvg;
    }

    /**
     * Adds a new assignment to a course.
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     * @param maxScore the max score of the assignment
     * @return whether a new assignment has been successfully added to the course.
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }

        assignments.add(assignment);

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
        System.out.printf("Course: %s (%s)%n", courseName, courseId);

        System.out.printf("%-25s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%-15s", assignment.getAssignmentName());
        }
        System.out.printf("%-15s%n", "Final Score");

        generateScores();
        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            System.out.printf("%-25s", registeredStudents.get(i).getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.printf("%-15s", score);
            }

            System.out.printf("%-15d%n", finalScores[i]);
        }
    }

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     * String containing only the courseId, courseName, credits and departmentName.
     * @return the simplified string.
     */
    public String toSimplifiedString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", departmentName=" + department.getDepartmentName() +
                '}';
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", departmentName=" + department.getDepartmentName() +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                ", isAssignmentWeightValid" + isAssignmentWeightValid() +
                '}';
    }
}

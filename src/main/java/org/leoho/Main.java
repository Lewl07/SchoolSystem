package org.leoho;

public class Main {
    public static void main(String[] args) {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Introduction to Programming", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);
        Student s2 = new Student("Mike", Student.Gender.MALE,
                null, department);
        Student s3 = new Student("Bob", Student.Gender.MALE,
                null, department);

        introToProg.addAssignment("Assignment01", 20, 100);
        introToProg.addAssignment("Exam01", 80, 100);

        s1.getRegisteredCourses().add(introToProg);
        s2.getRegisteredCourses().add(introToProg);
        s3.getRegisteredCourses().add(introToProg);

        introToProg.registerStudent(s1);
        introToProg.registerStudent(s2);
        introToProg.registerStudent(s3);

        introToProg.displayScores();
    }
}

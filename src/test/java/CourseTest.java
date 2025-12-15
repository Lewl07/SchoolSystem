import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.leoho.Course;
import org.leoho.Department;
import org.leoho.Student;

import java.util.Arrays;

public class CourseTest {

    // 1. isAssignmentWeightValid()

    @Test
    @DisplayName("Assignment weights add up to 100 -> true")
    void isAssignmentWeightValidTest1() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);
        Student s2 = new Student("Mike", Student.Gender.MALE,
                null, department);
        Student s3 = new Student("Bob", Student.Gender.MALE,
                null, department);

        introToProg.addAssignment("Test01", 20, 100);
        introToProg.addAssignment("Test02", 20, 100);
        introToProg.addAssignment("Final", 60, 100);

        boolean expected = true;
        boolean actual = introToProg.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Assignment weights add up to 90 -> false")
    void isAssignmentWeightValidTest2() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);
        Student s2 = new Student("Mike", Student.Gender.MALE,
                null, department);
        Student s3 = new Student("Bob", Student.Gender.MALE,
                null, department);

        introToProg.addAssignment("Test01", 20, 100);
        introToProg.addAssignment("Test02", 20, 100);
        introToProg.addAssignment("Final", 50, 100);
        // weight = 90

        boolean expected = false;
        boolean actual = introToProg.isAssignmentWeightValid();

        Assertions.assertEquals(expected, actual);
    }


    // 2. registerStudent()


    @Test
    @DisplayName("Student that isn't in the list of the course -> true")
    void registerStudentTest1() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);

        boolean expected = true;
        boolean actual = introToProg.registerStudent(s1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student that IS ALREADY in the list of the course -> false")
    void registerStudentTest2() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);

        introToProg.registerStudent(s1);        // student already registered in the course list

        boolean expected = false;
        boolean actual = introToProg.registerStudent(s1);

        Assertions.assertEquals(expected, actual);
    }
}

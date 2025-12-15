import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.leoho.Course;
import org.leoho.Department;
import org.leoho.Student;

public class StudentTest {
    // 1. registerCourse()

    @Test
    @DisplayName("Student that DOESN'T have the course registered -> true")
    void registerCourseTest1() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);

        boolean expected = true;
        boolean actual = s1.registerCourse(introToProg);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student registering for a course he ALREADY registered -> false")
    void registerCourseTest2() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);

        s1.registerCourse(introToProg);     // s1 has already registered for the course

        boolean expected = false;
        boolean actual = s1.registerCourse(introToProg);

        Assertions.assertEquals(expected, actual);
    }

    //2. dropCourse()

    @Test
    @DisplayName("Student drops a course that he is currently registered for -> true")
    void dropCourseTest1() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);

        s1.registerCourse(introToProg);     // s1 is currently registered in a course that he wants to drop

        boolean expected = true;
        boolean actual = s1.dropCourse(introToProg);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Student drops a course that he has YET to register for -> true")
    void dropCourseTest2() {
        Department department = new Department("CompSci");

        Course introToProg = new Course("Prog", 3.0, department);

        Student s1 = new Student("Leo", Student.Gender.MALE,
                null, department);

//      s1.registerCourse(introToProg);     // s1 wasn't in the course in the first place

        boolean expected = false;
        boolean actual = s1.dropCourse(introToProg);

        Assertions.assertEquals(expected, actual);
    }
}

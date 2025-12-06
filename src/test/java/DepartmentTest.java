import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.leoho.Department;

public class DepartmentTest {
    // isDepartmentNameValid

    @Test
    @DisplayName("Department of Computer Science and Math -> true")
    void isDepartmentNameValid() {
        String departmentName = "Department of Computer Science and Math";

        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("VSCA -> true")
    void isDepartmentNameValid2() {
        String departmentName = "VSCA";

        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("# DEPARTMENT OF NOTHING -> false")
    void isDepartmentNameValid3() {
        String departmentName = "# DEPARTMENT OF NOTHING";

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("# DEPARTMENT OF NOTHING 4 -> false")
    void isDepartmentNameValid4() {
        String departmentName = "DEPARTMENT OF NOTHING 4";

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName(" sdkjh28ysqjh1jiqk129hsjqk#QWHQJsa -> false")
    void isDepartmentNameValid5() {
        String departmentName = "sdkjh28ysqjh1jiqk129hsjqk#QWHQJsa";

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> false")
    void isDepartmentNameValid6() {
        String departmentName = null;

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("  -> false")
    void isDepartmentNameValid7() {
        String departmentName = "";

        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(departmentName);

        Assertions.assertEquals(expected, actual);
    }
}

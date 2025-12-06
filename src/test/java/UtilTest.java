import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

public class UtilTest {
    // toTitlecase()

    @Test
    @DisplayName("lEo hO -> Leo Ho")
    void toTitleCaseTest1() {
        String str = "lEo hO";

        String expected = "Leo Ho";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("computer science and math -> Computer Science And Math")
    void toTitleCaseTest2() {
        String str = "computer science and math";

        String expected = "Computer Science And Math";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("null -> ")
    void toTitleCaseTest3() {
        String str = null;

        String expected = "";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("  ->  ")
    void toTitleCaseTest4() {
        String str = "";

        String expected = "";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }
}

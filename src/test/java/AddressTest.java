import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.leoho.Address;

public class AddressTest {
    @Test
    @DisplayName("A1B2C3 -> true")
    void isPostalCodeValidTest1() {
        String postalCode = "A1B2C3";

        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("1A2B3C -> false")
    void isPostalCodeValidTest2() {
        String postalCode = "1A2B3C";

        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("A1B2C3D -> false")
    void isPostalCodeValidTest3() {
        String postalCode = "A1B2C3D";

        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("a1b2c3 -> true")
    void isPostalCodeValidTest4() {
        String postalCode = "a1b2c3";

        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }
}

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Address class
public class ClassTests {
    @Test
    @DisplayName("isPostalCodeValid: A1B2C3 -> true")
    void isPostalCodeValidTest1() {
        String postalCode = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: A1B2C -> false")
    void isPostalCodeValidTest2() {
        String postalCode = "A1B2C";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid: 123ABC -> false")
    void isPostalCodeValidTest3() {
        String postalCode = "123ABC";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);
        Assertions.assertEquals(expected, actual);
    }




}

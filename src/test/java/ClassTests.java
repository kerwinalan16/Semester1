import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

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
//Department class
        @Test
        @DisplayName("isDepartmentNameValid: Computer Science -> true")
        void isDepartmentNameValidTest1() {
            String departmentName = "Computer Science";
            boolean expected = true;
            boolean actual = Department.isDepartmentNameValid(departmentName);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("isDepartmentNameValid: Math123 -> false")
        void isDepartmentNameValidTest2() {
            String departmentName = "Math123";
            boolean expected = false;
            boolean actual = Department.isDepartmentNameValid(departmentName);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        @DisplayName("isDepartmentNameValid: Physics! -> false")
        void isDepartmentNameValidTest3() {
            String departmentName = "Physics!";
            boolean expected = false;
            boolean actual = Department.isDepartmentNameValid(departmentName);
            Assertions.assertEquals(expected, actual);
        }

//util totTitleCase
@Test
@DisplayName("toTitleCase: yi wang -> Yi Wang")
void toTitleCaseTest1() {
    String input = "yi wang";
    String expected = "Yi Wang";
    String actual = Util.toTitleCase(input);
    Assertions.assertEquals(expected, actual);
}

    @Test
    @DisplayName("toTitleCase: computer science and math -> Computer Science And Math")
    void toTitleCaseTest2() {
        String input = "computer science and math";
        String expected = "Computer Science And Math";
        String actual = Util.toTitleCase(input);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("toTitleCase: JOHN DOE -> John Doe")
    void toTitleCaseTest3() {
        String input = "JOHN DOE";
        String expected = "John Doe";
        String actual = Util.toTitleCase(input);
        Assertions.assertEquals(expected, actual);
    }




    }






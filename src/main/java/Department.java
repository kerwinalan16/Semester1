import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private final String departmentId;
    @Setter private String departmentName;
    private static int nextId = 1;

    /**
     * Checks whether a given department name is valid.
     * A valid department name must contain only letters (uppercase or lowercase)
     * and spaces. No digits, symbols, or other characters are allowed.
     * @param departmentName the name of the department to validate
     * @return true if the department name contains only letters and spaces, false otherwise
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }
        for (char character : departmentName.toCharArray()) {
            if (!Character.isLetter(character) && character != ' ') {
                return false;
            }
        }

        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentId = String.format("%02d", nextId++);
            this.departmentName = departmentName;
        } else {

            this.departmentId = null;
            this.departmentName = null;
        }
    }
}

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Department {
    private final String departmentId;
    @Setter
    private String departmentName;
    private static int nextId = 1;

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
            this.departmentId = String.format("D%02d", nextId++);
            this.departmentName = departmentName;
        } else {

            this.departmentId = null;
            this.departmentName = null;
        }
    }
}

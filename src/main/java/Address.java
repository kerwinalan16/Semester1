import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Address {

    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        AB, BC, MB, NB, NL, NS, NT, NU, ON, PE, QC, SK, YT
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < 6; i++) {
            char character = postalCode.charAt(i);
            if (i % 2 == 0) {
                if (!Character.isLetter(character))
                    return false;

            } else {
                if (!Character.isDigit(character))
                    return false;
            }
        }

        return false;
    }
}

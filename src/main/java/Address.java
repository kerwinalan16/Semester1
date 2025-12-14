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

    /**
     * Checks whether a given postal code is valid.
     * A valid postal code must satisfy the following conditions:
     * The length must be exactly 6 characters.
     * The format must alternate between a letter and a digit: C D C D C D,
     * This method is static and should be called with a postal code parameter
     * before assigning it to the field. Only valid postal codes should be assigned.
     * @param postalCode the postal code to validate
     * @return true if the postal code is valid according to the above rules, false otherwise
     */
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

        return true;
    }
    public Address(int streetNo, String street, String city,
                   Province province, String postalCode) {

        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {

            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }
}


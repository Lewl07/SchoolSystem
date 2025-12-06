package org.leoho;

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

    /**
     * Checks if a postcode is valid or not.
     * @param postalCode the postal code
     * @return whether the postal code is valid or not.
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode.length() != 6) {
            return false;
        }

        for (int i = 0; i < postalCode.length() - 1; i++) {
            char c = postalCode.charAt(i);

            if (i % 2 == 0 && !Character.isLetter(c)) {
                return false;
            }

            if (i % 2 == 1 && !Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    // If the postal code is invalid, the entire address is reverted to null.
    public Address(int streetNo, String street, String city, Province province, String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
        } else {
            this.postalCode = null;
            this.streetNo = -1;
            this.street = null;
            this.city = null;
            this.province = null;
        }
    }

    public enum Province {
        ON, QC, AB, BC, MB, SK, NB, NL, NS, PE
    }
}

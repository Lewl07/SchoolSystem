package org.leoho;

public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province Province;
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


    public enum Province {
        ON, QC, AB, BC, MB, SK, NB, NL, NS, PE
    }
}

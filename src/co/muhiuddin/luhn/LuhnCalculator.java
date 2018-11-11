package co.muhiuddin.luhn;

import java.util.Arrays;

public class LuhnCalculator {

    /**
     * Returns a boolean to indicate whether the passed-in value
     * passes the Luhn verification
     <p>
     * @param   ccNum  {@Link String} the credit card number
     * @return  result {@link boolean} true of false
     */
    public static boolean calculate(String ccNum) {
        if (ccNum == null)
            return false;
        else {
            // Create an integer array to hold the credit card number
            int[] digits = new int[ccNum.length()];
            for (int i = 0; i < ccNum.length(); i++) {
                digits[i] = Character.getNumericValue(ccNum.charAt(i));
            }

            // Double every second digit, starting from the check digit (rightmost)
            for (int pos = digits.length - 2; pos >= 0; pos = pos-2) {
                digits[pos] = digits[pos]*2;
            }

            // Sum the total
            int total = 0;
            for (int j = 0; j < digits.length; j++) {
                // If product is greater > 10, then minus 9
                if (digits[j] > 10)
                    total = total + digits[j] - 9;
                else
                    total = total + digits[j];
            }

            // Return true if total mod 10 == 0
            return (total % 10 == 0);
        }
    }
}

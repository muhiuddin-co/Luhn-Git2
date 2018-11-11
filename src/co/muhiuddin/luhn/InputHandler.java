package co.muhiuddin.luhn;

public class InputHandler {

    // Maximum number of digits for a credit card
    private static int MAX_LENGTH = 19;

    // Minimum number of digits for a credit card
    private static int MIN_LENGTH = 6;


    /**
     * Returns a String with all white space (spaces and tabs) removed
     <p>
     * @param   ccNum  {@Link String} the credit card number
     * @return  ccNum {@link String} all white space removed
     */
    public static String removeWhiteSpace(String ccNum) {
            return ccNum.replaceAll("\\s+","");
    }

    /**
     * Returns a boolean to indicate whether the passed-in value
     * has a valid length for a Credit Card
     <p>
     * @param   ccNum  {@Link String} the credit card number
     * @return  result {@link boolean} true of false
     */
    public static boolean checkLength(String ccNum) {

        // Check if the passed-in value has a valid length
        if (ccNum == null)
            return false;
        else if ((ccNum.length() < MIN_LENGTH) || (ccNum.length() > MAX_LENGTH)) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Returns a boolean to indicate whether the passed-in value
     * has valid numeric characters which are 0 to 9 only.
     * No negative indicator, decimals or float characters allowed.
     <p>
     * @param   ccNum  {@Link String} the credit card number
     * @return  result {@link boolean} true of false
     */
    public static boolean checkChars(String ccNum) {
        // RegEx of valid characters
        String validChars = "[0-9]+";

        // Check if the passed-in value contains valid characters
        if (ccNum == null)
            return false;
        else if (ccNum.matches(validChars)) {
            return true;
        }
        else {
            return false;
        }
    }
}

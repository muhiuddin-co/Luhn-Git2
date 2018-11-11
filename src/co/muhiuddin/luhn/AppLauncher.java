package co.muhiuddin.luhn;

public class AppLauncher {

    public static void main (String[] args) {

        String cc = "423773721";

        if (cc != null) {
            cc = InputHandler.removeWhiteSpace(cc);

            if (InputHandler.checkLength(cc) && InputHandler.checkChars(cc)) {
                System.out.println("Validity of " + cc + " is " + LuhnCalculator.calculate(cc));
            }
            else
                System.out.println("Validity of " + cc + " is false");
        }

    }

}

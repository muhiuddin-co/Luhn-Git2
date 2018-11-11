import static org.junit.jupiter.api.Assertions.assertEquals;

import co.muhiuddin.luhn.InputHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;

class InputHandlerTests {

    @Test
    @CsvSource({
            "4276806169774071 ",
            "  374724885926561",
            "5221466114156248",
            "6011 4172 0869 3135"
    })
    void succeedingTest(String validCCNum) {
        assertEquals(true,
                InputHandler.checkLength(InputHandler.removeWhiteSpace(validCCNum)),
                validCCNum + "length should be valid");

        assertEquals(true,
                InputHandler.checkChars(InputHandler.removeWhiteSpace(validCCNum)),
                validCCNum + "chars should be valid");
    }

    @Test
    @CsvSource({
            "00125221468114156248966",
            "6011"
    })
    void failingLengthTest(String invalidCCNum) {
        assertEquals(false,
                InputHandler.checkLength(InputHandler.removeWhiteSpace(invalidCCNum)),
                invalidCCNum + "length is invalid");
    }

    @Test
    @CsvSource({
            "SELECT * FROM system.properties;",
            "  \n\n374724885926561",
            "522146ß114156248",
            "6Ö11 4172 Ö869 3135"
    })
    void failingCharacterTest(String invalidCCNum) {
        assertEquals(false,
                InputHandler.checkChars(InputHandler.removeWhiteSpace(invalidCCNum)),
                invalidCCNum + "chars are invalid");
    }
}

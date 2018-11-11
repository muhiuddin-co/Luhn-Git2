
import co.muhiuddin.luhn.LuhnCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuhnCalculatorTests {

    @Test
    @CsvSource({
            "4276806169774071 ",
            "  374724885926561",
            "5221466114156248",
            "6011 4172 0869 3135"
    })
    void succeedingTest(String validCCNum) {
        assertEquals(true,
                LuhnCalculator.calculate(validCCNum),
                validCCNum + " is valid");
    }

    @Test
    @CsvSource({
            "00125221468114156248966",
            "6011"
    })
    void failingTest(String invalidCCNum) {
        assertEquals(false,
                LuhnCalculator.calculate(invalidCCNum),
                invalidCCNum + " is invalid");
    }
}

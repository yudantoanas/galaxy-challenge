package io.prospace;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumberTest {

    // check for wrong number format
    @Test
    void wrongRomanNumberTest() {
        String roman = "MXXLVID";

        RomanNumber romanNumber = new RomanNumber();

        assertFalse(romanNumber.checkNumberFormat(roman));
    }

    // check for correct number format
    @Test
    void correctRomanNumberTest() {
        String roman = "MCMXLIV";

        RomanNumber romanNumber = new RomanNumber();

        assertTrue(romanNumber.checkNumberFormat(roman));
    }
}
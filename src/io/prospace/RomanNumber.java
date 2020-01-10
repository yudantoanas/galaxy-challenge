package io.prospace;

import java.util.HashMap;
import java.util.List;

import static io.prospace.GalaxyNumber.getRomanSymbol;

public class RomanNumber {
    // store each roman number symbol and its values
    public static HashMap<String, Integer> romanNumerals = new HashMap<>();

    public RomanNumber() {
        // define default roman numerals and save it to hash map
        romanNumerals.put("I", 1);
        romanNumerals.put("V", 5);
        romanNumerals.put("X", 10);
        romanNumerals.put("L", 50);
        romanNumerals.put("C", 100);
        romanNumerals.put("D", 500);
        romanNumerals.put("M", 1000);
    }

    public static boolean checkNumberFormat(String roman) {
        // check roman string to match pattern
        // returns true if match, otherwise false
        String numberPattern = "M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
        return roman.matches(numberPattern);
    }

    public static int getNumberValue(String key) {
        // get roman number value by passing its key
        return romanNumerals.get(key);
    }

    public static String convertInputToRomanNumeral(List<String> metalQuantities) {
        StringBuilder result = new StringBuilder();

        for (String metalQuantity : metalQuantities) {
            // get roman number symbol and append it to result string
            result.append(getRomanSymbol(metalQuantity));
        }

        return String.valueOf(result);
    }
}

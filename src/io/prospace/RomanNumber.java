package io.prospace;

import java.util.HashMap;
import java.util.List;

import static io.prospace.GalaxyNumber.getRomanSymbol;

public class RomanNumber {
    public static HashMap<String, Integer> romanNumerals = new HashMap<>();

    public RomanNumber() {
        romanNumerals.put("I", 1);
        romanNumerals.put("V", 5);
        romanNumerals.put("X", 10);
        romanNumerals.put("L", 50);
        romanNumerals.put("C", 100);
        romanNumerals.put("D", 500);
        romanNumerals.put("M", 1000);
    }

    public static boolean checkNumberFormat(String roman) {
        String numberPattern = "M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";
        return roman.matches(numberPattern);
    }

    public static int getNumberValue(String key) {
        return romanNumerals.get(key);
    }

    public static String convertInputToRomanNumeral(List<String> metalQuantities) {
        StringBuilder result = new StringBuilder();
        for (String metalQuantity : metalQuantities) {
            result.append(getRomanSymbol(metalQuantity));
        }

        return String.valueOf(result);
    }
}

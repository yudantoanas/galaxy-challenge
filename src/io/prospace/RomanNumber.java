package io.prospace;

import java.util.HashMap;

public class RomanNumber {
    public static HashMap<Character, Integer> romanNumerals = new HashMap<>();

    public RomanNumber() {
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);
    }

    public static int findValue(char inputSymbol) {
        return romanNumerals.get(inputSymbol);
    }
}

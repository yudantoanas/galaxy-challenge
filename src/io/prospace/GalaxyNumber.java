package io.prospace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GalaxyNumber {
    private RomanNumber romanNumber;

    // store each galaxy numerals and its associate roman number
    private HashMap<String, String> galaxyNumerals;

    public GalaxyNumber(RomanNumber romanNumber) {
        this.romanNumber = romanNumber;
        galaxyNumerals = new HashMap<>();
    }

    void saveGalaxyNumber(List<String> inputStrings) {
        // get number name
        String number = inputStrings.get(0).trim();

        // get roman symbol and value
        String symbol = inputStrings.get(2).trim();

        // save them to galaxy number HashMap
        galaxyNumerals.put(number, symbol);
    }

    String getRomanSymbol(String key) {
        // get roman symbol by passing its key
        return galaxyNumerals.get(key.trim());
    }

    public int calculateQuantities(List<String> input) {
        int total = 0;

        // convert the galaxy numerals input to roman numerals
        String roman = convertInputToRomanNumeral(input);

        // split the above string into array
        List<String> romanSplit = Arrays.asList(roman.split(""));

        if (romanNumber.checkNumberFormat(roman)) {
            // check if roman number is in correct format
            // and iterate every symbol
            for (int i = 0; i < romanSplit.size(); i++) {
                // points the first symbol
                int first = romanNumber.getNumberValue(romanSplit.get(i));

                if ((i + 1) < romanSplit.size()) {
                    // if next number is not null
                    // points the next number symbol
                    int second = romanNumber.getNumberValue(romanSplit.get(i + 1));

                    if (first >= second) {
                        // if the first number is higher than or equal to second
                        // then count only the first number
                        total += first;
                    } else {
                        // otherwise, subtract the second number by first number
                        // and then skip next number
                        total += (second - first);
                        i++;
                    }
                } else {
                    // otherwise, count only the first number
                    // and then skip next number
                    total += first;
                    i++;
                }
            }
        } else {
            // otherwise, display error message and reset total to zero
            System.out.println("Sorry, your input is in wrong format!");
            total = 0;
        }

        return total;
    }

    String convertInputToRomanNumeral(List<String> metalQuantities) {
        StringBuilder result = new StringBuilder();

        for (String metalQuantity : metalQuantities) {
            // get roman number symbol and append it to result string
            result.append(getRomanSymbol(metalQuantity));
        }

        return String.valueOf(result);
    }
}

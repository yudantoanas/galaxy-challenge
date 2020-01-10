package io.prospace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.prospace.RomanNumber.*;

public class GalaxyNumber {
    public static HashMap<String, String> galaxyNumerals = new HashMap<>();

    public static void galaxyNumberInit(List<String> inputStrings) {
        // get number name
        String number = inputStrings.get(0);

        // get roman symbol and value
        String symbol = inputStrings.get(2);

        // save them to galaxy number HashMap
        galaxyNumerals.put(number, symbol);
    }

    public static String getRomanSymbol(String key) {
        return galaxyNumerals.get(key);
    }

    public static int calculateQuantities(List<String> quantities) {
        int total = 0;

        String roman = convertInputToRomanNumeral(quantities);
        List<String> romanSplit = Arrays.asList(roman.split(""));

        if (checkNumberFormat(roman)) {
            // check if roman number is in correct format
            for (int i = 0; i < romanSplit.size(); i++) {
                int first = getNumberValue(romanSplit.get(i));

                if ((i + 1) < romanSplit.size()) {
                    // if next number is not null
                    int second = getNumberValue(romanSplit.get(i + 1));

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
}
package io.prospace;

import java.util.Arrays;
import java.util.List;

import static io.prospace.GalaxyItem.galaxyItemInit;
import static io.prospace.GalaxyItem.metalValues;
import static io.prospace.GalaxyNumber.calculateQuantities;
import static io.prospace.GalaxyNumber.galaxyNumberInit;

public class GalaxyMerchant {
    public GalaxyMerchant() {
        // create object to define the default roman numerals value
        new RomanNumber();
    }

    private static String getGalaxyNumberOnly(String inputString) {
        // returns only the numbers from the given sentence
        return inputString.substring(inputString.indexOf("is") + 3, inputString.indexOf("?")).trim();
    }

    void translateInput(List<String> input) {
        // checking each line
        input.forEach(this::checkStringPattern);
    }

    private void checkStringPattern(String inputString) {
        /*
         * There are 4 types of input
         * 1. Number Definition, ex: glop is X
         * 2. Credits Definition by amount of items, ex: glop glop Silver is 10 Credits
         * 3. "how much" question, ex: how much is pish tegj glop glop ?
         * 4. "how many credits" question, ex: how many credits is glop glop Silver ?
         *
         * if the input is not equal than any of the scenario above, then it will print error message
         */

        if (inputString.contains("is") && inputString.split(" ").length == 3) {
            // Number Definition
            galaxyNumberInit(Arrays.asList(inputString.split(" ")));
        } else if (inputString.contains("is") && inputString.toLowerCase().endsWith("credits")) {
            // Credits Definition
            galaxyItemInit(Arrays.asList(inputString.split(" is ")));
        } else if (inputString.toLowerCase().contains("how much is") && inputString.toLowerCase().endsWith("?")) {
            // "how much" question
            String quantities = getGalaxyNumberOnly(inputString);

            // split the string into arrays in order to calculate the total number
            int total = calculateQuantities(Arrays.asList(quantities.split(" ")));

            System.out.println(quantities + " is " + total);
        } else if (inputString.toLowerCase().contains("how many credits is") && inputString.toLowerCase().endsWith("?")) {
            // "how many credits" question
            String creditsValue = getGalaxyNumberOnly(inputString);

            // get the last word as the Item name
            String metalName = creditsValue.substring(creditsValue.lastIndexOf(" ") + 1);

            // split the string from the item name using substring
            String metalQuantities = creditsValue.substring(0, creditsValue.lastIndexOf(metalName)).trim();

            // again split the above string into string array in order to calculate the total quantity
            double totalQuantity = Double.parseDouble(String.valueOf(calculateQuantities(Arrays.asList(metalQuantities.split(" ")))));

            // get item values by passing item name as key
            double metalValue = metalValues.get(metalName);

            if (Double.POSITIVE_INFINITY == metalValue || Double.NEGATIVE_INFINITY == metalValue) {
                // if item value is match infinite (+/-) then it will print error message
                // usually this will happen if the total quantity is divided by zero
                System.out.println("Sorry, cannot calculate the credits");
            } else {
                // otherwise, it will calculate normally
                int totalCreditsValue = (int) (totalQuantity * metalValue);

                // and prints out the credits sentence
                System.out.println(metalQuantities + " " + metalName + " is " + totalCreditsValue + " Credits");
            }
        } else {
            // if input is not match any of the above criteria.
            System.out.println("I have no idea what you are talking about");
        }
    }
}

package io.prospace;

import java.util.Arrays;
import java.util.List;

import static io.prospace.GalaxyItem.*;
import static io.prospace.GalaxyNumber.*;

public class GalaxyMerchant {
    public GalaxyMerchant() {
        new RomanNumber();
    }

    void translateInput(List<String> input) {
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

            // split the string into arrays in order to calculate the total quantity
            List<String> metalQuantities = Arrays.asList(creditsValue.split(" " + metalName));

            double totalQuantity = Double.parseDouble(String.valueOf(calculateQuantities(Arrays.asList(metalQuantities.get(0).split(" ")))));
            double metalValue = metalValues.get(metalName);

            if (Double.POSITIVE_INFINITY == metalValue || Double.NEGATIVE_INFINITY == metalValue) {
                System.out.println("Sorry, cannot calculate the credits");
            } else {
                int totalCreditsValue = (int) (totalQuantity * metalValue);

                System.out.println(metalQuantities.get(0) + " " + metalName + " is " + totalCreditsValue + " Credits");
            }
        } else {
            System.out.println("I have no idea what you are talking about");
        }
    }

    private static String getGalaxyNumberOnly(String inputString) {
        return inputString.substring(inputString.indexOf("is") + 3, inputString.indexOf("?")).trim();
    }
}

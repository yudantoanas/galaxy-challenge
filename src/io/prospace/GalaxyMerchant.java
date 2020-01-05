package io.prospace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GalaxyMerchant {
    ArrayList<RomanNumber> romanNumbers = new ArrayList<>();

    public GalaxyMerchant() {
        new RomanNumber();
    }

    void translateInput(List<String> input) {
        /*
         * This will produces
         * glob = I = 1
         * prok = V = 5
         * pish = X = 10
         * tegj = L = 50
         * */
        HashMap<String, Character> merchantSymbol = new HashMap<>();
        for (String i : input) {
            String[] strings = i.split(" ");
            if (strings.length == 3) {
                merchantSymbol.put(strings[0], strings[2].charAt(0));
            }
        }
        System.out.println(merchantSymbol);

        List<String> creditsInput = input.stream().filter(it -> it.toLowerCase().endsWith("credits")).collect(Collectors.toList());
        for (String i : creditsInput) {
            String[] strings = i.split(" is ");

            String itemName = strings[0].substring(strings[0].lastIndexOf(" ") + 1);

            List<String> symbols = Arrays.asList(strings[0].split(" " + itemName)[0].split(" "));
            /*List<String> orderedStructure = new ArrayList<>();
            for (String symbol : symbols) {
                if (orderedStructure.isEmpty()) {
                    orderedStructure.add(merchantSymbol.get(symbol));
                }
            }
            char romanChar = merchantSymbol.get(symbols);*/
        }
        System.out.println(creditsInput);
    }
}

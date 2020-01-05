package io.prospace;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GalaxyNumberConvention {
    String symbol;
    RomanNumber romanNumber;

    public GalaxyNumberConvention(String symbol, RomanNumber romanNumber) {
        this.symbol = symbol;
        this.romanNumber = romanNumber;
    }

    public static GalaxyNumberConvention galaxyItemValue(String symbol, List<GalaxyNumberConvention> numberConventions) {
        System.out.println(numberConventions.size());
        for (GalaxyNumberConvention numberConvention : numberConventions) {
            if (numberConvention.symbol.equals(symbol)) {
                return numberConvention;
            }
        }
        return null;
    }

    public static List<GalaxyNumberConvention> createGalaxyItemValue(List<String> input, List<GalaxyNumberConvention> numberConventions) {
        List<GalaxyNumberConvention> galaxyNumberConventions = new ArrayList<>();
        input.forEach(it -> galaxyNumberConventions.add(galaxyItemValue(it, numberConventions)));
        return galaxyNumberConventions;
    }

    public static int calculateNumbers(ArrayList<Integer> numbers) {
        int total = 0;

        for (int i = 0; i < numbers.size(); i++) {
            int first = numbers.get(i);
            if (i + 1 < numbers.size()) {
                int second =numbers.get((i + 1));
                if ( first >= second) {
                    total += numbers.get(i);
                } else {
                    total += numbers.get((i+1)) - numbers.get(i);
                }
            } else {
                total += numbers.get(i);
            }
        }

        return total;
    }
}

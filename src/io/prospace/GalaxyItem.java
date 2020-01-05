package io.prospace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GalaxyItem {
    String itemName;
    int itemValue;

    public GalaxyItem(String itemName, int itemValue) {
        this.itemName = itemName;
        this.itemValue = itemValue;
    }

    public static List<GalaxyItem> itemTransaction(List<String> iteminput, List<GalaxyNumberConvention> galaxyNumberConventions) {
        List<String> inputs = new ArrayList<>();
        for (String input: iteminput) {
            inputs.add(String.valueOf(input.toLowerCase().endsWith("credits")));
        }

        List<GalaxyItem> galaxyItems = new ArrayList<>();
        for (String input : inputs) {
            List<GalaxyNumberConvention> numberConventions = GalaxyNumberConvention
                    .createGalaxyItemValue(Arrays.asList(input.split(" ")), galaxyNumberConventions);
            System.out.println(numberConventions);
        }

        return null;
    }
}

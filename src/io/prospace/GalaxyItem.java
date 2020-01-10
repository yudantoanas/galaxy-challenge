package io.prospace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static io.prospace.GalaxyNumber.*;

public class GalaxyItem {
    // store each item name and values
    public static HashMap<String, Double> metalValues = new HashMap<>();

    public static void galaxyItemInit(List<String> inputStrings) {
        String metal = inputStrings.get(0);
        String metalName = metal.substring(metal.lastIndexOf(" ") + 1);

        List<String> metalQuantities = Arrays.asList(metal.split(" " + metalName));
        int totalQuantity = calculateQuantities(Arrays.asList(metalQuantities.get(0).split(" ")));

        String value = inputStrings.get(1).substring(0, inputStrings.get(1).indexOf(" "));

        int totalValue = Integer.parseInt(value);
        double metalValue = (Double.parseDouble(String.valueOf(totalValue)) / Double.parseDouble(String.valueOf(totalQuantity)));

        GalaxyItem.metalValues.put(metalName, metalValue);
    }
}

package io.prospace;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GalaxyItem {
    private GalaxyNumber galaxyNumber;

    // store each item name and values
    private HashMap<String, Double> metalValues;

    public GalaxyItem(GalaxyNumber galaxyNumber) {
        this.galaxyNumber = galaxyNumber;

        metalValues = new HashMap<>();
    }

    void saveGalaxyItem(List<String> inputStrings) {
        String metal = inputStrings.get(0);
        String metalName = metal.substring(metal.lastIndexOf(" ") + 1);

        List<String> metalQuantities = Arrays.asList(metal.split(" " + metalName));
        int totalQuantity = galaxyNumber.calculateQuantities(Arrays.asList(metalQuantities.get(0).split(" ")));

        String value = inputStrings.get(1).substring(0, inputStrings.get(1).indexOf(" "));

        int totalValue = Integer.parseInt(value);
        double metalValue = (Double.parseDouble(String.valueOf(totalValue)) / Double.parseDouble(String.valueOf(totalQuantity)));

        metalValues.put(metalName, metalValue);
    }

    Double getItemValues(String key) {
        return metalValues.get(key);
    }
}

package io.prospace;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GalaxyMerchantTest {
    private GalaxyNumber galaxyNumber;

    public GalaxyMerchantTest() {
        RomanNumber romanNumber = new RomanNumber();
        galaxyNumber = new GalaxyNumber(romanNumber);
    }

    /* calculate galaxy number quantity when number matched format */
    @Test
    void calculateGalaxyNumberQuantityTest() throws FileNotFoundException {
        // read input from file .txt
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        List<String> inputString = reader.lines().collect(Collectors.toList());

        for (String s : inputString) {
            if (s.contains("is") && s.split(" ").length == 3) {
                // Galaxy Number Definition
                galaxyNumber.saveGalaxyNumber(Arrays.asList(s.split(" ")));
            }
        }

        // Galaxy number that is equal to XLIV (44)
        String number = "pish tegj glob prok";

        int total = galaxyNumber.calculateQuantities(Arrays.asList(number.split(" ")));

        assertEquals(44, total);
    }

    /* calculate galaxy number quantity when number doesn't matched format */
    @Test
    void calculateGalaxyNumberQuantityZeroTest() throws FileNotFoundException {
        // read input from file .txt
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        List<String> inputString = reader.lines().collect(Collectors.toList());

        for (String s : inputString) {
            if (s.contains("is") && s.split(" ").length == 3) {
                // Galaxy Number Definition
                galaxyNumber.saveGalaxyNumber(Arrays.asList(s.split(" ")));
            }
        }

        // Galaxy number that is equal to XLXIV
        String number = "pish tegj pish glob prok";

        int total = galaxyNumber.calculateQuantities(Arrays.asList(number.split(" ")));

        assertEquals(0, total);
    }
}
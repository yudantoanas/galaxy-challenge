package io.prospace;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // read input from file .txt
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));

        new GalaxyMerchant().translateInput(reader.lines().collect(Collectors.toList()));
    }
}

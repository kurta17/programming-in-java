package com.harbourspace.lesson06;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathTask {

    public static double generateRandomNumber(double min, double max, int decimalPlaces) {
        // Validate inputs
        if (min >= max) {
            throw new IllegalArgumentException("Minimum value must be less than maximum value");
        }
        if (decimalPlaces < 0) {
            throw new IllegalArgumentException("Number of decimal places must be non-negative");
        }

        // Generate a random number between 0 and 1
        double randomDouble = Math.random();

        // Scale and shift the random number to the desired range
        double scaledRandom = min + randomDouble * (max - min);

        // Round the number to the specified decimal places
        BigDecimal roundedRandom = BigDecimal.valueOf(scaledRandom)
                .setScale(decimalPlaces, RoundingMode.HALF_UP);

        return roundedRandom.doubleValue();
    }

    public static void main(String[] args) {
        double min = 5.0;
        double max = 10.0;
        int decimalPlaces = 2;

        double randomNumber = generateRandomNumber(min, max, decimalPlaces);
        System.out.println("Random number: " + randomNumber);
    }

}

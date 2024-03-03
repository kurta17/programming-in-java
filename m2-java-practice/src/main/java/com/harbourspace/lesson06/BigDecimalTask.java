package com.harbourspace.lesson06;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTask {
    BigDecimal radius;
    int decimalPlaces;
    BigDecimal pi = BigDecimal.valueOf(Math.PI);

    public BigDecimalTask(BigDecimal radius, int decimalPlaces) {
        this.radius = radius;
        this.decimalPlaces = decimalPlaces;
    }


    public BigDecimal getArea() {
        return pi.multiply(radius.pow(2)).setScale(decimalPlaces, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        BigDecimal radius = BigDecimal.valueOf(5.0);
        int decimalPlaces = 2;

        BigDecimalTask task = new BigDecimalTask(radius, decimalPlaces);
        BigDecimal expectedArea = BigDecimal.valueOf(78.54); // π * r^2 = π * 5^2 = 78.54
        BigDecimal actualArea = task.getArea();

        System.out.println("Expected area: " + expectedArea);
        System.out.println("Actual area: " + actualArea);
    }


}

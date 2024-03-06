package com.harbourspace.lesson06.homework;

import com.harbourspace.lesson06.BigDecimalTask;
import com.harbourspace.lesson06.MathTask;
import com.harbourspace.lesson06.OptionalTask;
import com.harbourspace.lesson07.City;
import com.harbourspace.lesson07.DataReader;
import com.harbourspace.lesson07.Statistics;
import com.harbourspace.lesson09.*;
import com.harbourspace.lesson10.Json;
import com.harbourspace.lesson10.Student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

public class DontForgetToTest {

    @Test
    public void test() {
        assertEquals("Don't forget to test your code!", "Don't forget to test your code!");
    }


    // math Task
    @Test
    void testGenerateRandomNumberWithinRange() {
        double min = 15.0;
        double max = 32.0;
        int decimalPlaces = 2;

        double randomNumber = MathTask.generateRandomNumber(min, max, decimalPlaces);

        assertTrue(randomNumber >= min && randomNumber <= max);
    }
    // BigDecimalTask
    @Test
    void testGetAreaWithPositiveRadiusAndDecimalPlaces() {
        BigDecimal radius = BigDecimal.valueOf(5.0);
        int decimalPlaces = 2;

        BigDecimalTask task = new BigDecimalTask(radius, decimalPlaces);
        BigDecimal expectedArea = BigDecimal.valueOf(78.54); // π * r^2 = π * 5^2 = 78.54
        BigDecimal actualArea = task.getArea();

        assertEquals(expectedArea, actualArea);
    }

    // Lesson06 OptionalTask
    @Test
    void getWord_WordPresent_ReturnsOptionalWithWord() {
        String text = "This is a sample text containing the word Java.";
        String wordToFind = "Java";

        Optional<String> result = OptionalTask.getWord(text, wordToFind);

        assertTrue(result.isPresent(), "Word should be present in the text");
        assertEquals(wordToFind, result.get(), "Returned word should match the expected word");
    }


    @Test
    void getWord_WordNotPresent_ReturnsEmptyOptional() {
        String text = "This is a sample text without the word JAVA.";
        String wordToFind = "Python";

        Optional<String> result = OptionalTask.getWord(text, wordToFind);

        assertFalse(result.isPresent(), "Word should not be present in the text");
    }

    // Lesson06 Homework

    @Test
    public void testCalculateDailyStatistics() {
        // Create sample MeteoData objects
        List<MeteoData> sampleData = new ArrayList<>();
        sampleData.add(new MeteoData(ZonedDateTime.parse("2024-03-01T12:00:00Z"), 25.0, 60.0, 0.0));
        sampleData.add(new MeteoData(ZonedDateTime.parse("2024-03-01T15:00:00Z"), 27.0, 65.0, 0.0));
        sampleData.add(new MeteoData(ZonedDateTime.parse("2024-03-02T12:00:00Z"), 22.0, 55.0, 1.5));
        sampleData.add(new MeteoData(ZonedDateTime.parse("2024-03-02T15:00:00Z"), 24.0, 58.0, 0.5));

        // Define the expected results
        List<MeteoData> expectedDailyStatistics = new ArrayList<>();
        expectedDailyStatistics.add(new MeteoData(ZonedDateTime.parse("2024-03-01T00:00:00Z"), 26.0, 62.5, 0.0));
        expectedDailyStatistics.add(new MeteoData(ZonedDateTime.parse("2024-03-02T00:00:00Z"), 23.0, 56.5, 2.0));

        // Calculate daily statistics
        ZoneId timeZone = ZoneId.of("UTC");
        List<MeteoData> actualDailyStatistics = MeteoDataAnalyzer.calculateDailyStatistics(sampleData, timeZone);

// Compare the actual and expected results
        assertEquals(expectedDailyStatistics.size(), actualDailyStatistics.size());
        for (int i = 0; i < expectedDailyStatistics.size(); i++) {
            MeteoData expectedData = expectedDailyStatistics.get(i);
            MeteoData actualData = actualDailyStatistics.get(i);
            assertEquals(expectedData.getTime().withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime(),
                    actualData.getTime().withZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
            assertEquals(expectedData.getTemperature(), actualData.getTemperature());
            assertEquals(expectedData.getHumidity(), actualData.getHumidity());
            assertEquals(expectedData.getPrecipitation(), actualData.getPrecipitation());
        }

    }

    //Lesson07
    @Test
    public void testCityConstructor() {
        City city = new City("Tokyo", "Japan", 37732000);
        assertEquals("Tokyo", city.getName());
        assertEquals("Japan", city.getCountry());
        assertEquals(37732000, city.getPopulation());
    }

    @Test
    public void testCityComparator() {
        City city1 = new City("Tokyo", "Japan", 37732000);
        City city2 = new City("Shanghai", "China", 27300000);
        assertTrue(city1.compareTo(city2) <= 0);
    }





    //Lesson09 giftBox
    @Test
    public void testGiftBoxWithString() {
        GiftBox<String> stringBox = new GiftBox<>();
        String gift = "Chocolates";
        stringBox.put(gift);
        assertEquals(gift, stringBox.get());
    }

    @Test
    public void testGiftBoxWithInteger() {
        GiftBox<Integer> intBox = new GiftBox<>();
        int gift = 123;
        intBox.put(gift);
        assertEquals(gift, (int) intBox.get());
    }


    @Test
    public void testGiftBoxWithBoolean() {
        GiftBox<Boolean> booleanBox = new GiftBox<>();
        boolean gift = true;
        booleanBox.put(gift);
        assertEquals(gift, booleanBox.get());
    }

    //Lesson09 Magic
    @Test
    public void testDoMagicWithIntegerAddition() {
        BiFunction<Integer, Integer, Integer> addition = (a, b) -> {
            return Integer.sum(a, b);
        };
        int result = Magic.doMagic(5, 3, addition);
        assertEquals(8, result);
    }

    @Test
    public void testDoMagicWithStringConcatenation() {
        BiFunction<String, String, String> concatenation = (a, b) -> a + b;
        String result = Magic.doMagic("Hello, ", "world!", concatenation);
        assertEquals("Hello, world!", result);
    }


    @Test
    public void testDoMagicWithDoubleMultiplication() {
        BiFunction<Double, Double, Double> multiplication = (a, b) -> a * b;
        double result = Magic.doMagic(3.5, 2.0, multiplication);
        assertEquals(7.0, result, 0.0001);
    }

    @Test
    public void testDoMagicWithBooleanLogic() {
        BiFunction<Boolean, Boolean, Boolean> logic = (a, b) -> a && b;
        boolean result = Magic.doMagic(true, false, logic);
        assertFalse(result);
    }

    //Lesson9 magicWithGenerics
    @Test
    public void testDoMagicWithGenerics() {
        BiFunction<Integer, Double, String> magicFunction = (a, b) -> "Result: " + (a * b);
        String result = MagicWithGenerics.doMagic(5, 2.5, magicFunction);
        assertEquals("Result: 12.5", result);
    }

    // Lesson9 MagicWithFanction
    @Test
    public void testDoMagicWithFunctionalInterface() {
        MagicFunction<Integer, Double, String> magicFunction = (a, b) -> "Result: " + (a * b);
        String result = MagicWithFunctionalInterface.doMagic(5, 2.5, magicFunction);
        assertEquals("Result: 12.5", result);
    }

    //Lesson10 student

    @Test
    public void testJsonSerialization() throws Exception {
        Student student = new Student(1L, "John Doe", 3, true, LocalDate.parse("2022-01-15"), null, null);
        String expectedJson = "{\"id\":1,\"fullName\":\"John Doe\",\"course\":3,\"isEnrolled\":true,\"admissionDate\":\"2022-01-15\"}";
        assertEquals(expectedJson, Json.toJSON(student));
    }

    @Test
    public void testJsonSerializationWithAllFields() throws Exception {
        Student student = new Student(1L, "Jane Smith", 4, false, LocalDate.parse("2021-09-01"), LocalDate.parse("2025-06-30"), 85.5);
        String expectedJson = "{\"id\":1,\"fullName\":\"Jane Smith\",\"course\":4,\"isEnrolled\":false,\"admissionDate\":\"2021-09-01\",\"graduationDate\":\"2025-06-30\",\"grade\":85.5}";
        assertEquals(expectedJson, Json.toJSON(student));
    }

}

package com.harbourspace.lesson06.homework;

import com.harbourspace.lesson06.BigDecimalTask;
import com.harbourspace.lesson06.MathTask;
import com.harbourspace.lesson09.GiftBox;
import com.harbourspace.lesson09.Magic;
import com.harbourspace.lesson10.Json;
import com.harbourspace.lesson10.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.function.BiFunction;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DontForgetToTest {

    @Test
    public void test() {
        Assertions.fail("Don't forget to test your code!");
    }

    // math Task
    @Test
    void testGenerateRandomNumberWithinRange() {
        double min = 15.0;
        double max = 32.0;
        int decimalPlaces = 2;

        double randomNumber = MathTask.generateRandomNumber(min, max, decimalPlaces);

        Assertions.assertTrue(randomNumber >= min && randomNumber <= max);
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
    public void testGiftBoxWithDouble() {
        GiftBox<Double> doubleBox = new GiftBox<>();
        double gift = 3.14;
        doubleBox.put(gift);
        assertEquals(gift, doubleBox.get(), 0.0001);
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

    //Lesson10 student

    @Test
    public void testSerialization() throws Exception {
        Student student = new Student(1L, "John Doe", 1, true, LocalDate.of(2023, 9, 1), null, null);
        String expected = "{\"id\":1,\"fullName\":\"John Doe\",\"course\":1,\"isEnrolled\":true,\"admissionDate\":\"2023-09-01\"}";
        assertEquals(expected, Json.toJSON(student));
    }

    @Test
    public void testSerializationWithOptionalFields() throws Exception {
        Student student = new Student(1L, "Jane Doe", 2, true, LocalDate.of(2023, 9, 1), LocalDate.of(2027, 6, 1), 85.5);
        String expected = "{\"id\":1,\"fullName\":\"Jane Doe\",\"course\":2,\"isEnrolled\":true,\"admissionDate\":\"2023-09-01\",\"graduationDate\":\"2027-06-01\",\"grade\":85.5}";
        assertEquals(expected, Json.toJSON(student));
    }


    @Test
    public void testSerializationWithNullFields() throws Exception {
        Student student = new Student(1L, "James Doe", 3, false, null, null, null);
        String expected = "{\"id\":1,\"fullName\":\"James Doe\",\"course\":3,\"isEnrolled\":false}";
        assertEquals(expected, Json.toJSON(student));
    }




}

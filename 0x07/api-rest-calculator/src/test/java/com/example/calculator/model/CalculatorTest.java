package com.example.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void sumTest() {
        Double result = calculator.sum(5.0, 3.0);
        assertEquals(8.0, result);
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calculator.sum(null, 1.0));
        assertThrows(NullPointerException.class, () -> calculator.sum(1.0, null));
        assertThrows(NullPointerException.class, () -> calculator.sum(null, null));
    }

    @Test
    void subTest() {
        Double result = calculator.sub(10.0, 3.0);
        assertEquals(7.0, result);
    }

    @Test
    void divideTest() {
        Double result = calculator.divide(10.0, 2.0);
        assertEquals(5.0, result);
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    void factorialTest() {
        Integer fact5 = calculator.factorial(5);
        assertEquals(120, fact5);

        Integer fact0 = calculator.factorial(0);
        assertEquals(1, fact0);
    }

    @Test
    void integerToBinaryTest() {
        String binary = calculator.integerToBinary(20);
        assertEquals("10100", binary);

        String binaryOne = calculator.integerToBinary(1);
        assertEquals("1", binaryOne);
    }

    @Test
    void integerToHexadecimalTest() {
        String hex = calculator.integerToHexadecimal(170);
        assertEquals("AA", hex);

        String hexFive = calculator.integerToHexadecimal(5);
        assertEquals("5", hexFive);
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate d1 = LocalDate.of(2020, 3, 15);
        LocalDate d2 = LocalDate.of(2020, 3, 29);
        String days = calculator.calculeDayBetweenDate(d1, d2);
        assertEquals("14", days);

        // ordem inversa também deve funcionar (valor absoluto)
        String daysReversed = calculator.calculeDayBetweenDate(d2, d1);
        assertEquals("14", daysReversed);
    }
}


package com.example.calculator;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class CalculatorApplicationTests {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void contextLoads() {
    }

    @Test
    void testAdd() {
        assertEquals(5, calculatorService.add(2, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(1, calculatorService.subtract(3, 2));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculatorService.multiply(2, 3));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculatorService.divide(6, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(1, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}

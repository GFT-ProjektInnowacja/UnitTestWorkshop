package com.unit.UNIT.TEST;

import org.junit.jupiter.api.*;

class TestClassTest {
    @BeforeEach
    public void beforeMethod() {
        System.out.println("WYKONANE PRZED TESTEM");
    }

    @AfterEach
    public void afterMethod() {
        System.out.println("WYKONANIE PO KAŻDYM TESCIE");
    }

    @BeforeAll
    public static void beforeClass() {
        System.out.println("WYKONANE PRZED KLASĄ");
    }

    @AfterAll
    public static void afterClass() {
        System.out.println("WYKONANIE PO KLASIE");
    }

    @Test
    public void testMethod() {
        System.out.println("TEST1");
    }

    @Test
    public void testMethod2() {
        System.out.println("TEST2");
    }
}
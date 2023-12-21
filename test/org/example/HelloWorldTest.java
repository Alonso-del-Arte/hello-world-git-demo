/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package org.example;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests of the HelloWorld class.
 * @author Alonso del Arte
 */
public class HelloWorldTest {
    
    private static final List<Locale> AVAILABLE_LOCALES 
            = Arrays.asList(Locale.getAvailableLocales());
    
    private static List<Locale> getByISO3Language(String iso3Tag) {
        return AVAILABLE_LOCALES.stream().filter(loc 
                -> loc.getISO3Language().equals(iso3Tag))
                .collect(Collectors.toList());
    }
    
    /**
     * Test of the greeting function, of the HelloWorld class.
     */
    @Test
    public void testGreeting() {
        System.out.println("greeting");
        List<Locale> locales = getByISO3Language("eng");
        String expected = "Hello, world!";
        for (Locale locale : locales) {
            String actual = HelloWorld.greeting(locale);
            assertEquals(expected, actual);
        }
    }

    /**
     * Another test of the greeting function, of the HelloWorld class. For 
     * Spanish-speaking locales, the greeting should be "&iexcl;Hola, mundo!"
     */
    @Test
    public void testGreetingSpanish() {
        List<Locale> locales = getByISO3Language("spa");
        String expected = "\u00A1Hola, mundo!";
        for (Locale locale : locales) {
            String actual = HelloWorld.greeting(locale);
            assertEquals(expected, actual);
        }
    }

    /**
     * Test of the main procedure, of the HelloWorld class.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        HelloWorld.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

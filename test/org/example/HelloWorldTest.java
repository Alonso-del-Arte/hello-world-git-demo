/*
 * Copyright (C) 2024 Alonso del Arte
 *
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more 
 * details.
 *
 * You should have received a copy of the GNU General Public License along with 
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.example;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.List;
import java.util.Map;
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
     * non-English-speaking locales, such as for Spanish and German, we might be 
     * able to provide other greetings.
     */
    @Test
    public void testGreetingOtherLocaleLanguages() {
        String koreanGreeting = "\uC548\uB155\uD558\uC138\uC694, " 
                + "\uC138\uACC4\uC785\uB2C8\uB2E4!";
        Map<String, String> expGreetings = Map.of("deu", "Hallo Welt!", 
                "fra", "Bonjour le monde!", "ita", "Ciao mondo!", 
                "jpn", "\u3053\u3093\u306B\u3061\u306F\u4E16\u754C\uFF01", 
                "kor", koreanGreeting, "por", "Ol\u00E1 mundo!", 
                "spa", "\u00A1Hola, mundo!", 
                "zho", "\u4F60\u597D\u4E16\u754C\uFF01");
        expGreetings.forEach((iso3Tag, expected) -> {
            List<Locale> locales = getByISO3Language(iso3Tag);
            for (Locale locale : locales) {
                String actual = HelloWorld.greeting(locale);
                String message = "Greeting for " + locale.getDisplayName() 
                        + " expected to be \"" + expected + "\"";
                assertEquals(message, expected, actual);
            }
        });
    }

    /**
     * Test of the main procedure, of the HelloWorld class.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        Locale initialLocale = Locale.getDefault();
        System.out.println("About to switch from initial locale " 
                + initialLocale.getDisplayName());
        Locale[] locales = Locale.getAvailableLocales();
        int initialCapacity = locales.length;
        Map<Locale, String> expecteds = new HashMap<>(initialCapacity);
        Map<Locale, String> actuals = new HashMap<>(initialCapacity);
        PrintStream usualOut = System.out;
        usualOut.println("About to reroute usual output stream");
        String[] args = {};
        for (Locale locale : locales) {
            Locale.setDefault(locale);
            try (OutputStream interceptor = new ByteArrayOutputStream()) {
                System.setOut(new PrintStream(interceptor));
                HelloWorld.main(args);
                expecteds.put(locale, HelloWorld.greeting(locale));
                actuals.put(locale, interceptor.toString());
                interceptor.close();
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        }
        System.setOut(usualOut);
        usualOut.println("Restored usual output stream");
        Locale.setDefault(initialLocale);
        usualOut.println("Restored initial locale " 
                + initialLocale.getDisplayName());
        for (Locale visitedLocale : expecteds.keySet()) {
            String expected = expecteds.get(visitedLocale);
            String actual = actuals.get(visitedLocale);
            String msg = "Querying greeting for locale " 
                    + visitedLocale.getDisplayName() + ", expected " + expected 
                    + ", got " + actual;
            assert actual.contains(expected) : msg;
        }
    }
    
}

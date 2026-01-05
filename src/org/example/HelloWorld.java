/*
 * Copyright (C) 2026 Alonso del Arte
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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A simple program that displays a "Hello, world" greeting on the console.
 * @author Alonso del Arte
 */
public class HelloWorld {
    
    private static final String KOREAN_GREETING 
            = "\uC548\uB155\uD558\uC138\uC694, \uC138\uACC4\uC785\uB2C8\uB2E4!";
    
    public static String greetingWord(int count, Locale locale) {
        String key = (count == 1) ? "greetingWordSingular" 
                : "greetingWordPlural";
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.Messages", 
                locale);
        return bundle.getString(key);
    }
    
    public static String greeting(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n.Messages", 
                locale);
        return bundle.getString("greeting");
    }
    
    public static void main(String[] args) {
        System.out.println(greeting(Locale.getDefault()));
    }
    
}

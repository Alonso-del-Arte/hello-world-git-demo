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

import java.util.Locale;

/**
 *
 * @author Alonso del Arte
 */
public class HelloWorld {
    
    private static final String KOREAN_GREETING 
            = "\uC548\uB155\uD558\uC138\uC694, \uC138\uACC4\uC785\uB2C8\uB2E4!";
    
    public static String greeting(Locale locale) {
        return switch (locale.getISO3Language()) {
            case "deu" -> "Hallo Welt!";
            case "eng" -> "Hello, world!";
            case "fra" -> "Bonjour le monde!";
            case "ita" -> "Ciao mondo!";
            case "jpn" -> "\u3053\u3093\u306B\u3061\u306F\u4E16\u754C\uFF01";
            case "kor" -> KOREAN_GREETING;
            case "spa" -> "\u00A1Hola, mundo!";
            case "zho" -> "\u4F60\u597D\u4E16\u754C\uFF01";
            default -> "SORRY, NOT IMPLEMENTED YET";
        };
    }
    
    public static void main(String[] args) {
        System.out.println("World, hello?");
    }
    
}

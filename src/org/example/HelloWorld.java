/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

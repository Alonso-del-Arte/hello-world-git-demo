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
    
    public static String greeting(Locale locale) {return "SORRY";
//        return switch (locale.getISO3Language()) {
//            case "deu" -> "Hallo Welt!";
//            case "eng" -> "Hello, world!";
//            case "fra" -> "Bonjour le monde!";
//            case "ita" -> "Ciao mondo!";
//            case "spa" -> "\u00A1Hola, mundo!";
//            default -> "SORRY, NOT IMPLEMENTED YET";
//        };
    }
    
    public static void main(String[] args) {
        System.out.println("World, hello?");
    }
    
}

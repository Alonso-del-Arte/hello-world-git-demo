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
    
    public static String greeting(Locale locale) {
        if (locale.getISO3Language().equals("eng")) {
            return "Hello, world!";
        } else {
            return "\u00A1Hola, mundo!";
        }
    }
    
    public static void main(String[] args) {
        System.out.println("World, hello?");
    }
    
}

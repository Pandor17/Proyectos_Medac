/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadesjava4_20;

import java.util.Scanner;

/**
 *Realiza una función en Java que reciba una palabra y calcule si es un palíndromo o no. Deberás realizar el ejercicio realizando una función como la siguiente:
public static boolean esPalindromo(String frase)
{
boolean espalin;
// Aquí tu código
return espalin;
}
 * @author beapa
 */
public class Tema4Act1Palindromo {
    public static boolean esPalindromo (String frase){
        boolean esPalin = true;
        String fraseTemporal = ""; //String donde guardo la frase en mayúsculas y sin espacios
        for (int i=0;i<frase.length();i++){
            if(frase.charAt(i) != ' '){
                fraseTemporal += frase.charAt(i);
            }
                       
        }
        fraseTemporal = fraseTemporal.toUpperCase();
        
        for(int i=0;i<((fraseTemporal.length()/2)+1) && esPalin==true;i++){//bucle para comparar los caracteres
            if(fraseTemporal.charAt(i) != fraseTemporal.charAt(fraseTemporal.length()-1-i)){
                esPalin = false;
            }
        }
        return esPalin;
    }
    
    public static void main(String[] args) {
        System.out.println("Digita una frase para comprobar si es un palíndromo");
        Scanner escaner = new Scanner(System.in);
        String frase = escaner.nextLine();
        System.out.println(esPalindromo(frase));
    }
}

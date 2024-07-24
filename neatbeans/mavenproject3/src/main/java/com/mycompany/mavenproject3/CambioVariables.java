/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Tema2Act2;

/**
 *hacer que variable1 tome el valor de variable2 y viceversa
 * @author beapa
 */
public class CambioVariables {
  
    
    public static void cambioVariables(int var1, int var2){ //método para cambiar las variables
        int c = var1;
        var1 = var2;
        var2 = c;
        System.out.println("El primer número ahora vale: "+ var1);
        System.out.println("El segundo número ahora vale: "+ var2);
    }
    
}

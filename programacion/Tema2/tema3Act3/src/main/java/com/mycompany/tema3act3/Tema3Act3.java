/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tema3act3;

import java.util.Scanner;

/**
 *Realiza un programa en Java que simule la cafetería de una facultad.
El programa pedirá los siguientes datos al usuario:
1. Cantidad de cafés que se van a tomar.
2. Cantidad de tostadas que se van a tomar.
3. Cantidad de zumos de naranja natural que se van a tomar.
 * @author beapa
 * 
 * El programa deberá calcular y mostrar cuánto deberá el pagar el usuario, siendo los precios los siguientes:
1. Precio de 1 café: 1.1€
2. Precio de 1 tostada: 1.5€
3. Precio de 1 zumo de naranja natural: 2€
 */
public class Tema3Act3 {

    public static void main(String[] args) {
        int iCafes;
        int iTostadas;
        int iZumos;
        Scanner escaner = new Scanner(System.in);
        
        //Pedimos los datos y los guardamos en cada variable
        System.out.println("¿Cuántos cafés desea tomar?: ");
        iCafes = escaner.nextInt();
        System.out.println("¿Cuántas tostadas desea tomar?: ");
        iTostadas = escaner.nextInt();
        System.out.println("¿Cuántos zumos desea tomar?: ");
        iZumos = escaner.nextInt();
        
        //Hacemos el cálculo de precios y lo saco por pantalla
        double dPrecioTotal = iCafes*1.1 + iTostadas*1.5 + iZumos*2;
        System.out.println("El precio total a pagar en caja es: "+dPrecioTotal);
    }
}

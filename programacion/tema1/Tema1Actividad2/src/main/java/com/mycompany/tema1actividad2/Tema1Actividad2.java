/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tema1actividad2;

import java.time.LocalDate;

/*Indica y justifica qué tipo de datos de los que hemos estudiado utilizarías para representar lo siguiente:
1. El precio de una barra de pan.
2. El nombre de una constelación.
3. El DNI de una persona.
4. La cantidad ovejas que hay en un rebaño.
5. La matrícula de un coche.
6. La distancia recorrida por un avión durante un vuelo.
7. La velocidad media de una motocicleta.
8. La cantidad de calorías que tiene un yogurt.
9. La fecha de nacimiento de una persona.
10. El signo del zodíaco de una persona.*/

public class Tema1Actividad2 {

    public static void main(String[] args) {
       float precioBarraPan = 1.05f; 
       float caloriasYogurt = (float)134.79;
       String nombreConstelacion = "Sagitario";
       double numeroOvejas = 267;
       String fNacimiento = "02/12/1999";
       LocalDate fechaActual = LocalDate.now();
       
       System.out.println("precio de una barra de pan con conversor implicito: " + precioBarraPan);
       System.out.println("calorías de un yogurt con conversor explicito: " + caloriasYogurt);
       System.out.println("el nombre de la constelación es " + nombreConstelacion);
       System.out.println(fNacimiento);
       System.out.println(fechaActual);
       
       fechaActual = LocalDate.of(1991,1,1); //Cambio el valor de la variable fechaActual
       System.out.println(fechaActual);
     
    }
}

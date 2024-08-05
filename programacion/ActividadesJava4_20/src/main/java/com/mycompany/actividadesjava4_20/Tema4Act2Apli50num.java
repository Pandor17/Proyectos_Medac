/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.actividadesjava4_20;

import java.util.Random;
import java.util.Scanner;

/**
 *Desarrolla una aplicación que genere un array de 5 números aleatorios. El programa mostrará al usuario
el siguiente menú hasta que éste pulse la opción ‘Salir’:
Menú
1. Mostrar el array.
2. Mostrar el array en orden inverso.
3. Buscar el número menor.
4. Buscar el número mayor.
5. Comprobar si existe un número en el array.
6. Cambiar el valor de un número.
7. Cambiar dos números de posición.
0. Salir
Deberás crear un método para cada una de las opciones del menú.
 * @author beapa
 */
public class Tema4Act2Apli50num {
    //MÉTODOS
    public static int[] generar5NumAleatorios (){//M. para generar los 5 números aleatorios
        int[] numeros = new int[5];
        Random random = new Random();
        for(int i=0;i<5;i++){
            numeros[i] = random.nextInt(100);
        }
        return numeros;    
    }
    
    public static void mostrarArray(int[] numeros){//1. mostrarMostrar el array.
        for(int i=0;i<5;i++){
            System.out.print(numeros[i]);
            if(i<4)System.out.print(" - ");
            else System.out.println();
        }
    }
    public static void mostrarInverso(int[] numeros){//2. Mostrar el array en orden inverso.
        for(int i=0;i<5;i++){
            System.out.print(numeros[4-i]);
            if(i<4)System.out.print(" - ");
            else System.out.println();
        }
    }
    public static int buscarMenor(int[] numeros){//3. Buscar el número menor.
        int menor=numeros[0];
        for(int i=1;i<5;i++){
            if(menor>numeros[i])menor=numeros[i];
        }
        return menor;
    }      
    public static int buscarMayor(int[] numeros){//4. Buscar el número mayor.
        int mayor=numeros[0];
        for(int i=1;i<5;i++){
            if(mayor<numeros[i])mayor=numeros[i];
        }
        return mayor;
    }
    public static boolean numeroExiste(int[] numeros, int numero){//5. Comprobar si existe un número en el array.
        boolean existe = false;
        for(int i=1;i<5 && existe == false;i++){
            if(numero == numeros[i])existe = true;
        }
        return existe;
    }
    //6. Cambiar el valor de un número.
    //7. Cambiar dos números de posición.
    //0. Salir
    
    //MAIN
    public static void main(String[] args) {
        int[] array = generar5NumAleatorios();
        //MENÚ
        int nElegido = 1;
        do{
            System.out.println("Elija la opción que desea realizar:\n" +
                           "1. Mostrar el array.\n" +
                           "2. Mostrar el array en orden inverso.\n" +
                           "3. Buscar el número menor.\n" +
                           "4. Buscar el número mayor.\n" +
                           "5. Comprobar si existe un número en el array.\n" +
                           "6. Cambiar el valor de un número.\n" +
                           "7. Cambiar dos números de posición.\n" +
                           "0. Salir");
            Scanner escaner = new Scanner(System.in);
            nElegido = escaner.nextInt();
            switch(nElegido){
                case 1://1. mostrarMostrar el array.
                    mostrarArray(array);
                    break;
                case 2://2. Mostrar el array en orden inverso.
                    mostrarInverso(array);
                    break;
                case 3:    //3. Buscar el número menor.
                    System.out.println("El número más pequeño es el "+buscarMenor(array)+".");
                    break;
                case 4:    //4. Buscar el número mayor.
                    System.out.println("El número más pequeño es el "+buscarMayor(array)+".");
                    break;
                case 5:    //5. Comprobar si existe un número en el array.
                    System.out.println("Digite el número que desea comprobar: ");
                    int elegido = escaner.nextInt();
                    if(numeroExiste(array, elegido))System.out.println("El número se encuentra en el array");
                    else System.out.println("El número no se encuentra en el array");
                    break;
                case 6:    //6. Cambiar el valor de un número.
                    break;
                case 7:    //7. Cambiar dos números de posición.
                    break;
                case 0:    //0. Salir
                    break;
                default:
                    //Número de día inválido
                    System.out.println("El número introducido no pertenece a niguan opción, vuelva a teclear la opción que desee realizar");
            }
        }while(nElegido != 0);
        System.out.println("Ha seleccionado salir");
    }
    
}

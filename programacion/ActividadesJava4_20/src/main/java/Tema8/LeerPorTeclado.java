/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema8;

import java.util.Scanner;

/**
 *Crea la clase llamada LeerPorTeclado. Esta clase no contendrá atributos e implementará los siguientes 
 * métodos estáticos: 
 *   leerString: Este método pedirá por teclado un String. Este método recibirá como 
 * parámetro un String que será el mensaje donde se pida que se introduzca un String y devolverá dicho 
 * String. 
 *  leerChar: Este método pedirá por teclado un char. Este método recibirá como parámetro un 
 * String que será el mensaje donde se pida que se introduzca un char y devolverá dicho char. 
 *  leerInt: Este método pedirá por teclado un int. Este método recibirá como parámetro un String que será el mensaje 
 * donde se pida que se introduzca un int y devolverá dicho int. 
 *  leerDouble: Este método pedirá por teclado un double. Este método recibirá como parámetro un String donde se pida que se introduzca un double y 
 * devolverá dicho double. 
 *  leerBoolean: Este método pedirá por teclado un boolean. Este método recibirá 
 * como parámetro un String que será el mensaje donde se pida que se introduzca un boolean y devolverá dicho 
 * boolean.
 * 
Desarrolla una aplicación que muestre al usuario el siguiente menú hasta que se pulse la opción salir. Para 
* cada una de las opciones el programa leerá el tipo de dato indicado y lo mostrará por pantalla:
-------------
Menú
-------------
1. Leer una cadena de texto.
2. Leer un carácter.
3. Leer un entero.
4. Leer un double.
5. Leer un boolean.
0. Salir
 * @author beapa
 */


public class LeerPorTeclado {
    public static String leerString(String sPeticion){
        System.out.println(sPeticion);
        Scanner escaner = new Scanner(System.in);
        return escaner.nextLine();
    }
    public static char leerChar(String cPeticion){
        System.out.println(cPeticion);
        Scanner escaner = new Scanner(System.in);
        return escaner.nextLine().charAt(0);
    }
    public static int leerInt(String iPeticion){
        System.out.println(iPeticion);
        Scanner escaner = new Scanner(System.in);
        int respuesta = escaner.nextInt();
        escaner.nextLine();
        return respuesta;
    }
    public static double leerDouble(String dPeticion){
        System.out.println(dPeticion);
        Scanner escaner = new Scanner(System.in);
        double respuesta = escaner.nextDouble();
        escaner.nextLine();
        return respuesta;
    }
    public static boolean leerBoolean(String sPeticion){
        System.out.println(sPeticion);
        Scanner escaner = new Scanner(System.in);
        boolean respuesta = escaner.nextBoolean();
        escaner.nextLine();
        return respuesta;
    }
    
    
    public static void main(String[] Args){
        int iCoso = 0;
        do{
            iCoso = LeerPorTeclado.leerInt( """
                          -------------
                          Menú
                          -------------
                          1. Leer una cadena de texto.
                          2. Leer un carácter.
                          3. Leer un entero.
                          4. Leer un double.
                          5. Leer un boolean.
                          0. Salir""");
            switch(iCoso){
                case 1: System.out.println(LeerPorTeclado.leerString("Introduzca una frase"));
                    break;
                case 2: System.out.println(LeerPorTeclado.leerChar("Introduzca un char"));
                    break;
                case 3: System.out.println(LeerPorTeclado.leerInt("Introduzca un entero"));
                    break;
                case 4: System.out.println(LeerPorTeclado.leerDouble("Introduzca un double"));
                    break;
                case 5: System.out.println(LeerPorTeclado.leerBoolean("Introduzca un boolean"));
                    break;
                case 0: System.out.println("Ha seleccionado salir.");
                    break;
            }
        }while (iCoso !=0);
    }
}

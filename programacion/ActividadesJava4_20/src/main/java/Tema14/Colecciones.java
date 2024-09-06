/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema14;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *Crea un programa que pida al usuario x palabras. Una vez leídas esas palabras deberás insertarlas en las siguientes colecciones:
 ArrayList.
 TreeSet.
 HashMap.
Muestra el contenido de las colecciones, ¿se muestra siempre de la misma forma?
Para
 * @author beapa
 */
public class Colecciones {
    public static void main(String[] Args){
        Scanner escaner = new Scanner(System.in);
        ArrayList<String> palabrasArray = new ArrayList<>();
        TreeSet<String> palabrasTree = new TreeSet<>();//no permite duplicados y los ordena(
        HashMap<Integer,String> palabrasHash = new HashMap<>();
        
        for(int i=0;i<3;i++){
            System.out.println("Digite una palabra");
            String palabra=escaner.next();
            palabrasArray.add(palabra);
            palabrasTree.add(palabra);
            palabrasHash.put(i,palabra);
        }
        
        System.out.println(palabrasArray);
        System.out.println(palabrasTree);
        System.out.println(palabrasHash);
    }
}

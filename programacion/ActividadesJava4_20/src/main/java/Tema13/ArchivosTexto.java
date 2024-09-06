/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema13;

import java.io.IOException;
import java.nio.file.*;

import java.util.Scanner;

/**
 *Desarrolla una aplicación que pida la ruta de 2 ficheros por teclado. 
 * El programa leerá el contenido del primer fichero y lo escribirá en el segundo al revés.
 * @author beapa
 */
public class ArchivosTexto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Solicitando ambas rutas
        Scanner escaner = new Scanner(System.in);
        System.out.println("Digite la ruta del archivo para leer.");
        String ruta1 = escaner.nextLine();
        System.out.println("Digite la ruta del archivo para escribir.");
        String ruta2 = escaner.nextLine();
        
        //entrada y cierre ficheros
        try{
          //obtener el texto del fichero 1
          String contenido = new String(Files.readAllBytes(Paths.get(ruta1)));
          //invertir el contenido
          String inverso = new StringBuilder(contenido).reverse().toString();
          //Escribirlo en el segundo fichero
          Files.write(Paths.get(ruta2), inverso.getBytes());
            System.out.println("Todo ok");
        }catch (IOException e){
            System.out.println("Se ha producido un error al leer o escribir");
            e.printStackTrace();
        }
    }
    
}

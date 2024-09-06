/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema13;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

/**
*Realiza un programa en el que se pida al usuario las notas de 3 asignaturas de primero 
* y las guarde en un fichero binario (serializándolas). Posteriormente leerá las notas del 
* fichero y calculará la nota media del curso. Las notas estarán almacenadas en tres datos del tipo double.

* En la clase principal crea los siguientes métodos:
* Deberás crear un método serializarNotas que reciba como parámetro la ruta del fichero para la serialización 
* y un objeto de tipo Notas con las notas a serializar. Este método no devolverá nada.
* Deberás crear un método obtenerNotaMedia que reciba como parámetro la ruta del fichero donde están las notas 
* serializadas y devuelva la media de las notas.
 * @author beapa
 */
public class Principal {
    /*MÉTODO SERIALIZACIÓN
    *@param la ruta del fichero para la serialización 
    *@param un objeto de tipo Notas con las notas a serializar
    */
    public void serializarNotas(Notas notas){
        try{
            // Serializar el objeto en un archivo .dat
            FileOutputStream fileOut = new FileOutputStream("ficheroSerializacion.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(notas);
            out.close();
            fileOut.close();
            System.out.println("El objeto se ha serializado en ficheroSerializacion.dat");
        }catch(IOException e){
            System.out.println("Se ha producido un error al serializar");
            e.printStackTrace();
        }
    }
    
    
    /*@param la ruta del fichero donde están las notas serializadas 
    @return la media de las notas.*/
    public double obtenerNotaMedia() throws ClassNotFoundException{
        double notaMedia = 0;
        try{
            // Deserializar el objeto desde el archivo .dat
            FileInputStream fileIn = new FileInputStream("ficheroSerializacion.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Notas notas = (Notas) in.readObject();
            in.close();
            fileIn.close();
            
            notaMedia = (notas.getNota(0) + notas.getNota(1)+ notas.getNota(2))/3;
        } catch (IOException e) {
            System.out.println("Se ha producido un error al leer las notas");
            e.printStackTrace();
        }
        return notaMedia;
            
    }
    public static void main(String[] Args){
        Scanner scanner = new Scanner(System.in);

//Solicitar notas:
        System.out.println("Introduce la nota de Programación:");
        double notaProg = scanner.nextDouble();

        System.out.println("Introduce la nota de Lenguajes de Marcas:");
        double notaLeng = scanner.nextDouble();

        System.out.println("Introduce la nota de Bases de Datos:");
        double notaBases = scanner.nextDouble();
//Crear objeto notas
        Notas notas = new Notas(notaProg,notaLeng,notaBases);
//Serializar notas
        System.out.println("Introduce la ruta");
        String ruta = scanner.next();
        Principal principal = new Principal();
        principal.serializarNotas(notas);
    try {
            // Calcular y mostrar la nota media
            double media = principal.obtenerNotaMedia();
            System.out.println("La nota media es: " + media);
        } catch (ClassNotFoundException e) {
            System.out.println("Se ha producido un error: no se encontró la clase.");
            e.printStackTrace();}
    
    }
}

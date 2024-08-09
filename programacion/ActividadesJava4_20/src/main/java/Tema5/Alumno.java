/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema5;

/**
 *Implementa una clase Alumno que represente a los alumnos de una asignatura. De cada alumno interesa conocer 
 * su DNI, su edad y su nota de cada trimestre.
Crea las variables de la clase del tipo que creas más conveniente.
Para terminar, crea dos objetos de la clase Alumno.
 * @author beapa
 */
public class Alumno {
    //ATRIBUTOS
    private String dni;
    private int edad,nota;
    
    //MÉTODOS (CONSTRUCTOR, GETTER, SETTER, TOSTRING)
    public Alumno (String dni,int edad, int calificacion){
        this.dni = dni;
        this.edad = edad;
        this.nota = calificacion;
    }
    public int getEdad(){
        return edad;
    }
    public int getNota(){
        return nota;
    }
    public String getDni(){
        return dni;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public void setNota(int calificacion){
        this.nota = calificacion;
    }
    public void setDni(String dni){
        this.dni = dni;
    }
    
    @Override
    public String toString(){
        return "El DNI es "+dni+", la edad es "+edad+" y la nota trimestral es "+nota;
    }
            
    //MAIN
    public static void main (String[] Args){
        Alumno alumno1 = new Alumno("12345678A", 16, 7);
        System.out.println(alumno1.toString());
    }
}

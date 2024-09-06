/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema13;

import java.util.ArrayList;
import java.io.Serializable;

/**
* Crea una clase Notas que tenga como atributos únicamente un ArrayList con las notas, 
* donde tendremos en cuenta, que cada nota según su posición será de una asignatura, es decir:
*              Asignatura            Posición en ArrayList 
*          Programación                        0
*          Lenguaje de Marcas                  1 
*          Bases de Datos                      2
* La clase Notas como mínimo debería tener los siguientes métodos:
*  Constructor por defecto.  Constructor con parámetros.  Un método getNota() al que se pasaremos como parámetro 
* una posición y nos devolverá la nota que hay en dicha posición.  El método toString(). 
* La información deberá mostrarse de la siguiente forma:
Nota de Programación: <nota correspondiente>
Nota de Lenguajes de Marcas: <nota correspondiente>
Nota de Bases de Datos: <nota correspondiente>

 * @author beapa
 */
public class Notas implements Serializable{
    private ArrayList<Double> asignaturas = new ArrayList<>();

    public Notas() {
    }
    public Notas(double notaProg, double notaLeng, double notaBases) {
        this.asignaturas.add(notaProg);
        this.asignaturas.add(notaLeng);
        this.asignaturas.add(notaBases);
    }
    //obtine la nota de la posicion que se le pasa por parámetro
    public double getNota(int posicion){
        double nota= this.asignaturas.get(posicion);
        return nota;
    }
    @Override
    public String toString(){
        String informacion = "Nota de Programación: "+this.asignaturas.get(0)+"\n" +
                             "Nota de Lenguajes de Marcas: "+this.asignaturas.get(1)+"\n" +
                             "Nota de Bases de Datos: "+this.asignaturas.get(2);
        return informacion;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10;

/**
*Se desea realizar una aplicación que gestione una empresa de alquiler de vehículos.
* En esta empresa se trabaja con distintos tipos de vehículos, de carga (furgonetas y camiones) 
* y de transporte (coches y autobuses). Habrá que implementar una aplicación que utilizando 
* la herencia permita realizar pedidos de vehículos:

* Desarrollar una clase abstracta Vehiculo. En esta clase aparecerán los atributos y métodos comunes a todos los vehículos:
 La matrícula del vehículo y la duración del alquiler en días.
 Los constructores por defecto y con parámetros del vehículo.
 Los métodos get y set de todos los atributos.
 Un método abstracto importeAlquiler que no reciba nada y devuelva un double con el importe 
* del alquiler. Este dependerá del tipo de vehículo que finalmente sea.
 Un método abstracto recibo que muestre por pantalla toda la información del alquiler del vehículo, el formato del recibo depende de si es un vehículo de transporte o de carga.


 * @author beapa
 */
public abstract class Vehiculo { //y MAIN
  //ATRIBUTOS
    private String matricula = "";
    private int diasAlquiler= 0;
  //MÉTODOS
    //C.por defecto

    public Vehiculo() {
    }
    //C. por parámetros
    public Vehiculo(String matric, int diasAlq){
        this.matricula = matric;
        this.diasAlquiler = diasAlq;
    }
    //getters y setters
    public String getMatricula() {
        return matricula;
    }

    public int getDiasAlquiler() {
        return diasAlquiler;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setDiasAlquiler(int diasAlquiler) {
        this.diasAlquiler = diasAlquiler;
    }
    
    //importeAlquiler: abstracto
    public abstract double importeAlquiler();
    public abstract int getPlazas();
    public abstract void mostrarAlquiler();  
    
    
}

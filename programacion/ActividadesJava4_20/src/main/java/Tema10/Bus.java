/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10;

/**
 *Desarrollar una clase Bus que heredará de Vehiculo y que contendrá los siguientes métodos:
 Las plazas del bus
 Los constructores por defecto y con parámetros del vehículo.
 Sobrecargar el método importeAlquiler para que calcule el alquiler correspondiente a un coche
* con la siguiente fórmula: El alquiler de un bus es igual que la de un coche más un plus de 2€ 
* por plaza.
 Sobrecargar el método mostrarInformacion para que muestre la información de un coche de la 
* siguiente forma:
* 
--------------------
* BUS
--------------------
Matricula: <matrícula>
Duración: <duración alquiler>
Plazas: <plazas>
Importe del alquiler: <alquiler> €

 * @author beapa
 */
public class Bus extends Vehiculo{
  //ATRIBUTOS
    private int plazas;
  //MÉTODOS 
    public Bus(){     
    }
    public Bus(String matric, int diasAlq, int asientos){
        super(matric,diasAlq);
        this.plazas = asientos;
    }

    @Override
    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    
    @Override
    public double importeAlquiler(){
        double importeTotal =  this.getDiasAlquiler()*2*this.getPlazas()+50;
        return importeTotal;
    }
    @Override
    public void mostrarAlquiler(){
        System.out.println("--------------------\n" +
                           "BUS\n" +
                           "--------------------\n" +
                           "Matricula: "+this.getMatricula()+"\n" +
                           "Duración: "+this.getDiasAlquiler()+"\n" +
                           "Plazas: "+this.getPlazas()+"\n" +
                           "Importe del alquiler: "+this.importeAlquiler()+"€");
    }
}

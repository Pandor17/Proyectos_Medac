/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10;

/**
 *
 * @author beapa
 * Desarrollar una clase Coche que heredará de Vehiculo y que contendrá los siguientes métodos:
 Las plazas del coche
 Los constructores por defecto y con parámetros del vehículo.
 Sobrecargar el método importeAlquiler para que calcule el alquiler correspondiente 
* a un coche con la siguiente fórmula: 50€ por día más 1,5€ por plaza y día.
 Sobrecargar el método mostrarInformacion para que muestre la información de un coche 
* de la siguiente forma:
--------------------
COCHE
--------------------
Matricula: <matrícula>
Duración: <duración alquiler>
Plazas: <plazas>
Importe del alquiler: <alquiler> €

 */
public class Coche extends Vehiculo{
  //ATRIBUTOS
    private int plazas;
  //MÉTODOS 
    public Coche(){     
    }
    public Coche(String matric, int diasAlq, int asientos){
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
        double importeTotal =  this.getDiasAlquiler()*1.5*this.getPlazas()+50;
        return importeTotal;
    }
    @Override
    public void mostrarAlquiler(){
        System.out.println("--------------------\n" +
                           "COCHE\n" +
                           "--------------------\n" +
                           "Matricula: "+this.getMatricula()+"\n" +
                           "Duración: "+this.getDiasAlquiler()+"\n" +
                           "Plazas: "+this.getPlazas()+"\n" +
                           "Importe del alquiler: "+this.importeAlquiler()+"€");
    }
}

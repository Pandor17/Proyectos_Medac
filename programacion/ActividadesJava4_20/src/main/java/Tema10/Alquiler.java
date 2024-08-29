/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema10;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
Finalmente hay que implementar la clase Alquiler que es la encargada de gestionar los pedidos 
* de alquileres. Un alquiler puede contener más de un vehículo (de cualquier tipo) y con 
* duraciones diferentes. Esta clase deberá tener:
 Un ArrayList pedido donde almacenar los datos de todos los vehículos que se alquilen.
 Un constructor por parámetros que reciba el número de vehículos a alquilar y que pida 
* por teclado la información necesaria para cada uno de estos vehículos 
* (matricula, duración, plazas, tara). Para referirse al tipo de vehículo se indicará 
* mediante C,B (coche o bus).
 Un método getImporteTotal que devuelva el total del alquiler de un pedido.
 Un método getImporteVehiculo que reciba la posición de un vehículo del alquiler y devuelva 
* el importe del alquiler del vehículo indicado.
 Además, la clase Alquiler debe implementar la interfaz Facturacion para mostrar los datos 
* de un alquiler. El formato para mostrar un alquiler es el siguiente:
Total alquiler: <total alquiler> €
----------------------------------
DETALLE
---------------------------------
VEHÍCULO 1
Información del vehículo
VEHÍCULO 2
Información del vehículo
VEHÍCULO 3
Información del vehículo
….
VEHÍCULO n
Información del vehículo
 * @author beapa
 */
public class Alquiler implements Facturacion{
  //ATRIBUTOS
    private ArrayList<Vehiculo> pedido = new ArrayList<>();
  //MÉTODOS

    public ArrayList<Vehiculo> getPedido() {
        return pedido;
    }
    
    public Alquiler(int nVehiculos){
        String[] options = {"Coche", "Autobús"};
        for(int i=0;i<nVehiculos;i++){
            String mensaje1="DATOS VEHÍCULO "+(i+1);
            int tipoVehiculo = JOptionPane.showOptionDialog(null, "Indique si necestia un coche o un autobús", 
                                    mensaje1,                       //nº de vehiculo a 
                                    JOptionPane.DEFAULT_OPTION,  // Tipo de opción (estándar)
                                    JOptionPane.QUESTION_MESSAGE,// Tipo de mensaje
                                    null,                        // Ícono personalizado (null para ícono por defecto)
                                    options,                     // Opciones disponibles
                                    options[0]);                  // Opción por defecto
            if(tipoVehiculo==0){
                String matric = JOptionPane.showInputDialog(null, 
                                "Introduzca la matrícula del coche que desea alquilar",
                                mensaje1, JOptionPane.QUESTION_MESSAGE);
                int diasAlq = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Introduzca los días que desea alquilar el coche",
                                mensaje1, JOptionPane.QUESTION_MESSAGE));
                int asientos = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Introduzca el número de plazas que tiene el coche",
                                mensaje1, JOptionPane.QUESTION_MESSAGE));
                this.getPedido().add(new Coche(matric,diasAlq,asientos));
            }
            else if(tipoVehiculo==1){
                String matric = JOptionPane.showInputDialog(null, 
                                "Introduzca la matrícula del autobús que desea alquilar",
                                mensaje1, JOptionPane.QUESTION_MESSAGE);
                int diasAlq = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Introduzca los días que desea alquilar el autobús",
                                mensaje1, JOptionPane.QUESTION_MESSAGE));
                int asientos = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                "Introduzca el número de plazas que tiene el autobús",
                                mensaje1, JOptionPane.QUESTION_MESSAGE));
                this.getPedido().add(new Bus(matric,diasAlq,asientos));
            }
            else{
                System.out.println("No se ha seleccionado ninguan opción para el vehículo"+i);
            }
        }
    }
    public double getImporteTotal(){
        double importeTotal=0;
        for (int i=0;i<this.getPedido().size();i++){
            importeTotal += this.getPedido().get(i).importeAlquiler();
        }
        return importeTotal;
    }
    @Override
    public void mostrarFactura(){
        System.out.println("Total alquiler: "+this.getImporteTotal()+" €\n" +
                           "    ----------------------------------\n" +
                           "    DETALLE\n" +
                           "    ---------------------------------\n");
        for(int i=0;i<this.pedido.size();i++){
            System.out.println("    VEHÍCULO "+i+":\n"+
                               "    /t Matrícula: "+this.getPedido().get(i).getMatricula()+":\n"+
                               "    /t Plazas: "+this.getPedido().get(i).getPlazas()+":\n"+
                               "    /t Dias: "+this.getPedido().get(i).getDiasAlquiler()+":\n"+
                               "    /t Importe individual: "+this.getPedido().get(i).importeAlquiler()+":\n");
        }
    }
    /*
         Un método getImporteVehiculo que reciba la posición de un vehículo del alquiler y devuelva 
    * el importe del alquiler del vehículo indicado.
    */
}

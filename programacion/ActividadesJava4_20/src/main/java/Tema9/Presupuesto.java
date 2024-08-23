/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema9;

/**
 *Parte A
Desarrolla una clase Presupuesto. Esta clase tendrá 3 atributos:
 Cliente, que será una cadena de texto con el nombre del cliente al que se realiza el presupuesto.
 Descripción, que será una cadena de texto con la descripción de los artículos que se han elegido para
el presupuesto.
 Importe, que contendrá el precio de los artículos presupuestados.
Además, se implementarán los siguientes métodos:
 Un constructor por defecto, y un constructor que reciba el valor de todos los atributos como
argumento.
 Los métodos get y set de todos los atributos.
 * @author beapa
 */
public class Presupuesto {
  //ATRIBUTOS
    private String cliente, descripcion;
    private double importe;
  //MÉTODOS
    //C. por defecto
    public Presupuesto(){
        this.cliente="";
        this.descripcion="";
        this.importe=0;
    }
    //C. por parámetros
    public Presupuesto(String nombreCliente, String descripcion_producto, double precio){
        this.cliente = nombreCliente;
        this.descripcion = descripcion_producto;
        this.importe=precio;
    }
    //GETTERS Y SETTERS

    public String getCliente() {
        return cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "Presupuesto{" + "cliente=" + cliente + ", descripcion=" + descripcion + ", importe=" + importe + '}';
    }
    
    //IMPRIMIR
    public final void imprimirPresupuesto(){
            System.out.println(this.toString());
    }
    
    
}

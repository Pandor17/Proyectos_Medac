/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema9;

/**
 *Parte B
Desarrolla la clase Factura que herede de la clase Presupuesto. Esta clase tendrá un nuevo atributo, que se
llamará fabricante, el cual será el nombre del fabricante cuyo valor no se podrá modificar. Este valdrá
“Productos ACME S.L.”. La clase tendrá:
 Un constructor por defecto y otro que reciba todos los atributos salvo el fabricante como parámetro.
 Un método obtenerPrecioOficial. Este método calcula el precio oficial de una factura, que es el
importe del presupuesto más el IVA.
 Sobreescribe el método imprimirPresupuesto para que muestre la información de la factura de la
siguiente forma (¿Se puede sobrescribir?, ¿por qué?, en caso negativo soluciónalo).
 * @author beapa
 */
public class Factura extends Presupuesto{
    private final String fabricante = "Productos ACME S.L";
  //METODOS
    public Factura(){
        super();
    }
    public Factura(String nombreCliente, String descripcion_producto, double precio){
        super(nombreCliente, descripcion_producto, precio);
    }
    public void obtenerPecioOficial(){
        System.out.println("El precio final es: "+super.getImporte()*1.21);
    }
    /*@Override
    public void imprimirPresupuesto(){
        NO SE PUEDE POR QUE ES FINAL, HABRÍA QUE CAMBIAR EL MÉTODO PADRE
    }*/
}

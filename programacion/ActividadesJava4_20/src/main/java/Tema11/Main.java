/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema11;

/**
 *Añade una excepción a los métodos retirar e ingresar dinero para no poder retirar 
 * o ingresar una cantidad negativa y que al utilizar las siguientes instrucciones
 * se muestre dicha excepción:
 miCuenta.retirarDinero(-2300).
 miCuenta.ingresarDinero(-1965).
 * @author beapa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CuentaCorriente miCuenta = new CuentaCorriente("nombre1", "1234", 1000, 2);
        try{
           miCuenta.retirarDinero(-2300); 
        }catch (CantidadNegativaException e){
           System.out.println(e.getMessage());
        }
        
        try{
           miCuenta.ingresarDinero(-1965); 
        }catch (CantidadNegativaException e){
           System.out.println(e.getMessage());
        }
       

    }
    
}

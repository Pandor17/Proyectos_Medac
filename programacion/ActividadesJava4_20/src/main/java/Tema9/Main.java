/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema9;

import javax.swing.JOptionPane;

/**
 *Parte C
Crea un programa que cree una factura y un presupuesto pidiendo sus datos por teclado. Una vez creados
los mostrará por pantalla utilizando el método imprimirPresupuesto.
Para el desarrollo de esta actividad debéis de crear un proyecto en NetBeans para realizar el ejercicio.
Recuerda que la herencia se hace mediante extends, y solo se podrá heredar de una clase.
 * @author beapa
 */
public class Main {
    public static void main(String[] Args){
        String cliente = JOptionPane.showInputDialog("Digite el cliente de la factura 1");
        String descripcion = JOptionPane.showInputDialog("Digite la descripción de la factura 1");
        double importe = Double.parseDouble(JOptionPane.showInputDialog("Digite el importe de la factura 1"));
        Presupuesto presupuesto = new Presupuesto(cliente,descripcion,importe);
        cliente = JOptionPane.showInputDialog("Digite el cliente de la factura 2");
        descripcion = JOptionPane.showInputDialog("Digite la descripción de la factura 2");
        importe = Double.parseDouble(JOptionPane.showInputDialog("Digite el importe de la factura 2"));
        Factura factura = new Factura(cliente,descripcion,importe);
        presupuesto.imprimirPresupuesto();
        factura.imprimirPresupuesto();
        factura.obtenerPecioOficial();
    }
    
}

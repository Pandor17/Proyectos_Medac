/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Tema10;

import javax.swing.JOptionPane;

/**
 *
 * @author beapa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int numeroPedido = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de coches que desea alquilar"));
        Alquiler alquiler1 = new Alquiler(numeroPedido);
        alquiler1.mostrarFactura();
    }
    
}

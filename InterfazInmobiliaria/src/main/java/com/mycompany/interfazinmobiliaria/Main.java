/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interfazinmobiliaria;

import javax.swing.SwingUtilities;

/**
 *
 * @author beapa
 */
public class Main {
    
    
    public static void main(String[] args) {
        //DBManager.crearTabla();
        //DBManager.insertarDatos();
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
        
    }
}

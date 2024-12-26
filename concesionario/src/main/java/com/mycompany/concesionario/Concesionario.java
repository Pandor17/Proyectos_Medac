/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.concesionario;

import java.util.concurrent.Semaphore;

/**
 *
 * @author beapa
 */
public class Concesionario {

    private static final int numeroVehiculos = 4; 
    private static final int numeroClientes = 9;  

    public static void main(String[] args) {
        Semaphore semaforo = new Semaphore(numeroVehiculos);

        // Crear vehículos
        Coche[] coches = new Coche[numeroVehiculos];
        for (int i = 0; i < numeroVehiculos; i++) {
            coches[i] = new Coche(i + 1); 
        }

        // Crear y ejecutar hilos para los 9 clientes
        for (int i = 1; i <= numeroClientes; i++) {
            String clientName = "Cliente-" + i;
            Cliente cliente = new Cliente(clientName, semaforo, coches);
            new Thread(cliente).start();
        }
    }
}

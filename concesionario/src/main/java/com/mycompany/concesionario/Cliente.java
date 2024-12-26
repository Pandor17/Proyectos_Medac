/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.concesionario;

import java.util.concurrent.Semaphore;

/**
 *
 * @author beapa
 */
public class Cliente implements Runnable{
    private final String nombre;
    private final Semaphore semaforo;
    private final Coche[] coches;
    
    public Cliente(String nombre, Semaphore semaforo, Coche[] coches) {
        this.nombre = nombre;
        this.semaforo = semaforo;
        this.coches = coches;
    }
    
    @Override
    public void run() {
        try {
            semaforo.acquire(); 

            Coche coche = asignarCoche();
            if (coche != null) {
                System.out.println(nombre + " probando vehículo " + coche.getId() + "...");
                // tiempo de prueba aleatorio
                Thread.sleep((long) (Math.random() * 5000 + 2000)); 
                System.out.println(nombre + " terminó de probar el vehículo " + coche.getId() + ".");
                liberarCoche(coche);
            }

        } catch (InterruptedException e) {
            System.err.println(nombre + " fue interrumpido.");
        } finally {
            semaforo.release(); 
        }
    }

    private synchronized Coche asignarCoche() {
        for (int i = 0; i < coches.length; i++) {
            if (coches[i] != null) {
                Coche cocheAsignado = coches[i];
                // saco el coche del array de coches disponibles
                coches[i] = null;  
                return cocheAsignado;
            }
        }
        return null; 
    }
    
    private synchronized void liberarCoche(Coche coche) {
        for (int i = 0; i < coches.length; i++) {
            if (coches[i] == null) {
                // vuelvo a incluir el coche en el array de coches disponibles
                coches[i] = coche; 
                break;
            }
        }
    }

}

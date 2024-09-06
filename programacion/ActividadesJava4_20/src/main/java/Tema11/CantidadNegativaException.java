/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package Tema11;

/**
 *
 * @author beapa
 */
public class CantidadNegativaException extends Exception{

    /**
     * Creates a new instance of <code>CantidadNegativa</code> without detail
     * message.
     */
    public CantidadNegativaException() {
        System.out.println("No es posible retirar una cantidad negativa");
    }

    /**
     * Constructs an instance of <code>CantidadNegativa</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CantidadNegativaException(String msg) {
        super(msg);
    }
}

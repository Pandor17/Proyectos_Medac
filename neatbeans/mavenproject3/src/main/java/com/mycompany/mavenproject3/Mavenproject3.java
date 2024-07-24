/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tema2Act2;

/**
 *
 * @author beapa
 */
public class Tema2Act2 {

    public static void main(String[] args) {
        int variable1 = 5;
        int variable2 = 10;
        
        CambioVariables.cambioVariables(variable1, variable2); // al pasarlo por int, se pasa por valor y no por referencia,
        //habría que hacer una clase container y entonces si se cambiaría 
        System.out.println(variable1);
        System.out.println(variable2);
        
        //ahora, si se hace directamente en el main, si se cambia el valor
        int c = variable1;
        variable1 = variable2;
        variable2 = c;
        System.out.println(variable1);
        System.out.println(variable2);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema6;

import java.util.Scanner;

/**
 *Implementa una clase Carta que represente a una carta de una baraja de póker.
De una carta interesa conocer su número y su palo (almacenado como una única letra).
El número de la carta se deberá representar con un int y el palo con un String de una sola letra.
La clase Carta deberá tener los siguientes métodos:
 Un constructor por defecto y un constructor con parámetros, todos los de la clase.
 Los métodos get que permitan acceder a los atributos.
 Los métodos set que permitan modificar los atributos.
 Un método mostrarCarta() que muestre por pantalla de qué carta se trata con el siguiente formato
es el <numero> de <palo> donde el número y el palo corresponden a los atributos de la carta con las siguientes particularidades:
o El palo del número deberá mostrarse al completo, es decir, se deberá sustituir la letra del palo por el palo en cuestión (Corazones, Picas, Rombos o Tréboles).
o Si el número de la carta está entre 2 y 10 se mostrará normalmente. Para el resto de los números 1, 11, 12, 13 se cambiará respectivamente por As, Jack, Reina, Rey.
 Un método compararCarta que reciba una carta como argumento y la compare con la actual, devolviendo cuál de ellas es la ganadora. Para esto se comprobará en primer 
* lugar el número de las cartas, si son distintos ganará la mayor y si son iguales se compararán los palos. El orden de victoria de los palos es Trébol, Rombos, Picas, Corazones. Este método devolverá un int que tendrá tres posibles valores:
o 1 Si gana la carta del this.
o 0 Si las dos cartas son iguales.
o -1 Si gana la carta que llega como parámetro.
Realiza un método main en el que se creen 2 cartas, la primera con el constructor por defecto y se inicialice 
* con los métodos set. La segunda se creará con el constructor con parámetros, habiendo leído por teclado todos 
* los datos antes. Después se mostrarán ambas cartas con el método mostrarCarta() y se compararán con el método 
* ‘comparar’. Después de esto se modificará la segunda con los métodos set y se volverán a mostrar y comparar.
 * @author beapa
 * PARA DOXIGEN:
     * @class: nombre clase
     * @brief: breve descripción
     * @param: parámetros
     * @return: devuelve..
 */
public class Carta {
    //ATRIBUTOS
    int numero;
    String palo; //guardarlo como una sola letra
    
    
    //MÉTODOS: constructor por defecto y por parámetros, get y set, mostrar y comparar
    public Carta(){}//C.por defecto
    public Carta(int numero, String palo){//C.por parámetros
        this.setNumero(numero);
        this.setPalo(palo); 
    }
    public int getNumero (){
        return numero;
    }
    public String getPalo(){
        return palo;
    }
    public void setNumero(int numero){
        if (numero>0 && numero<14){
            this.numero = numero;
        }
        else{
            System.out.println("Error: número de la carta fuera de rango");
        }
    }
    public void setPalo(String palo){
        if(palo.equals("c")||palo.equals("d")||palo.equals("p")||palo.equals("t")){
            this.palo = palo;
        }
        else{
            System.out.println("Error: el String introducido no corresponde a nunguno válido");
        }
    }
    public void mostrarCarta(){
        System.out.print("Es ");
        switch(numero){
            case 1 -> System.out.print("el As");
            case 11 -> System.out.print("la Jack");
            case 12 -> System.out.print("la Reina");
            case 13 -> System.out.print("el Rey");
            default -> System.out.print("el "+numero);
        }
        System.out.print(" de "+palo);
        switch (palo){
            case "c" -> System.out.println("orazones");
            case "p" -> System.out.println("icas");
            case "t" -> System.out.println("réboles");
            case "d" -> System.out.println("iamantes");
        }    

    }
    public int compararCarta(Carta carta2){
        int resultado;
        if(this.numero>carta2.getNumero()){
            resultado = 1;
        }
        else if(this.numero<carta2.getNumero()){
            resultado=-1;
        }
        else{//en caso de que sean iguales El orden de victoria es Trébol, Rombos, Picas, Corazones. 
            if(this.palo.compareTo(carta2.getPalo())<1){
                resultado =-1;
            }
            else if(this.palo.compareTo(carta2.getPalo())>1){
                resultado = 1;
            }
            else {
                resultado = 0;
            }
        }
        return resultado;
    }
    /*
        Este método devolverá un int que tendrá tres posibles valores:
        1 Si gana la carta del this.
        0 Si las dos cartas son iguales.
        -1 Si gana la carta que llega como parámetro.
    */ 

    //MAIN
    public static void main(String[] Args){
        //crear las dos cartas
        Scanner escaner = new Scanner(System.in);
        int numero;
        String palo;
        System.out.println("Digite el número de la primera carta");
        numero = escaner.nextInt();
        escaner.nextLine();
        System.out.println("Digite la inicial del palo de la primera carta");
        palo = escaner.nextLine();
        Carta carta1 = new Carta(); //C. por defecto
        carta1.setNumero(numero);
        carta1.setPalo(palo);
        System.out.println("Digite el número de la segunda carta");
        numero = escaner.nextInt();
        escaner.nextLine();
        System.out.println("Digite la inicial del palo de la segunda carta");
        palo = escaner.nextLine();
        Carta carta2 = new Carta(numero,palo);//C por parámetros
        
        //MOSTRAR CARTAS
        carta1.mostrarCarta();
        carta2.mostrarCarta();
        
        //COMPARAR
        int resultado = carta1.compararCarta(carta2);
        if(resultado < 0)
            System.out.println("La segunda carta es mayor");
        else if (resultado >0)
            System.out.println("La primera carta es mayor");
        else
            System.out.println("Ambas cartas son iguales");    
        
        
        /*
Después de esto se modificará la segunda con los métodos set y se volverán a mostrar y comparar.
 * @author beapa*/
       
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema5;

/**
 *Implementa una clase ‘Motocicleta’ que represente a una motocicleta.
De una motocicleta interesa conocer los caballos de potencia (cv), la velocidad punta en km/h, 
* las tres letras de su matrícula, y el número de la matrícula.
Crea las variables de la clase del tipo que creas más conveniente.
Para terminar, crea dos objetos de la clase Motocicleta.
 * @author beapa
 */
public class Motocicleta {
    //ATRIBUTOS
    private int caballos;
    private float velocidadPunta;
    private String letrasMatricula;
    private int numerosMatricula;
    
    //MÉTODOS (todo getters, setters y toString)
    public Motocicleta(int cab, float velocidadP, String letrasM, int numerosM){
        this.caballos = cab;
        this.velocidadPunta = velocidadP;
        this.letrasMatricula = letrasM;
        this.numerosMatricula = numerosM;        
    }
    public static void main(String[] args) {
        Motocicleta moto1 = new Motocicleta(100,150,"ABC",1234);
        Motocicleta moto2 = new Motocicleta(150,200,"DEF",5678);
    }
}



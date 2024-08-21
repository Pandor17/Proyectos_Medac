/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema8;

import javax.swing.JOptionPane;

/**
 *Crea la clase Complejo la cual tendrá 2 atributos los cuales pueden tener decimales:
 real: parte real del número complejo.
 Imag: parte imaginaria del número complejo.
A continuación crea los siguientes métodos dentro de la clase:
 Constructor por defecto.
 Constructor con parámetros pasando todos los atributos.
 Getters y Setters de los parámetros.
 Método toString() mediante la concatenación de sus atributos mostrando un número real como 3 +
4i, siento 3 la parte real y 4 la imaginaria
 Un método Suma con un parámetro que será el complejo que se sumará al objeto que llame a este
método. Para sumar complejos se sumará la parte real con la parte real y la parte imaginaria con la
parte imaginaria.
 Sabiendo cómo se suman los números complejos añadir un método estático que permita sumar 2
números entre sí.
Crea un programa que pida un complejo por teclado e inicializa el otro como quieras y los sume usando
ambos métodos. ¿Cuál es la diferencia?
* 
 * @author beapa
 */
public class Complejo {
//ATRIBUTOS
    //parte real e imaginaria
    private int real ,imag;
//MÉTODOS: 
    //C. Por defecto
    public Complejo (){
    }
    //c. por parámetros
    public Complejo(int real, int imaginario){
        this.real = real;
        this.imag = imaginario;
    }
    //getters
    public int getReal() {
        return real;
    }

    public int getImag() {
        return imag;
    }
    //setters
    public void setReal(int real) {
        this.real = real;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }
    //toString: ej numero1 es 3-4i
    @Override
    public String toString(){
        return "El número es: "+this.getReal()+" + "+this.getImag()+"i.";
    }
    //suma con 1 parámetro
    public String suma(Complejo complejo){
        int r=this.real+complejo.getReal();
        int i=this.imag+complejo.getImag();
        return "El resultado de la suma es: "+r+" + "+i+"i.";
    }
    //suma estática(2 parámetros)
    public static String suma(Complejo complejo1, Complejo complejo2){
        int real=complejo1.getReal()+complejo2.getReal();
        int imagi=complejo1.getImag()+complejo2.getImag();
        return "El resultado de la suma estática es: "+real+" + "+imagi+"i.";
    }
//MAIN
    public static void main(String[] Args){
        //pedir complejo por teclado
        Complejo complejo1 = new Complejo();
        complejo1.setReal(Integer.parseInt(JOptionPane.showInputDialog("Digite la parte real del primer número: ")));
        complejo1.setImag(Integer.parseInt(JOptionPane.showInputDialog("Digite la parte imaginaria del primer número: ")));
    //inicialización de otro
        Complejo complejo2 = new Complejo(-3, 5);
    //suma no estática
        System.out.println(complejo1.suma(complejo2));
    
    //suma estática
        System.out.println(Complejo.suma(complejo1, complejo2));
    
    }

    
}

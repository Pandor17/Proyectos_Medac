package triangulo;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int iN_triangulos;
        double base,lado;
        iN_triangulos = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el número de triángulos a analizar"));
        Isosceles isosceles[] = new Isosceles[iN_triangulos];
        Scanner entrada = new Scanner(System.in);
        for(int i=0 ; i<iN_triangulos ; i++){
            JOptionPane.showMessageDialog(null,"Datos del triángulo "+(i+1));
            System.out.println("Base");
            base = entrada.nextDouble();
            System.out.println("Lado");
            lado = entrada.nextDouble();
            isosceles[i] = new Isosceles(base,lado);
        }
        for(int i=0 ; i<iN_triangulos ; i++){
            System.out.println("El perimetro del triángulo nº "+(i+1)+" es: "+isosceles[i].obtener_perimetro());
        }
        System.out.println("El triángulo de mayor área es el "+ (Isosceles.elegir_mayor_perimetro(isosceles)+1));
    }
}

import javax.swing.*;

public class Ejercicio2_horas {
    public static void  main(String[] args){
        int iHoras,iDias,iSemanas;
        iHoras = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de horas"));
        iDias = iHoras/24;
        iHoras %=24;
        iSemanas = iDias/7;
        iDias %=7;
        System.out.println("El número de semanas es: "+iSemanas);
        System.out.println("\nEl número de días es: "+iDias);
        System.out.println("\nEl número de horas es: "+iHoras);
    }
}

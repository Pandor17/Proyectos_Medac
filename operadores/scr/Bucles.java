
import javax.swing.*;
import java.util.Scanner;

public class Bucles {
    public static void main(String[] args){
        int iEdad;
        String sRespuesta;
        Scanner escanear = new Scanner(System.in);
        System.out.println("Introduzca su edad");
        iEdad = escanear.nextInt();
        if(iEdad>=18){
            System.out.println("Eres mayor de edad");
        }
        else{
            System.out.println("Eres menor de edad");
            JOptionPane.showMessageDialog(null,"bla bla");
        }
        sRespuesta = JOptionPane.showInputDialog("Te ha gustado la pregunta?");

    }
}

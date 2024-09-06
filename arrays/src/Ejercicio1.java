import javax.swing.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        int [] numero = new int[5];
        for(int i=0;i<5;i++){
            numero[i]=Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1 número"));
        }
        for(int i=4;i>=0;i--){
            System.out.print(numero[i]+" ");
        }
    }
}
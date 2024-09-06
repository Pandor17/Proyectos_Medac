import java.util.Scanner;

public class Orden_Alternativo {
    public static void main(String[] args){
        int[] numero = new int[10];
        Scanner escaner = new Scanner(System.in);
        for(int i=0;i<10;i++){
            numero[i] = escaner.nextInt();
        }
        for(int i=0;i<10/2;i++){
            System.out.print(numero[i]+" "+numero[numero.length-i-1]+" ");

        }
    }
}

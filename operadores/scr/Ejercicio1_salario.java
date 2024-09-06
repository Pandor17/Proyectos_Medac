import java.util.Scanner;

public class Ejercicio1_salario {
    public static void main(String[] args){
        int iHoras;
        float fSalarioporhoras,fSalariosemanal;
        Scanner escaner = new Scanner(System.in);
        System.out.println("Ingrese el número de horas que trabaja a la semana: \n");
        iHoras = escaner.nextInt();
        //System.out.println("Ingrese el suldo que cobra cada hora");
        fSalarioporhoras = escaner.nextFloat();
        fSalariosemanal = iHoras*fSalarioporhoras;
        System.out.println("Los euritos a cobrar el viernes serán: "+fSalariosemanal);
    }
}

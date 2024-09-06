package atletas1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Digite el número de participantes en la carrera.");
        Scanner entrada = new Scanner(System.in);
        int i_participantes = entrada.nextInt();
        Atleta atleta [] = new Atleta[i_participantes];
        int iN_atleta=0;
        String sNombre="a";
        float fTiempo= 0f;
        for(int i = 0 ; i < i_participantes ; i++){
            System.out.println("Atleta "+(i+1)+":");
            System.out.println("Digite su nº de atleta");
            iN_atleta = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Digite su nombre");
            sNombre = entrada.nextLine();
            System.out.println("Introduzca su tiempo en segundos");
            fTiempo = entrada.nextFloat();
            atleta[i] = new Atleta(iN_atleta,sNombre,fTiempo);
        }
        Atleta atleta1 = new Atleta(iN_atleta,sNombre,fTiempo);
        Atleta.mostrar_resultados(atleta);
    }
}

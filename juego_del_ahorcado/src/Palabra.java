import javax.swing.*;
import java.util.Scanner;
public class Palabra {
    //atributos
    private String letras;
    private String rayitas="";
    private int iErrores=0;
    boolean encontrado = false;
    Scanner escaner= new Scanner(System.in);



    //métodos
    public void setter(){
        System.out.println("Introduzca la palabra secreta:");
        letras = escaner.nextLine();
    }

    public void crear_rayitas(){
        for(int i = 0 ; i<letras.length() ; i++){
            rayitas += "_";
        }
    }

    public void iniciar_juego(){
        while (iErrores<5 && !rayitas.equals(letras)){
            encontrado = false;
            String letrasnuevas = JOptionPane.showInputDialog(null, "Pruebe una letra.");
            if(letrasnuevas != null && letrasnuevas.length()==1){
                char letra = letrasnuevas.charAt(0);
                for (int i = 0 ; i < letras.length() ; i++){
                    if (letras.charAt(i) == letra){
//                        if(i == 0){
//                            rayitas = letra + rayitas.substring(1);
//                        }
//                        else if (i< letras.length()-1){
                            rayitas = rayitas.substring(0,i)+letra+rayitas.substring(i+1);
//                        }
//                        else{
//                            rayitas = rayitas.substring(0,letras.length()-1)+letra;
//                        }
                        encontrado = true;

                    }
                }
                if(encontrado){
                    JOptionPane.showMessageDialog(null,"Correcto, la letra "+letra+" se encuentra en la palabra secreta.\n"+rayitas.replace("_"," _ "));

                }
                else{
                    iErrores ++;
                    JOptionPane.showMessageDialog(null,"Inorrecto, la letra "+letra+" no se encuentra en la palabra secreta.\nLe quedan "+(5-iErrores)+" intentos");

                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Letra no válida. Inténtelo de nuevo.");
            }

        }
        if(iErrores==5){
            JOptionPane.showMessageDialog(null,"Ha agotado el número de intentos. La palabra secreta era \""+letras+"\".");
        }
        else{
            JOptionPane.showMessageDialog(null, "FELICIDADES, la palabra secreta es\""+letras+"\".\nLe ha costado "+iErrores+" errores.");
        }
    }


}

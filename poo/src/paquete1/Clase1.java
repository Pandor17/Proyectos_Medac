package paquete1;

import java.util.Scanner;

//Construir un programa que permita mover un objeto dentro de un tablero
//actualice su posición dentro del mismo
//movimientos posibles: ARRIBA ABAJO IZQUIERDA DERECHA
//Mostrar dirección elegida y nueva coordenada de posición
public class Clase1 {
    public static void  main(String[] args){
        System.out.println("Para comenzar a jugar elija el movimiento del objeto para cambiar su posición:\n" +
                "1.Subir\n" +
                "2.Bajar\n" +
                "3.Derecha\n" +
                "4.Izquierda\n" +
                "5.Salir\n");
        Scanner entrada = new Scanner(System.in);
        int movimiento = entrada.nextInt();
        Objeto objeto1 = new Objeto();
        do{
          switch (movimiento){
              case 1:
                  objeto1.subir();
                  break;
              case 2:
                  objeto1.bajar();
                  break;
              case 3:
                  objeto1.derecha();
                  break;
              case 4:
                  objeto1.izquierda();
                  break;

          }
          System.out.println("Elija otro movimiento (pulse 5 para salir)");
          movimiento = entrada.nextInt();
        }while(movimiento!=5);
        System.out.println("Ha salido correctamente.");
    }
}



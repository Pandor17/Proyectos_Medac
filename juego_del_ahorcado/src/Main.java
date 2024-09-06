import java.util.Scanner;

public class Main {
    Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        Palabra palabra1 = new Palabra();
        palabra1.setter();
        palabra1.crear_rayitas();
        palabra1.iniciar_juego();
    }
}

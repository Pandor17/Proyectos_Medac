package paquete1;

public class Objeto {
    //atributos
    private int pos_ejex = 0;
    private int pos_ejey= 0;

    //metodos
    public void subir(){
        System.out.println("La dirección elegida es subir.");
        pos_ejey++;
        System.out.println("La posición actual es ("+pos_ejex+","+pos_ejey+").");
    }
    public void bajar(){
        System.out.println("La dirección elegida es subir.");
        pos_ejey--;
        System.out.println("La posición actual es ("+pos_ejex+","+pos_ejey+").");
    }
    public void derecha(){
        System.out.println("La dirección elegida es subir.");
        pos_ejex++;
        System.out.println("La posición actual es ("+pos_ejex+","+pos_ejey+").");
    }
    public void izquierda(){
        System.out.println("La dirección elegida es subir.");
        pos_ejex--;
        System.out.println("La posición actual es ("+pos_ejex+","+pos_ejey+").");
    }
}

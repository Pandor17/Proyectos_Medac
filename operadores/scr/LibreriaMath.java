

public class LibreriaMath {
    public static void main(String[] args){
        double dRaiz = Math.sqrt(24);
        double dPotencia = Math.pow(dRaiz,2);
        dPotencia = Math.round(dPotencia);
        int iAleatorio = Math.round((float) Math.random()*100);
        int iPrueba = (int)4.8;

        System.out.println("El resultado de la raiz es: "+dRaiz);
        System.out.println("El resultado de la potencia es: "+dPotencia);
        System.out.println("el aleatorio es: "+iAleatorio);
        System.out.println(iPrueba);
    }
}

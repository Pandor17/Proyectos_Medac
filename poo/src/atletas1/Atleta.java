package atletas1;

public class Atleta {
    //Atributos
    private int iN_identificador;
    private String sNombre;
    private float fTiempo;


    //Métodos
    public Atleta (int iIdentificacion, String sNombre, float fTiempo){
        iN_identificador = iIdentificacion;
        this.sNombre = sNombre;
        this.fTiempo = fTiempo;
    }

    public float getfTiempo() {
        return fTiempo;
    }

    public static int mejor_atleta(Atleta atleta[]){
       int posicion_rapido = 0;
       float fTiempo_rapido = atleta[0].getfTiempo();
       for(int i = 1 ; i < atleta.length ; i++){
           if (atleta[i].getfTiempo() < fTiempo_rapido){
               fTiempo_rapido = atleta[i].getfTiempo();
               posicion_rapido = i;
           }
       }
       return posicion_rapido;
    }

    public static void mostrar_resultados(Atleta[] atleta) {
        int i=mejor_atleta(atleta);
        System.out.println("El atleta más rápido es "+atleta[i].sNombre+", nª"+atleta[i].iN_identificador+" con un tiempo de "+atleta[i].fTiempo+" segundos.");
    }
}

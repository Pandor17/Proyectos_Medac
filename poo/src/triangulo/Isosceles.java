package triangulo;
//Atributos: base y lado
//metodos: creación, cálculo perímetro, elección del de mayor perimetro

public class Isosceles {
    private double dBase;
    private double dLado;

    //Methods
    public Isosceles (double dBase, double dLado){
        this.dBase = dBase;
        this.dLado = dLado;
    }

    public double obtener_perimetro(){
        double dPerimetro = dBase + dLado*2;
        return dPerimetro;
    }

    public static int elegir_mayor_perimetro(Isosceles isosceles[]){
        int indice=0;
        double dPerimetro = isosceles[0].obtener_perimetro();
        for(int i = 0 ; i < isosceles.length ; i++){
            if(dPerimetro<isosceles[i].obtener_perimetro()){
                dPerimetro = isosceles[i].obtener_perimetro();
                indice = i;
            }
        }
        return indice;
    }
}

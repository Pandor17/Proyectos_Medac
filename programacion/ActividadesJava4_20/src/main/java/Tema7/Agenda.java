/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema7;

/**
 *Crea la clase llamada Agenda. Esta clase contendrá 5 atributos, de lunes a viernes de tipo String 
 * donde se introducirán las tareas diarias
 Crea los 3 constructores, por defecto incializando a 0, por parámetros y por copia.
 Crea getters y setters
 Crea el método mostrarDia que acepte un entero del 1 al 5 y muestre por pantalla la información de ese día.
Ahora crea un programa, inicializa una Agenda como tu quieras.
Crea dos agendas más iguales a la primera Agenda, para hacer la segunda de estas utiliza el constructor por copia.
Muestra todos los días de las Agendas para ver que son iguales.
* 
* Actividad 2: crea una librería con este proyecto y prueba a usarlo en otro. La prueba se ha realizado en el tema 3
* PruebaVariosMain.java
 * @author beapa
 */
//@class agenda
public class Agenda {
//ATRIBUTOS
    private String lunes ="";
    private String martes ="";
    private String miercoles ="";
    private String jueves ="";
    private String viernes ="";
    
//MÉTODOS
    //C.POR DEFECTO
    public Agenda(){}
    //C.POR PARÁMETROS
    public Agenda(String lunes, String martes, String miercoles, String jueves, String viernes){
        this.lunes=lunes;
        this.martes=martes;
        this.miercoles=miercoles;
        this.jueves=jueves;
        this.viernes=viernes;
    }
    //C.COPIA
    public Agenda(Agenda agenda){
        this.lunes=agenda.getLunes();
        this.martes=agenda.getMartes();
        this.miercoles=agenda.getMiercoles();
        this.jueves=agenda.getJueves();
        this.viernes=agenda.getViernes();
    }

    //GETTERS
    public String getLunes() {
        return this.lunes;
    }

    public String getMartes() {
        return this.martes;
    }

    public String getMiercoles() {
        return this.miercoles;
    }

    public String getJueves() {
        return this.jueves;
    }

    public String getViernes() {
        return this.viernes;
    }
    //SETTERS

    public void setLunes(String lunes) {
        this.lunes = lunes;
    }

    public void setMartes(String martes) {
        this.martes = martes;
    }

    public void setMiercoles(String miercoles) {
        this.miercoles = miercoles;
    }

    public void setJueves(String jueves) {
        this.jueves = jueves;
    }

    public void setViernes(String viernes) {
        this.viernes = viernes;
    }

   //MOSTRAR DÍA
    public void mostrarDia(int dia){
        switch (dia){
            case 1 -> System.out.println(this.lunes);
            case 2 -> System.out.println(this.martes); 
            case 3 -> System.out.println(this.miercoles);
            case 4 -> System.out.println(this.jueves);
            case 5 -> System.out.println(this.viernes);
        }
    }
    
//MAIN
    public static void main (String[] Args){
        Agenda agenda1 = new Agenda ("Actividad1", "actividad2", "actVidad3", "actVidad_4", "ACTIVIDAD5");
        Agenda agenda2 = new Agenda (agenda1);
        //mostrar las dos agendas creadas para comprobar que son iguales
        System.out.println("Actividades de la primera agenda: ");
        for (int i = 1; i < 6; i++) {
            agenda1.mostrarDia(i);
        }
        System.out.println("Actividades de la segunda agenda: ");
        for (int i = 1; i < 6; i++) {
            agenda1.mostrarDia(i);
        }
    }
}

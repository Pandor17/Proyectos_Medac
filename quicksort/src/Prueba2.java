public class Prueba2 {
    public static void main(String[] args) {
        interface InterfaceA {
            int metodoComun();
        }

        interface InterfaceB {
            int metodoComun();
        }

        class MiClase implements InterfaceA, InterfaceB {
            @Override
            public int metodoComun() {
                // Implementación específica para la clase MiClase
                return 0;
            }
        }
        //prueba de uso del método
        MiClase clase = new MiClase();
        clase.metodoComun();
    }
}

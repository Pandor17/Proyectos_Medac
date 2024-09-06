package ventana;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
public class Ventana extends JFrame {
    public Ventana(){ //Constructor de Ventana
        this.setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Hola");
        //setLocation(100,100);
        setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.black);
        iniciar_componentes();
    }

    private void iniciar_componentes(){ //metodo para el panel interior
        JPanel panel = new JPanel();
        //panel.setBackground(Color.BLACK);
        panel.setLayout(null);//desactivo diseño por defecto para poder modificarlo
        this.getContentPane().add(panel);

        //ETIQUETA TEXTO
        JLabel etiqueta = new JLabel("Jugar",SwingConstants.CENTER);
        etiqueta.setBounds(200,10,100,40);
        //etiqueta.setSize(80,30);
        //etiqueta.setOpaque(true);
        etiqueta.setBackground(Color.BLACK);
        etiqueta.setForeground(Color.black);
        etiqueta.setFont(new Font("cooper black",Font.BOLD,30));
        panel.add(etiqueta);

        //ETIQUETA IMAGEN
        ImageIcon imagen = new ImageIcon("D:\\Repositorio\\poo\\src\\imagenes\\vampire-survivors-sequel.jpg");
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(200,50,750,420);
        etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta2.getWidth(),etiqueta2.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(etiqueta2);

        //BOTON 1 TEXTO
        JButton boton1 = new JButton("Jugar");
        boton1.setBounds(100,100,100,40);
        boton1.setEnabled(true);//encender o apagar el boton
        boton1.setMnemonic('a'); //establecer otra forma de clicear: alt+a
        boton1.setForeground(Color.BLACK);
        boton1.setFont(new Font("arial",3,12));
        panel.add(boton1);

        //BOTON 2 IMAGEN
        ImageIcon imagen2 = new ImageIcon("D:\\Repositorio\\poo\\src\\imagenes\\botonapagar.png");
        JButton boton2 = new JButton();
        boton2.setBounds(100,150,100,100);
        //boton2.setBackground(Color.gray);
        boton2.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(boton2.getHeight(),boton2.getWidth(), Image.SCALE_SMOOTH)));
        panel.add(boton2);

        //BOTONES RADIO

        //CAJA DE TEXTO
        JTextField caja_Texto = new JTextField();
        caja_Texto.setBounds(50,50,100,30);
        panel.add(caja_Texto);

        JTextArea cuadro_Texto = new JTextArea();
        cuadro_Texto.setBounds(50,250,100,100);
        panel.add(cuadro_Texto);

        //LISTAS DESPLEGABLES
        String [] paises = {"Perú","Colombia"};
        JComboBox lista1 = new JComboBox<>(paises);
        lista1.setBounds(20,10,100,30);
        panel.add(lista1);

    }

    public static void main(String[] args) { //main, solo se crea una y la hace visible
        Ventana ventana1 =new Ventana();
        ventana1.setVisible(true);
    }
}


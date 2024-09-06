package ventana;

import javax.swing.*;
import java.awt.*;

public class Ventana2 extends JFrame {
    JButton boton;
    public Ventana2(){
        this.setSize(500,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Hola");
        //setLocation(100,100);
        setLocationRelativeTo(null);
        Container contentpane = getContentPane();
        contentpane.setLayout(null);
        this.setVisible(true);
        boton = new JButton(new ImageIcon("imagenes/vampire-survivors-sequel.jpg"));
        boton.setBounds(0,0,100,50);
        contentpane.add(boton);
    }

    public static void main(String[] args) {
        Ventana2 v = new Ventana2();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema15;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
/**
 *mnnnn
 * @author beapa
 */
public class CatalogoFlores extends javax.swing.JFrame{
    private String[] nFlores = {"Rosa","Girasol","Tulipan","Lirio","Orquidea"};
    private Image[] iFlores = new Image[5];
    private JButton jbInicio, jbFinal, jbAlante, jbAtras; 
    private JLabel lFlores, lNombre;
    private int indice;

//CONSTRUCTOR
    public CatalogoFlores(){
        setTitle("Flores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        //nombres
        JPanel pNombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        lNombre = new JLabel(this.nFlores[0]);
        lNombre.setFont(new Font("Verdana",Font.BOLD,20));
        pNombre.add(lNombre);
        add(pNombre,BorderLayout.NORTH);
        
        //imágenes
        JPanel pImagenes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.iFlores[0]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\rosa.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[1]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\girasol.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[2]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\tulipan.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[3]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\lirio.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[4]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\orquidea.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        
        lFlores = new JLabel ( new ImageIcon(iFlores[0]));
        pImagenes.add(lFlores);
        add(pImagenes,BorderLayout.CENTER);
        
        //BOTONES
        JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        Image imagenInicio = new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\inicio.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        jbInicio= new JButton(new ImageIcon(imagenInicio));
        pBotones.add(jbInicio);
        jbInicio.setEnabled(false);
                
        Image imagenAtras = new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\atras.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        jbAtras = new JButton(new ImageIcon(imagenAtras));
        pBotones.add(jbAtras);
        jbAtras.setEnabled(false);
        
        Image imageAlante = new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\alante.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        jbAlante = new JButton(new ImageIcon(imageAlante));
        pBotones.add(jbAlante);
                
        Image imagenFinal = new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\final.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        jbFinal = new JButton(new ImageIcon(imagenFinal));
        pBotones.add(jbFinal);
                
        add(pBotones,BorderLayout.SOUTH);
        
        
        //mecanica botones
        
        this.jbInicio.addActionListener((ActionEvent e) -> {
            this.irInicio();
        });
        
        this.jbFinal.addActionListener((ActionEvent e) -> {
            this.irFinal();
        });
        
        this.jbAlante.addActionListener((ActionEvent e) -> {
            this.irAlante();
        });
        
        this.jbAtras.addActionListener((ActionEvent e) -> {
            this.irAtras();
        });
        
        
    }
    
    public void irInicio(){
        this.lNombre.setText(this.nFlores[0]);
        this.lFlores.setIcon(new ImageIcon(iFlores[0]));
        this.indice= 0;
        comprobarBotones();
    }
    public void irFinal(){
        this.lNombre.setText(this.nFlores[4]);
        lFlores.setIcon(new ImageIcon(iFlores[4]));
        this.indice = 3;
        comprobarBotones();
    }
    public void irAlante(){
        this.indice++;
        this.lNombre.setText(this.nFlores[indice]);
        lFlores.setIcon(new ImageIcon(iFlores[indice]));
        comprobarBotones();
        
    }
    public void irAtras() {
        this.indice--;
        this.lNombre.setText(this.nFlores[indice]);
        lFlores.setIcon(new ImageIcon(iFlores[indice]));
        comprobarBotones();
    }
    
    public void comprobarBotones(){
        if (indice==4){
            jbAlante.setEnabled(false);
            jbFinal.setEnabled(false);
        }
        else{
            jbAlante.setEnabled(true);
            jbFinal.setEnabled(true);
        }
        
        if (indice==0){
            jbAtras.setEnabled(false);
            jbInicio.setEnabled(false);
        }
        else{
            jbAtras.setEnabled(true);
            jbInicio.setEnabled(true);
        }
    }
    
    
    
    
//MAIN
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new CatalogoFlores().setVisible(true);
            }
        });
    }
}

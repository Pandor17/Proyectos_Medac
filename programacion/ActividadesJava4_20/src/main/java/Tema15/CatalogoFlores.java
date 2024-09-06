/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema15;
import javax.swing.*;
import java.awt.*;
/**
 *mnnnn
 * @author beapa
 */
public class CatalogoFlores extends javax.swing.JFrame{
    private String[] nFlores = {"Rosa","Girasol","Tulipan","Lirio","Orquidea"};
    private Image[] iFlores = new Image[5];
    private JButton jbInicio, jbFinal, jbAlante, jbAtras;
    
    
    


//CONSTRUCTOR
    public CatalogoFlores(){
        setTitle("Flores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        //nombres
        JPanel pNombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel lNombre = new JLabel(this.nFlores[0]);
        lNombre.setFont(new Font("Verdana",Font.BOLD,20));
        pNombre.add(lNombre);
        add(pNombre,BorderLayout.NORTH);
        
        //imágenes
        JPanel pImagenes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.iFlores[0]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\rosa.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[1]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\girasol.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[2]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\tulipan.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[3]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\lirio.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        this.iFlores[4]= new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\orquidea.jpg").getImage().getScaledInstance(400, 350, Image.SCALE_SMOOTH);
        
        JLabel lFlores = new JLabel ( new ImageIcon(iFlores[0]));
        pImagenes.add(lFlores);
        add(pImagenes,BorderLayout.CENTER);
        
        
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

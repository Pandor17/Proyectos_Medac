/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema16;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author beapa
 */



public class Quiniela extends JFrame{
    private DefaultListModel<String> dlmPartidos, dlmResultados;
    private JList<String> jListPartidos, jListResultados;

//Ventana principal
    public Quiniela(){
        setTitle("Quiniela");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,300);
        setLocationRelativeTo(null);        
        setLayout(new BorderLayout());
        
    //PANEL SUPERIOR
        JPanel jpSuperior = new JPanel(new BorderLayout());
        jpSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
        jpSuperior.setBackground(Color.GRAY);
        add(jpSuperior,BorderLayout.NORTH);
        
        JLabel jlTitulo = new JLabel("Quiniela");
        jlTitulo.setFont(new Font("verdana",Font.BOLD,30));
        jlTitulo.setForeground(Color.red);
        JPanel jpTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpSuperior.add(jpTitulo,BorderLayout.NORTH);
        jpTitulo.add(jlTitulo);
        
        JLabel jlPartidos = new JLabel("  Partidos");
        JLabel jlResultados = new JLabel("Resultados  ");
        jpSuperior.add(jlPartidos,BorderLayout.WEST);
        jpSuperior.add(jlResultados,BorderLayout.EAST);
        
        
    //PANEL CENTRAL
        JPanel jpCentral = new JPanel(new BorderLayout());
        jpCentral.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(jpCentral,BorderLayout.CENTER);
    
        //PANEL PARTIDOS
        JPanel jpPartidos = new JPanel();
        jpPartidos.setBackground(Color.GRAY);
        jpPartidos.setPreferredSize(new Dimension(125,200));
        jpCentral.add(jpPartidos,BorderLayout.WEST);
        
        //PANEL RESULTADOS
        JPanel jpResultados = new JPanel();
        jpResultados.setPreferredSize(new Dimension(125,200));
        jpResultados.setBackground(Color.GRAY);
        jpCentral.add(jpResultados,BorderLayout.EAST);
        
        //PANEL BOTONES
        JPanel jpBotones = new JPanel();
        jpBotones.setLayout(new BoxLayout(jpBotones, BoxLayout.Y_AXIS));
        jpBotones.setBackground(Color.WHITE);
        jpCentral.add(jpBotones);
        
    //BOTONES
        JButton jbNew = new JButton("Nuevo");
        jbNew.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBotones.add(Box.createVerticalGlue());
        jpBotones.add(jbNew);
              
        JButton jbDelete = new JButton("Eliminar");
        jbDelete.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBotones.add(Box.createRigidArea(new Dimension(0, 20))); 
        jpBotones.add(jbDelete);
        
        JButton jbSend = new JButton("Realizar Quiniela");
        jbSend.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        jpBotones.add(jbSend);
        
        JButton jbReset = new JButton("Resetear");
        jbReset.setAlignmentX(Component.CENTER_ALIGNMENT);
        jpBotones.add(Box.createRigidArea(new Dimension(0, 20)));
        jpBotones.add(jbReset);
        jpBotones.add(Box.createVerticalGlue());
        
//private DefaultListModel<String> dlmPartidos, dlmResultados;
//    private JList<String> jListPartidos, jListResultados;    
    //LISTA PARTIDOS
        dlmPartidos = new DefaultListModel<>();
        jListPartidos = new JList<>(dlmPartidos);
        jpPartidos.add(jListPartidos);
        
    
    //LISTA RESULTADOS
        dlmResultados = new DefaultListModel<>();
        jListResultados = new JList<>(dlmResultados);
        jpResultados.add(jListResultados);
    
        
    //FUNCIONALIDAD BOTONES
        jbNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                AddPartido anadirPartido = new AddPartido(Quiniela.this);               
                
            }
        });
        
        jbDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dlmPartidos.remove(jListPartidos.getSelectedIndex());
            }
        });
        
        jbReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dlmPartidos.clear();
                dlmResultados.clear();
            }
        });
        
        jbSend.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dlmResultados.clear();
                for(int i=0;i<dlmPartidos.getSize();i++){
                    String sPartido = dlmPartidos.get(i);
                    String[] sPosibleResultado = {"1","2","X"};
                    int aleatorio = (int)(Math.random()*3);
                    String sResultado = sPartido + " " +sPosibleResultado[aleatorio];
                    dlmResultados.addElement(sResultado);
                }
            }
        });
    }
    
    public void anadirPartido(String partido){
        dlmPartidos.addElement(partido);
    }

//MAIN    
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Quiniela().setVisible(true);
    
            }
        });
    }
}

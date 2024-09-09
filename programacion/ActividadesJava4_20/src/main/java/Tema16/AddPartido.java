/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema16;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author beapa
 */
public class AddPartido extends JFrame{
    Quiniela quiniela;
    
//CONSTRUCTOR
    public AddPartido(Quiniela quiniela){
        this.quiniela = quiniela;
        setTitle("Agregar nuevo partido");
        setSize(440,80);
        setLocationRelativeTo(quiniela);
        setVisible(true);
        JPanel jpPartido = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel jlPartido = new JLabel("Partido: ");
        jpPartido.add(jlPartido);
        
        JTextField jtfPartido = new JTextField();
        jtfPartido.setColumns(30);
        jpPartido.add(jtfPartido);
        
        JButton jbAceptar = new JButton("Aceptar");
        jpPartido.add(jbAceptar);
        
        add(jpPartido);
        
        jbAceptar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                quiniela.anadirPartido(jtfPartido.getText());
                dispose();
            }
        });
        
        
    }
    
}

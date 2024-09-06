/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema15;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author beapa
 * Realiza un programa con interfaz gráfica que nos permita registrar personas en una tabla.
De las personas se ha de conocer su nombre, sus apellidos, su dirección, su teléfono, su email y sus estudios,
que podrán ser Primaria, ESO, Bachillerato, FP medio, FP superior o Universidad, los cuales, podremos elegir
mediante un JComboBox.
Tendremos un botón para insertar y otro para limpiar los datos y en ambos obligatoriamente tiene que
aparecer texto y una imagen representativa de su acción.
Cuando pulsemos el botón de insertar los datos de una persona sus datos se tendrán que agregar en la
tabla (JTable) al final.
La pantalla deberá quedar obligatoriamente como la que se muestra a continuación.
 */
public class InterfazRegistroPersonas extends JFrame{
    private JTextField tNombre, tApellidos, tDireccion, tTelefono, tEmail;    
    private JComboBox<String> cbEstudios;
    private JTable tablaPersonas;
    private DefaultTableModel modeloTabla;
    private JButton btInsertar, btLimpiar;

    public InterfazRegistroPersonas(){
        setTitle("Registro de Personas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        //Panel del formulario
        JPanel panelFormulario = new JPanel(new GridLayout(7,2,10,10));
        add(panelFormulario,BorderLayout.NORTH);//
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            
        panelFormulario.add(new JLabel("Nombre: "));
        this.tNombre = new JTextField();
        panelFormulario.add(this.tNombre);
        
        panelFormulario.add(new JLabel("Apellidos: "));
        this.tApellidos=new JTextField();
        panelFormulario.add(this.tApellidos);
        
        panelFormulario.add(new JLabel("Dirección: "));
        this.tDireccion = new JTextField();
        panelFormulario.add(this.tDireccion);
        
        panelFormulario.add(new JLabel("Teléfono: "));
        this.tTelefono = new JTextField();
        panelFormulario.add(tTelefono);
        
        panelFormulario.add(new JLabel("Email: "));
        this.tEmail = new JTextField();
        panelFormulario.add(tEmail);

        panelFormulario.add(new JLabel("Estudios: "));
        String[] estudios = {"Primaria", "ESO", "Bachillerato", "FP medio", "FP superior", "Universidad"};
        this.cbEstudios = new JComboBox<>(estudios);
        panelFormulario.add(this.cbEstudios);
        
        //BOTONES
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(panelBotones,BorderLayout.CENTER);
        btInsertar = new JButton("Insertar");
        btLimpiar = new JButton("Limpiar");
            
        ImageIcon icono = new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\borrar.png");
        ImageIcon icono2 = new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\283234.png");
        Image imagenRedimensionada = icono.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);  // Ajusta el tamaño a 50x50
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        Image imagen2Redimensionada = icono2.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);  
        ImageIcon icono2Redimensionado = new ImageIcon(imagen2Redimensionada);
        this.btLimpiar.setIcon(iconoRedimensionado);
        this.btInsertar.setIcon(icono2Redimensionado);
               
        panelBotones.add(btInsertar);
        panelBotones.add(btLimpiar);

        //TABLA
        JPanel panelTabla = new JPanel();
        
        
        String[] columnas = {"Nombre","Apellidos","Dirección","Teléfono","Email","Estudios"};
        this.modeloTabla = new DefaultTableModel(columnas,0);
        this.tablaPersonas= new JTable(this.modeloTabla);
        
        JScrollPane scrollTable = new JScrollPane(tablaPersonas);
        scrollTable.setPreferredSize(new Dimension(750, 250)); 

        add(scrollTable,BorderLayout.SOUTH);
        
        //FUNCIONALIDAD DE LOS BOTONES
        this.btInsertar.addActionListener((ActionEvent e) -> {
            insertarPersona();
        });
        this.btLimpiar.addActionListener((ActionEvent e) -> {
            limpiarFormulario();
        });
    }
    
    private void insertarPersona(){
        modeloTabla.addRow(new Object[]{this.tNombre.getText(),
                                        this.tApellidos.getText(),
                                        this.tDireccion.getText(),
                                        this.tTelefono.getText(),
                                        this.tEmail.getText(),
                                        this.cbEstudios.getSelectedItem()});
        limpiarFormulario();
    }
    private void limpiarFormulario(){
        tNombre.setText("");
        tApellidos.setText("");
        tDireccion.setText("");
        tTelefono.setText("");
        tEmail.setText("");
        cbEstudios.setSelectedIndex(0); 
    }
    
    
}

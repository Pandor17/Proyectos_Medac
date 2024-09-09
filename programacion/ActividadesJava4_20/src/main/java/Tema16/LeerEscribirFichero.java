/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema16;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeerEscribirFichero extends JFrame {

    // Componentes principales
    private JTextArea textArea, textAreaLeer;
    private JTextField tfNameFicheroLeer, tfNameFicheroEscribir;
    private JRadioButton rbTextoPlanoEscribir, rbBinarioEscribir, rbTextoPlanoLeer,rbBinarioLeer;
    private JButton botonAccion,btElegirFichero;
    private JFileChooser fileChooser;
    private boolean modoEscritura = true; // Para controlar si estamos en modo "escribir" o "leer"
    JLabel lRutaSeleccionada;
    int seleccion;
    File archivoSeleccionado;

    public LeerEscribirFichero() {
    //General pantalla
        setTitle("Leer y escribir en fichero");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

    // Panel para escribir
        JPanel panelEscribir = new JPanel(new BorderLayout());
        tfNameFicheroEscribir= new JTextField(20);
        textArea = new JTextArea(10, 30);
        JPanel panelFicheroEscribir = new JPanel (new FlowLayout(FlowLayout.LEFT));
        panelFicheroEscribir.add(new JLabel("Nombre del fichero:"));
        panelFicheroEscribir.add(tfNameFicheroEscribir);
        rbTextoPlanoEscribir = new JRadioButton("Texto plano", true);
        rbBinarioEscribir = new JRadioButton("Binario");
        ButtonGroup bgTiposEscribir = new ButtonGroup();
        bgTiposEscribir.add(rbTextoPlanoEscribir);
        bgTiposEscribir.add(rbBinarioEscribir);
        panelFicheroEscribir.add(rbTextoPlanoEscribir);
        panelFicheroEscribir.add(rbBinarioEscribir);
        //añado panel y jscrollpane
        panelEscribir.add(panelFicheroEscribir,BorderLayout.NORTH);
        panelEscribir.add(new JScrollPane(textArea), BorderLayout.CENTER);

    // Panel para leer
        JPanel panelLeer = new JPanel(new BorderLayout());

        JPanel panelFicheroLeer= new JPanel (new FlowLayout(FlowLayout.CENTER));
        panelFicheroLeer.add(new JLabel("Ruta del fichero: "));
        lRutaSeleccionada = new JLabel("Ruta aún no seleccionada... ");
        lRutaSeleccionada.setFont(new Font("Verdana", Font.ITALIC, 10));
        lRutaSeleccionada.setForeground(Color.GRAY);
        lRutaSeleccionada.setPreferredSize(new Dimension(200, 50)); // Preferido también 200x50
        panelFicheroLeer.add(lRutaSeleccionada);
        
        ButtonGroup bgTiposLeer = new ButtonGroup();
        rbTextoPlanoLeer = new JRadioButton("Texto plano", true);
        rbBinarioLeer = new JRadioButton("Binario");
        bgTiposLeer.add(rbTextoPlanoLeer);
        bgTiposLeer.add(rbBinarioLeer);
        panelFicheroLeer.add(rbTextoPlanoLeer);
        panelFicheroLeer.add(rbBinarioLeer);
        
        btElegirFichero = new JButton();
        Image iElegirFichero = new ImageIcon("D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema15\\imagenes\\borrar.png").getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        btElegirFichero.setIcon(new ImageIcon(iElegirFichero));
        panelFicheroLeer.add(btElegirFichero);

        // File chooser con filtros
        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Ficheros de texto plano (.txt)", "txt"));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Ficheros binarios (.dat)", "dat"));
        fileChooser.setAcceptAllFileFilterUsed(true);

        textAreaLeer = new JTextArea(10, 30);
        textAreaLeer.setEditable(false);
        panelLeer.add(panelFicheroLeer,BorderLayout.NORTH);
        panelLeer.add(new JScrollPane(textAreaLeer), BorderLayout.CENTER);
        
    // Pestañas
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Escribir en fichero", panelEscribir);
        tabbedPane.addTab("Leer de fichero", panelLeer);
        
        add(tabbedPane, BorderLayout.CENTER);

    // Panel inferior botón de acción
        JPanel panelInferior = new JPanel();
        botonAccion = new JButton("Escribir");
        panelInferior.add(botonAccion);

        add(panelInferior, BorderLayout.SOUTH);

        

        // Listener para cambiar entre modo escribir y leer
        tabbedPane.addChangeListener(e -> {
            if (tabbedPane.getSelectedIndex() == 0) { // Modo escribir
                botonAccion.setText("Escribir");
                modoEscritura = true;
            } else { // Modo leer
                botonAccion.setText("Leer");
                modoEscritura = false;
            }
        });

        // Listener para el botón "Escribir/Leer"
        botonAccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (modoEscritura) {
                    escribirFichero();
                } else {
                    leerFichero();
                }
            }
        });
        
        btElegirFichero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elegirFichero();
            }
        });
    }

    // Método para escribir en el fichero
    private void escribirFichero() {
        String nombreFichero = tfNameFicheroEscribir.getText();
        if (nombreFichero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar un nombre de fichero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String ruta = "D:\\Repositorio\\actividadesPrimerCurso\\Proyectos Medac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema16\\ficherosLeerEscribir\\";
       
        if (rbTextoPlanoEscribir.isSelected()) {
            // Escritura en fichero de texto
            File archivoTexto = new File(ruta + nombreFichero + ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoTexto))) {
                writer.write(textArea.getText());
                JOptionPane.showMessageDialog(this, "Fichero de texto escrito correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al escribir en el fichero.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rbBinarioEscribir.isSelected()) {
            // Escritura en fichero binario
            File archivoBinario = new File(ruta + nombreFichero + ".dat");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoBinario))) {
                oos.writeObject(textArea.getText());
                JOptionPane.showMessageDialog(this, "Fichero binario escrito correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error al escribir en el fichero binario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void elegirFichero(){
        this.seleccion = fileChooser.showOpenDialog(this);
        if (this.seleccion == JFileChooser.APPROVE_OPTION) {
            this.archivoSeleccionado = fileChooser.getSelectedFile();
            this.lRutaSeleccionada.setText(archivoSeleccionado.getAbsolutePath());
        }
    }
    // Método para leer desde un fichero
    private void leerFichero() {
        if (rbTextoPlanoLeer.isSelected()) {
            // Lectura de fichero de texto
            try {
                String contenido = new String(Files.readAllBytes(Paths.get(archivoSeleccionado.getAbsolutePath())));
                textAreaLeer.setText(contenido);
                JOptionPane.showMessageDialog(this, "Fichero de texto leído correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error al leer el fichero de texto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (rbBinarioLeer.isSelected()) {
            // Lectura de fichero binario
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoSeleccionado))) {
                String contenido = (String) ois.readObject();
                textAreaLeer.setText(contenido);
                JOptionPane.showMessageDialog(this, "Fichero binario leído correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al leer el fichero binario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
            
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LeerEscribirFichero().setVisible(true);
            }
        });
    }
}
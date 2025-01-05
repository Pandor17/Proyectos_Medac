/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazinmobiliaria;

/**
 *
 * @author beapa
 */
import javax.swing.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser; 
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


public class VentanaPrincipal extends JFrame {
    private JTextField dniTextField; // Campo de texto DNI
    private JTable alquileresTable; // Tabla  datos
    private DefaultTableModel tableModel; 
    private JButton buscarButton;
    private JButton generarInformeButton;


    public VentanaPrincipal() {
        setTitle("Gestión de Alquileres");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        buscarButton = new JButton("Buscar");
        generarInformeButton = new JButton("Generar Informe");

        // Panel Norte: Texto y Campo de Entrada
        JPanel nortePanel = new JPanel();
        nortePanel.setLayout(new FlowLayout());
        JLabel dniLabel = new JLabel("Introduce el DNI del cliente a consultar: ");
        dniTextField = new JTextField(20);
        JLabel fechaInicioLabel = new JLabel("Fecha Inicio:");
        JDateChooser fechaInicioChooser = new JDateChooser();
        JLabel fechaFinLabel = new JLabel("Fecha Fin:");
        JDateChooser fechaFinChooser = new JDateChooser();
        fechaInicioChooser.setDateFormatString("yyyy-MM-dd");
        fechaFinChooser.setDateFormatString("yyyy-MM-dd");

        
        nortePanel.add(dniLabel);
        nortePanel.add(dniTextField);
        nortePanel.add(fechaInicioLabel);
        nortePanel.add(fechaInicioChooser);
        nortePanel.add(fechaFinLabel);
        nortePanel.add(fechaFinChooser);
        nortePanel.add(buscarButton);
        add(nortePanel, BorderLayout.NORTH);

        // Panel Central: Tabla
        tableModel = new DefaultTableModel();
        alquileresTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(alquileresTable);
        tableModel.addColumn("ID Alquiler");
        tableModel.addColumn("Número Expediente");
        tableModel.addColumn("Fecha Entrada");
        tableModel.addColumn("Tiempo Estimado");
        tableModel.addColumn("Nombre Cliente");
        tableModel.addColumn("Vivienda Ref.");
        tableModel.addColumn("Ubicación");
        tableModel.addColumn("Precio Mensual");
        add(tableScrollPane, BorderLayout.CENTER);

        // Panel Sur: Botón Generar Informe
        JPanel surPanel = new JPanel();
        surPanel.add(generarInformeButton);
        add(surPanel, BorderLayout.SOUTH);

        // Acción del Botón Buscar
        buscarButton.addActionListener(e -> {
            String dni = dniTextField.getText().trim(); // Obtener el DNI del campo de texto
            java.util.Date fechaInicio = fechaInicioChooser.getDate(); // Fecha de inicio seleccionada
            java.util.Date fechaFin = fechaFinChooser.getDate(); // Fecha de fin seleccionada

            if (dni.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo DNI es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Consulta SQL con parámetros
            String consultaSQL = """
                SELECT 
                    A.id_alquiler, 
                    A.numero_expediente, 
                    A.fecha_entrada, 
                    A.tiempo_estimado,
                    C.nombre, 
                    C.apellido, 
                    C.dni,
                    V.codigo_referencia, 
                    V.ubicacion,
                    V.precio_mensual
                FROM 
                    Alquileres A
                JOIN 
                    Clientes C ON A.id_cliente = C.id_cliente
                JOIN 
                    Viviendas V ON A.id_vivienda = V.id_vivienda
                WHERE 
                    C.dni = ?
                    AND (
                        (? IS NULL AND ? IS NULL) 
                        OR (A.fecha_entrada BETWEEN ? AND ?)
                    )
            """;

            try (var conn = DBManager.conectar();
                PreparedStatement pstmt = conn.prepareStatement(consultaSQL)) {

                // Establecer los valores de los parámetros
                pstmt.setString(1, dni);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                if (fechaInicio != null) {
                    String fechaInicioStr = dateFormat.format(fechaInicio);
                    pstmt.setString(2, fechaInicioStr);
                    pstmt.setString(4, fechaInicioStr);
                } else {
                    pstmt.setNull(2, java.sql.Types.VARCHAR);
                    pstmt.setNull(4, java.sql.Types.VARCHAR);
                }

                if (fechaFin != null) {
                    String fechaFinStr = dateFormat.format(fechaFin);
                    pstmt.setString(3, fechaFinStr);
                    pstmt.setString(5, fechaFinStr);
                } else {
                    pstmt.setNull(3, java.sql.Types.VARCHAR);
                    pstmt.setNull(5, java.sql.Types.VARCHAR);
                }
                System.out.println(pstmt.toString());
                // Ejecutar la consulta y procesar los resultados
                ResultSet rs = pstmt.executeQuery();

                // Limpiar la tabla
                DefaultTableModel modelo = (DefaultTableModel) alquileresTable.getModel();
                modelo.setRowCount(0);

                // Llenar la tabla con los resultados
                while (rs.next()) {
                    modelo.addRow(new Object[]{
                        rs.getInt("id_alquiler"),
                        rs.getString("numero_expediente"),
                        rs.getString("fecha_entrada"),
                        rs.getInt("tiempo_estimado"),
                        rs.getString("nombre") + " " + rs.getString("apellido"),
                        rs.getString("codigo_referencia"),
                        rs.getString("ubicacion"),
                        rs.getString("precio_mensual")
                    });
                }

                // Verificar si hay resultados
                if (modelo.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(this, "No se encontraron resultados para los criterios proporcionados.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
                }
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        //Accion Botón Generar Informe
        generarInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GenerarPDF.generar(alquileresTable, "informe_alquileres.pdf"); 
                
            }
        });
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.interfazinmobiliaria;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author beapa
 */
public class VentanaPrincipalTest {

    private VentanaPrincipal ventanaPrincipal;

    public VentanaPrincipalTest() {
    }

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        ventanaPrincipal = new VentanaPrincipal();
    }

    @AfterEach
    public void tearDown() throws Exception {
        ventanaPrincipal.dispose(); // Liberar los recursos de la ventana
    }

    @Test
    public void testVentanaInicializadaCorrectamente() {
        // Verificar que los componentes principales no sean nulos
        assertNotNull(ventanaPrincipal);
        JTextField dniTextField = (JTextField) TestUtils.getFieldValue(ventanaPrincipal, "dniTextField");
        assertNotNull(dniTextField, "El campo de texto DNI debe estar inicializado.");

        JTable alquileresTable = (JTable) TestUtils.getFieldValue(ventanaPrincipal, "alquileresTable");
        assertNotNull(alquileresTable, "La tabla de alquileres debe estar inicializada.");

        DefaultTableModel tableModel = (DefaultTableModel) TestUtils.getFieldValue(ventanaPrincipal, "tableModel");
        assertNotNull(tableModel, "El modelo de la tabla debe estar inicializado.");

        // Verificar que la tabla tenga las columnas esperadas
        assertEquals(8, tableModel.getColumnCount(), "La tabla debe tener 8 columnas.");
        assertEquals("ID Alquiler", tableModel.getColumnName(0));
        assertEquals("Número Expediente", tableModel.getColumnName(1));
        assertEquals("Fecha Entrada", tableModel.getColumnName(2));
        assertEquals("Tiempo Estimado", tableModel.getColumnName(3));
        assertEquals("Nombre Cliente", tableModel.getColumnName(4));
        assertEquals("Vivienda Ref.", tableModel.getColumnName(5));
        assertEquals("Ubicación", tableModel.getColumnName(6));
        assertEquals("Precio Mensual", tableModel.getColumnName(7));
    }

    @Test
    public void testBuscarSinDNI() {
        // Simular que el campo de texto está vacío
        JTextField dniTextField = (JTextField) TestUtils.getFieldValue(ventanaPrincipal, "dniTextField");
        dniTextField.setText("");

        // Simular la acción del botón buscar
        JButton buscarButton = (JButton) TestUtils.getFieldValue(ventanaPrincipal, "buscarButton");
        buscarButton.doClick();

        // Verificar que se muestra un mensaje de error
        String lastErrorMessage = TestUtils.getLastErrorMessage();
        assertEquals("El campo DNI es obligatorio.", lastErrorMessage);
    }

    @Test
    public void testGenerarInforme() {
        // Simular la acción del botón generar informe
        JButton generarInformeButton = (JButton) TestUtils.getFieldValue(ventanaPrincipal, "generarInformeButton");
        assertNotNull(generarInformeButton, "El botón de generar informe debe estar inicializado.");
        generarInformeButton.doClick();
        
        // Verificar que el método GenerarPDF.generar() se llamó correctamente
        assertTrue(TestUtils.wasMethodCalled("GenerarPDF.generar"), "El método GenerarPDF.generar() debe ser llamado.");
    }
}

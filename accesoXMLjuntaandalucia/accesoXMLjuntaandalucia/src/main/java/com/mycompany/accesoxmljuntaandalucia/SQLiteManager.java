/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accesoxmljuntaandalucia;

/**
 *
 * @author beapa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteManager {
    public static Connection conectar() throws SQLException{
        String url = "jdbc:sqlite:contratos.db"; // Archivo de la base de datos SQLite

        Connection conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Conexión establecida con SQLite.");
        }
        return conn;   
    }
    
    public static void crearTabla() {
        String sql = """
            CREATE TABLE IF NOT EXISTS Contratos (
                NIF TEXT NOT NULL,
                ADJUDICATARIO TEXT,
                OBJETO_GENERICO TEXT,
                OBJETO TEXT,
                FECHA_ADJUDICACION DATE,
                IMPORTE TEXT,
                PROVEEDORES_CONSULTADOS TEXT,
                TIPO_DE_CONTRATO TEXT
            );
            """;

        try (Connection conn = SQLiteManager.conectar(); // Usar tu método de conexión
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql); // Ejecutar la sentencia SQL
            System.out.println("Tabla 'Contratos' creada (si no existía).");

        } catch (Exception e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
        
    public static void consultarTabla(){
        String sql = """
            SELECT * FROM Contratos;
            """;

        try (Connection conn = SQLiteManager.conectar(); // Usar tu método de conexión
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) { // Ejecutar la consulta SELECT y obtener el ResultSet

        // Iterar sobre el ResultSet y mostrar los valores
        while (rs.next()) {
            String nif = rs.getString("NIF"); // Obtener el valor de la columna NIF
            String adjudicatario = rs.getString("ADJUDICATARIO"); // Obtener el valor de la columna ADJUDICATARIO
            String objetoGenerico = rs.getString("OBJETO_GENERICO"); // Obtener el valor de la columna OBJETO_GENERICO
            String objeto = rs.getString("OBJETO"); // Obtener el valor de la columna OBJETO
            String fechaAdjudicacion = rs.getString("FECHA_ADJUDICACION"); // Obtener el valor de la columna FECHA_ADJUDICACION
            String importe = rs.getString("IMPORTE"); // Obtener el valor de la columna IMPORTE
            String proveedoresConsultados = rs.getString("PROVEEDORES_CONSULTADOS"); // Obtener el valor de la columna PROVEEDORES_CONSULTADOS
            String tipoContrato = rs.getString("TIPO_DE_CONTRATO"); // Obtener el valor de la columna TIPO_DE_CONTRATO

            // Imprimir los resultados de la fila actual
            System.out.println("NIF: " + nif);
            System.out.println("ADJUDICATARIO: " + adjudicatario);
            System.out.println("OBJETO_GENÉRICO: " + objetoGenerico);
            System.out.println("OBJETO: " + objeto);
            System.out.println("FECHA_ADJUDICACION: " + fechaAdjudicacion);
            System.out.println("IMPORTE: " + importe);
            System.out.println("PROVEEDORES_CONSULTADOS: " + proveedoresConsultados);
            System.out.println("TIPO_DE_CONTRATO: " + tipoContrato);
            System.out.println("----------------------------");
        }

        } catch (Exception e) {
            System.out.println("Error al ejecutar la consulta SELECT: " + e.getMessage());
        }

    }
    
    
}

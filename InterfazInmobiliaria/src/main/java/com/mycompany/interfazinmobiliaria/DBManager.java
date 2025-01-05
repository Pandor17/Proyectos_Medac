/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfazinmobiliaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author beapa
 */
public class DBManager {
    public static Connection conectar() throws SQLException{
        String url = "jdbc:sqlite:alquiler.db"; // Archivo de la base de datos SQLite
        Connection conn = DriverManager.getConnection(url);
        if (conn != null) {
            System.out.println("Conexión establecida con SQLite.");
        }
        return conn;   
    }
    
    public static void crearTabla() {
        String sqlClientes = """
            CREATE TABLE Clientes (
                id_cliente INTEGER PRIMARY KEY,
                nombre VARCHAR(100) NOT NULL,
                apellido VARCHAR(100) NOT NULL,
                email VARCHAR(150) UNIQUE NOT NULL,
                telefono VARCHAR(20) NOT NULL,
                direccion_facturacion TEXT NOT NULL,
                dni VARCHAR(50) UNIQUE NOT NULL
            );
            """;
        String sqlViviendas = """
            CREATE TABLE Viviendas (
                id_vivienda INTEGER PRIMARY KEY,
                codigo_referencia VARCHAR(50) UNIQUE NOT NULL,
                ubicacion TEXT NOT NULL,
                metros INT NOT NULL,
                num_habitaciones INT NOT NULL,
                num_banos INT NOT NULL,
                precio_mensual DECIMAL(10, 2) NOT NULL
            );
            """;
        String sqlAlquileres = """
            CREATE TABLE Alquileres (
                id_alquiler INTEGER PRIMARY KEY,
                numero_expediente VARCHAR(50) UNIQUE NOT NULL,
                fecha_entrada DATE NOT NULL,
                tiempo_estimado INT NOT NULL,
                id_cliente INT NOT NULL,
                id_vivienda INT NOT NULL,
                FOREIGN KEY (id_cliente) REFERENCES Clientes(id_cliente),
                FOREIGN KEY (id_vivienda) REFERENCES Viviendas(id_vivienda)
            );
            """;

        try (Connection conn = DBManager.conectar();  
            Statement stmt = conn.createStatement()) {
            stmt.execute(sqlClientes); 
            stmt.execute(sqlViviendas); 
            stmt.execute(sqlAlquileres); 
            System.out.println("Tablas creadas.");
            conn.close(); //cerrar conexion

        } catch (Exception e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }
    
    public static void insertarDatos(){
        String insertClientes = """
            INSERT INTO Clientes (nombre, apellido, email, telefono, direccion_facturacion, dni) VALUES
                                ('Juan', 'Pérez', 'juan.perez@gmail.com', '123456789', 'Calle Falsa 123, Madrid', '12345678A'),
                                ('María', 'López', 'maria.lopez@gmail.com', '987654321', 'Av. Siempre Viva 456, Sevilla', '87654321B'),
                                ('Carlos', 'Gómez', 'carlos.gomez@gmail.com', '123987456', 'Plaza Mayor 1, Valencia', '12349876C'),
                                ('Ana', 'Martínez', 'ana.martinez@gmail.com', '321654987', 'Calle Real 45, Barcelona', '98761234D'),
                                ('Luis', 'Fernández', 'luis.fernandez@gmail.com', '654123987', 'Calle Sol 89, Bilbao', '45678912E'),
                                ('Lucía', 'Hernández', 'lucia.hernandez@gmail.com', '789321654', 'Paseo del Prado 14, Málaga', '34567891F'),
                                ('David', 'Ruiz', 'david.ruiz@gmail.com', '147258369', 'Gran Vía 20, Zaragoza', '23456789G'),
                                ('Elena', 'García', 'elena.garcia@gmail.com', '963852741', 'Av. Libertad 99, Alicante', '87654320H'),
                                ('Javier', 'Ramírez', 'javier.ramirez@gmail.com', '159753486', 'Calle Larga 10, Murcia', '98765432J'),
                                ('Clara', 'Sánchez', 'clara.sanchez@gmail.com', '951753852', 'Calle Ancha 33, Vigo', '12345670K');                    
                                """;
        String insertViviendas = """
            INSERT INTO Viviendas (codigo_referencia, ubicacion, metros, num_habitaciones, num_banos, precio_mensual) VALUES
                                ('VIV001', 'Calle Falsa 123, Madrid', 80, 3, 2, 800.00),
                                ('VIV002', 'Av. Siempre Viva 456, Sevilla', 120, 4, 3, 1200.00),
                                ('VIV003', 'Plaza Mayor 1, Valencia', 65, 2, 1, 650.00),
                                ('VIV004', 'Calle Real 45, Barcelona', 90, 3, 2, 950.00),
                                ('VIV005', 'Calle Sol 89, Bilbao', 110, 4, 2, 1100.00),
                                ('VIV006', 'Paseo del Prado 14, Málaga', 70, 2, 1, 700.00),
                                ('VIV007', 'Gran Vía 20, Zaragoza', 85, 3, 2, 850.00),
                                ('VIV008', 'Av. Libertad 99, Alicante', 100, 3, 2, 1000.00),
                                ('VIV009', 'Calle Larga 10, Murcia', 75, 2, 1, 750.00),
                                ('VIV010', 'Calle Ancha 33, Vigo', 95, 3, 2, 950.00);
                                """;
        String insertAlquileres = """
            INSERT INTO Alquileres (numero_expediente, fecha_entrada, tiempo_estimado, id_cliente, id_vivienda) VALUES
                                ('EXP001', '2025-01-01', 12, 1, 1),
                                ('EXP002', '2025-02-15', 6, 2, 2),
                                ('EXP003', '2025-03-10', 9, 3, 3),
                                ('EXP004', '2025-01-20', 12, 4, 4),
                                ('EXP005', '2025-02-05', 8, 5, 5),
                                ('EXP006', '2025-01-30', 7, 6, 6),
                                ('EXP007', '2025-03-01', 10, 7, 7),
                                ('EXP008', '2025-01-25', 11, 8, 8),
                                ('EXP009', '2025-02-28', 6, 9, 9),
                                ('EXP010', '2025-01-15', 13, 10, 10);                    
                                """;
        String insertAlquileres2 ="""
            INSERT INTO Alquileres (numero_expediente, fecha_entrada, tiempo_estimado, id_cliente, id_vivienda) VALUES
                ('EXP011', '2025-03-15', 6, 1, 5),
                ('EXP012', '2025-04-01', 12, 1, 6),
                ('EXP013', '2025-02-20', 9, 1, 7),
                ('EXP014', '2025-01-18', 8, 1, 8),
                ('EXP015', '2025-03-05', 10, 1, 9);
                                  """;
        try (Connection conn = DBManager.conectar();  
            Statement stmt = conn.createStatement()) {
            stmt.execute(insertClientes); 
            stmt.execute(insertViviendas);
            stmt.execute(insertAlquileres2); 
            stmt.execute(insertAlquileres2); 
            System.out.println("Datos añadidos.");
            conn.close(); //cerrar conexion
        } catch (Exception e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
        }
    }
    
    public static void consultarDatos(){
        String consultarDatos = """
            SELECT 
                A.id_alquiler,
                A.numero_expediente,
                A.fecha_entrada,
                A.tiempo_estimado,
                C.nombre AS nombre_cliente,
                C.apellido AS apellido_cliente,
                C.email,
                C.telefono,
                C.direccion_facturacion,
                C.dni,
                V.codigo_referencia,
                V.ubicacion,
                V.metros,
                V.num_habitaciones,
                V.num_banos,
                V.precio_mensual
            FROM 
                Alquileres A
            JOIN 
                Clientes C ON A.id_cliente = C.id_cliente
            JOIN 
                Viviendas V ON A.id_vivienda = V.id_vivienda;                       
                                   """;
        
        
        try (Connection conn = DBManager.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultarDatos)) {

            // Procesar el resultado
            while (rs.next()) {
                System.out.println("ID Alquiler: " + rs.getInt("id_alquiler"));
                System.out.println("Número de Expediente: " + rs.getString("numero_expediente"));
                System.out.println("Fecha de Entrada: " + rs.getString("fecha_entrada"));
                System.out.println("Tiempo Estimado: " + rs.getInt("tiempo_estimado") + " meses");

                System.out.println("Cliente: " + rs.getString("nombre_cliente") + " " + rs.getString("apellido_cliente"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Teléfono: " + rs.getString("telefono"));
                System.out.println("Dirección de Facturación: " + rs.getString("direccion_facturacion"));
                System.out.println("DNI: " + rs.getString("dni"));

                System.out.println("Vivienda:");
                System.out.println("  Código de Referencia: " + rs.getString("codigo_referencia"));
                System.out.println("  Ubicación: " + rs.getString("ubicacion"));
                System.out.println("  Metros: " + rs.getInt("metros") + " m²");
                System.out.println("  Habitaciones: " + rs.getInt("num_habitaciones"));
                System.out.println("  Baños: " + rs.getInt("num_banos"));
                System.out.println("  Precio Mensual: " + rs.getBigDecimal("precio_mensual") + " €");
                System.out.println("-------------------------------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

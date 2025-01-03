/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accesoxmljuntaandalucia;

/**
 *
 * @author beapa
 */
public class Main {
    public static void main(String[] args) {
        SQLiteManager.crearTabla();
        XMLParser.parseXML("assets/co.xml");
        SQLiteManager.consultarTabla();
    }
    
}

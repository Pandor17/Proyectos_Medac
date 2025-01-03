/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.accesoxmljuntaandalucia;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import static javax.script.ScriptEngine.FILENAME;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author beapa
 */
public class XMLParser {
    public static void parseXML(String ruta){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(ruta));
            
            Document nuevoDoc = db.newDocument();
            Element rootElement = nuevoDoc.createElement("contratos");
            nuevoDoc.appendChild(rootElement);

            doc.getDocumentElement().normalize();
            Element worksheet = (Element) doc.getElementsByTagName("ss:Worksheet").item(0);
            Element tabla = (Element) worksheet.getElementsByTagName("Table").item(0);
            NodeList rowList = tabla.getElementsByTagName("Row");
            
            
            for (int filaIndice = 0; filaIndice < rowList.getLength(); filaIndice++) {
                Element rowElement = (Element)rowList.item(filaIndice);
                NodeList cellList = rowElement.getElementsByTagName("Cell");
                ArrayList<String> datosInsertar = new ArrayList<String>();
                
                Element hijo1 = nuevoDoc.createElement("contrato" + filaIndice+1);
                rootElement.appendChild(hijo1);
                
                for(int celdaIndice= 0; celdaIndice< cellList.getLength(); celdaIndice++){
                    Element cellElement = (Element)cellList.item(celdaIndice);
                    if (cellElement != null){
                        Element data = (Element)cellElement.getElementsByTagName("Data").item(0);
                        if (data != null){
                            datosInsertar.add(data.getTextContent());    
                        }
                    }
                    
                }
                for (String dato : datosInsertar){
                    if (datosInsertar.indexOf(dato) < datosInsertar.size()-1){
                        Element nodoDato = nuevoDoc.createElement("dato"+(datosInsertar.indexOf(dato)+1));
                        nodoDato.setTextContent(dato);
                        hijo1.appendChild(nodoDato);
                    }
                }
                
                XMLParser.insertarBD(datosInsertar);
                // write dom document to a file
                FileOutputStream output = new FileOutputStream("assets/nuevo.xml");
                writeXml(nuevoDoc, output);
                
                
            }
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
        e.printStackTrace();
        }
    }
    public static void insertarBD(ArrayList lista){
        String sql = """
        INSERT INTO Contratos (NIF, ADJUDICATARIO, OBJETO_GENERICO, OBJETO, FECHA_ADJUDICACION, IMPORTE, PROVEEDORES_CONSULTADOS, TIPO_DE_CONTRATO)
        VALUES (?, ?, ?, ?, ?, ?, ?, ?);
        """;

        try (Connection conn = SQLiteManager.conectar();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for(int i = 0; i<lista.size();i++){
                pstmt.setString(i+1, (String) lista.get(i));
            }

            pstmt.executeUpdate();
      
        } catch (Exception e) {
            System.out.println("Error al insertar en la base de datos: " + e.getMessage());
        }
    }
    private static void writeXml(Document doc, OutputStream output)
            throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);

    }
}

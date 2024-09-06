/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tema14;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;

/**
 *Desarrolla un programa en Java que nos permita almacenar 10 discos musicales en un fichero XML. 
 * El nodo raíz deberá llamarse catálogo y la estructura de un disco será la siguiente:
 <cd>
    <titulo></titulo>
    <artista></artista>
    <precio></precio>
 </cd>
Deberás pedir los datos de cada disco por teclado.
Una vez leídos los 10 discos, se pedirá al usuario el nombre del fichero XML y éste se creará.
 * @author beapa
 */
public class Xml {
    public static Document miDocumento;
    public static Element raiz;
    public static void crearXML () throws ParserConfigurationException{
        DocumentBuilderFactory miFabricaDoc = DocumentBuilderFactory.newInstance();
        DocumentBuilder miConstructorDoc = miFabricaDoc.newDocumentBuilder();
        Xml.miDocumento = miConstructorDoc.newDocument();
    }
    public static void crearElementoRaiz(){
        Xml.raiz = Xml.miDocumento.createElement("catálogo");
        Xml.miDocumento.appendChild(Xml.raiz);
    }
    public static void crearCD(String titulo, String autor, double precio){
        Element cd = Xml.miDocumento.createElement("cd");
        Xml.raiz.appendChild(cd);
        
        Element title = Xml.miDocumento.createElement("titulo");
        title.appendChild(Xml.miDocumento.createTextNode(titulo));
        cd.appendChild(title);
        
        Element artista = Xml.miDocumento.createElement("artista");
        artista.appendChild(Xml.miDocumento.createTextNode(autor));
        cd.appendChild(artista);
        
        Element costo = Xml.miDocumento.createElement("precio");
        costo.appendChild(Xml.miDocumento.createTextNode(String.valueOf(precio)));
        cd.appendChild(costo);
    }
   
    public static void main(String[] Args) throws ParserConfigurationException{
        int numeroDiscos = Integer.parseInt(JOptionPane.showInputDialog("Digite el número de discos a registrar"));
        ArrayList<String> titulos = new ArrayList<>();
        ArrayList<String> artistas = new ArrayList<>();
        ArrayList<Double> precios = new ArrayList<>();
        
        for(int i=0;i<numeroDiscos;i++){
            String preguntaTítulo ="Introduzca el Título de disco nº"+i;
            String preguntaArtista ="Introduzca el Autor de disco nº"+i;
            String preguntaPrecio ="Introduzca el Precio de disco nº"+i;
            
            titulos.add(i, JOptionPane.showInputDialog(preguntaTítulo));
            artistas.add(i, JOptionPane.showInputDialog(preguntaArtista));
            precios.add(i, Double.valueOf(JOptionPane.showInputDialog(preguntaPrecio)));
        }
        try{
           Xml.crearXML();
           Xml.crearElementoRaiz();
           for(int i=0;i<numeroDiscos;i++){
               Xml.crearCD(titulos.get(i), artistas.get(i), precios.get(i));
           }
           // Escribir el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(Xml.miDocumento);
            StreamResult streamResult = new StreamResult(new File("D:\\Repositorio\\actividadesPrimerCurso\\actividadesPracticaMedac\\programacion\\ActividadesJava4_20\\target\\classes\\Tema14\\catalogo.xml"));
            transformer.transform(domSource, streamResult);

            System.out.println("El archivo XML ha sido creado exitosamente con DOM.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

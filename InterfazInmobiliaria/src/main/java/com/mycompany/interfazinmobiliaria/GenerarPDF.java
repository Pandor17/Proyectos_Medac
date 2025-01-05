package com.mycompany.interfazinmobiliaria;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class GenerarPDF {

    public static void generar(JTable tabla, String nombreArchivo) {
        // Crear un documento en blanco
        Document document = new Document(PageSize.A4);
        
        try {
            // Crear el escritor para escribir en el archivo PDF
            PdfWriter.getInstance(document, new FileOutputStream(nombreArchivo));
            
            // Abrir el documento para empezar a escribir
            document.open();
            
            // Crear el título del PDF
            Font fuenteTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 28, Font.BOLD, BaseColor.DARK_GRAY);
            Paragraph title = new Paragraph("Informe de Alquileres", fuenteTitulo);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            // Salto de línea
            document.add(Chunk.NEWLINE);
            
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
            pdfTable.setWidthPercentage(100); // Ancho de la tabla
            
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD, BaseColor.WHITE);
            for (int i = 0; i < model.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Phrase(model.getColumnName(i), headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.DARK_GRAY);
                pdfTable.addCell(cell);
            }
            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    if (model.getValueAt(i, j) == null){
                        pdfTable.addCell("");
                    }
                    else{
                        PdfPCell cell = new PdfPCell(new Phrase(model.getValueAt(i, j).toString()));
                        cell.setVerticalAlignment(Element.ALIGN_CENTER);
                        pdfTable.addCell(cell);
                    }
                }
            }

            // Agregar la tabla al documento
            document.add(pdfTable);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar el documento para finalizar
            document.close();
        }

        // Mensaje de confirmación
        System.out.println("El informe ha sido generado exitosamente en " + nombreArchivo);
    }
}

package com.beans.daoFactory;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class PDFfactory {


    public void PDFfactory() {

    }
    public InputStream pdfgenerate() throws FileNotFoundException {

        try {
            FileOutputStream out = new FileOutputStream("my.pdf");
            Document document = new Document();
            PdfWriter.getInstance(document, out);
            document.open();
            document.add(new Paragraph("Hello World"));
            document.close();

        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            InputStream in = new FileInputStream("my.pdf");
            return in;
        }
    }

}

package com.beans.daoFactory;


import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFfactory {

    public PDFfactory() {
    }

    private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;

    public static void main(String[] args) {

        String pdfFilename = "my2.pdf";
        PDFfactory PDFfactory = new PDFfactory();
        if (args.length < 1)
        {
            System.err.println("Usage: java "+ PDFfactory.getClass().getName()+
                    " PDF_Filename");
            System.exit(1);
        }

        pdfFilename = args[0].trim();
        //PDFfactory.createPDF(pdfFilename,);

    }

    public InputStream conversion() throws FileNotFoundException {
        InputStream in = new FileInputStream("my2.pdf");
        return in;
    }

    public void createPDF (String pdfFilename, ArrayList<ProduitEntity> produitEntityArrayList, UserEntity user){

        System.out.println(produitEntityArrayList.toString());
        Document doc = new Document();
        PdfWriter docWriter = null;
        initializeFonts();

        try {
            String path = pdfFilename;
            docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
            doc.addAuthor("E Commerce ESEO");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("Maxime Martin");
            doc.addTitle("Facture ESEO");
            doc.setPageSize(PageSize.LETTER);

            doc.open();
            PdfContentByte cb = docWriter.getDirectContent();

            boolean beginPage = true;
            int y = 0;
            int i = 0;
            for (ProduitEntity entity:produitEntityArrayList){
                if(beginPage){
                    beginPage = false;
                    generateLayout(doc, cb);
                    generateHeader(doc, cb, user);
                    y = 615;
                }
                i = i+1;
                generateDetail(doc, cb, i, y,entity);
                y = y - 15;
                if(y < 50){
                    printPageNumber(cb);
                    doc.newPage();
                    beginPage = true;
                }
                printPageNumber(cb);
            }

            /*for(int i=0; i < 33; i++ ){
                if(beginPage){
                    beginPage = false;
                    generateLayout(doc, cb);
                    generateHeader(doc, cb);
                    y = 615;
                }


                generateDetail(doc, cb, i, y);

                y = y - 15;
                if(y < 50){
                    printPageNumber(cb);
                    doc.newPage();
                    beginPage = true;
                }
            }
            printPageNumber(cb);

             */
        }
        catch (DocumentException dex) {
            dex.printStackTrace();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            if (doc != null) {
                doc.close();
            }if (docWriter != null) {
                docWriter.close();}
        }
    }

    private void generateLayout(Document doc, PdfContentByte cb)  {
        try {
            cb.setLineWidth(1f);

            cb.rectangle(420,700,150,60);
            cb.moveTo(420,720);
            cb.lineTo(570,720);
            cb.moveTo(420,740);
            cb.lineTo(570,740);
            cb.moveTo(480,700);
            cb.lineTo(480,760);
            cb.stroke();

            createHeadings(cb,422,743,"Nom Client ");
            createHeadings(cb,422,723,"N. Commande ");
            createHeadings(cb,422,703,"Date Facture");

            cb.rectangle(20,50,550,600);
            cb.moveTo(20,630);
            cb.lineTo(570,630);
            cb.moveTo(50,50);
            cb.lineTo(50,650);
            cb.moveTo(150,50);
            cb.lineTo(150,650);
            cb.moveTo(430,50);
            cb.lineTo(430,650);
            cb.moveTo(500,50);
            cb.lineTo(500,650);
            cb.stroke();

            createHeadings(cb,22,633,"Id");
            createHeadings(cb,52,633,"Intitule");
            createHeadings(cb,152,633,"Categorie");
            createHeadings(cb,432,633,"Quantite");
            createHeadings(cb,502,633,"Prix");
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private void generateHeader(Document doc, PdfContentByte cb, UserEntity user)  {
        try {
            createHeadings(cb,200,750,"E commerce ESEO");
            createHeadings(cb,200,735,"10 Bd Jean Jeanneteau, 49100 Angers");
            createHeadings(cb,200,720,user.getLogin()+ "  /" +user.getAdresse());
            createHeadings(cb,200,705,user.getMail());
            createHeadings(cb,200,690,"France");

            createHeadings(cb,482,743, user.getNom() + " ," + user.getPrenom());
            createHeadings(cb,482,723,"ESEO-OO" + user.getId().toString());
            createHeadings(cb,482,703,java.time.LocalDate.now().toString());
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void generateDetail(Document doc, PdfContentByte cb, int index, int y,ProduitEntity entity)  {
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            createContent(cb,48,y,String.valueOf(index+1),PdfContentByte.ALIGN_RIGHT);
            createContent(cb,52,y, "ITEM" + entity.getNom(),PdfContentByte.ALIGN_LEFT);
            createContent(cb,152,y, "Product Description - SIZE " + entity.getCategorie(),PdfContentByte.ALIGN_LEFT);

            double price = Double.parseDouble(entity.getPrix());
            double extPrice = Double.parseDouble(entity.getPrix());
            createContent(cb,498,y, df.format(price),PdfContentByte.ALIGN_RIGHT);
            createContent(cb,568,y, df.format(extPrice),PdfContentByte.ALIGN_RIGHT);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void createHeadings(PdfContentByte cb, float x, float y, String text){
        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.setTextMatrix(x,y);
        cb.showText(text.trim());
        cb.endText();
    }

    private void printPageNumber(PdfContentByte cb){
        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Numero page : " + (pageNumber+1), 570 , 25, 0);
        cb.endText();
        pageNumber++;

    }

    private void createContent(PdfContentByte cb, float x, float y, String text, int align){
        cb.beginText();
        cb.setFontAndSize(bf, 8);
        cb.showTextAligned(align, text.trim(), x , y, 0);
        cb.endText();
    }

    private void initializeFonts(){
        try {
            bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
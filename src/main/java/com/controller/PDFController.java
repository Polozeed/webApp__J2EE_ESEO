package com.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.soap.Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.beans.User;
import com.beans.daoFactory.ProduitDAOFactory;
import com.beans.daoFactory.UserDAOFactory;
import com.beans.entity.ProduitEntity;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFController extends HttpServlet {


    private final UserDAOFactory userDAOFactory = new UserDAOFactory();
    private final ProduitDAOFactory produitDAOFactory = new ProduitDAOFactory();
    private static final long serialVersionUID = 1L;
    HttpSession session;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page == null || page.equals("pdf")) {
            Document document = new Document();
            try {
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
                document.open();
                document.add(new Paragraph("A Hello World PDF document."));
                document.close();
                writer.close();
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
            session = request.getSession();


            request.getRequestDispatcher("pdf.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if (page.equals("post_pdf")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("admin@1234")) {
                request.getRequestDispatcher("admin/index.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Error");


            }
        }
    }
}

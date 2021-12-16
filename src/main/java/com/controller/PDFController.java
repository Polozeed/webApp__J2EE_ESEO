package com.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.beans.daoFactory.PDFfactory;
import com.beans.daoFactory.ProduitDAOFactory;


public class PDFController extends HttpServlet {


    private static final int BYTES_DOWNLOAD = 1024;
    private final PDFfactory pdFfactory = new PDFfactory();
    private final ProduitDAOFactory produitDAOFactory = new ProduitDAOFactory();
    private final PDFfactory PDFfactory = new PDFfactory();

    private static final long serialVersionUID = 1L;
    HttpSession session;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        if(page == null || page.equals("pdf")) {
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition",
                    "attachment;filename=download.pdf");
            ServletContext ctx = getServletContext();
            //InputStream is = pdFfactory.pdfgenerate();
            PDFfactory.createPDF("my2.pdf");
            InputStream is = PDFfactory.conversion();
            int read=0;
            byte[] bytes = new byte[BYTES_DOWNLOAD];
            OutputStream os = response.getOutputStream();
            while((read = is.read(bytes))!= -1){
                os.write(bytes, 0, read);
            }
            os.flush();
            os.close();


            //request.getRequestDispatcher("pdf.jsp").forward(request, response);
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

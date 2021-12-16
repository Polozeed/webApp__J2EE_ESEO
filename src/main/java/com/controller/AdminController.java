package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import com.beans.Product;
import com.beans.daoFactory.AdminDAOFactory;
import com.beans.daoFactory.UserDAOFactory;
import com.beans.entity.ProduitEntity;
import com.model.DB;

public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AdminDAOFactory adminDAOFactory = new AdminDAOFactory();
	HttpSession session;
	ArrayList list = new ArrayList();

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null) {
			request.getRequestDispatcher("admin/login.jsp").forward(request, response);;
		}else {
			doPost(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page.equals("admin-login-form")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(username.equals("admin") && password.equals("admin@1234")) {
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);

			}
			else {
				request.setAttribute("msg", "Invalid Crediantials");
				request.setAttribute("username", username);
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);

			}
		}
		
		if(page.equals("delete")) {
			String id = request.getParameter("id");
			System.out.println("id===> res : " + id);
			try {
				adminDAOFactory.supprimerProduit(Integer.parseInt(id));
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);

		}
		
		if(page.equals("index")) {
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);

			try {
				list = adminDAOFactory.produitEntityListAdmin();

			} catch (Exception e) {
				e.printStackTrace();
			}
			session = request.getSession();
			session.setAttribute("list", list);
		}
		
		if(page.equals("addproduct")) {
			request.getRequestDispatcher("admin/addProduct.jsp").forward(request, response);
		}
		
		if(page.equals("edit")) {
			String id = request.getParameter("id");
			try {
				ProduitEntity p = adminDAOFactory.getOneproduitEntity(Integer.parseInt(id));
				request.setAttribute("p", p);
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.getRequestDispatcher("admin/editProduct.jsp").forward(request, response);
		}
		
		if(page.equals("edit_product")){
			String id = request.getParameter("id");
			String name = request.getParameter("nom");
			String price = request.getParameter("prix");
			String category = request.getParameter("categorie");
			String featured = request.getParameter("quantite");
			String image = request.getParameter("image");

			ProduitEntity p = new ProduitEntity();
			p.setId(Integer.parseInt(id));
			p.setNom(name);
			p.setPrix(price);
			p.setCategorie(category);
			p.setQuantite(featured);
			p.setImage("img/"+image);
			try {
				adminDAOFactory.updateOneProduct(p);
				list.add(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		
		if(page.equals("add_product")){
			String name = request.getParameter("nom");
			String price = request.getParameter("prix");
			String category = request.getParameter("categorie");
			String featured = request.getParameter("quantite");
			String image = request.getParameter("image");

			ProduitEntity p = new ProduitEntity();
			p.setNom(name);
			p.setPrix(price);
			p.setCategorie(category);
			p.setQuantite(featured);
			p.setImage("img/"+image);
			try {
				adminDAOFactory.newOneProduct(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
	}

}

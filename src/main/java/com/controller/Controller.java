package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;


import com.beans.FactoryProvider;
import com.beans.Product;

import com.beans.User;
import com.beans.daoFactory.ProduitDAOFactory;
import com.beans.daoFactory.UserDAOFactory;
import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;



public class Controller extends HttpServlet {


	private final UserDAOFactory userDAOFactory = new UserDAOFactory();
	private final ProduitDAOFactory produitDAOFactory = new ProduitDAOFactory();
	private static final long serialVersionUID = 1L;
	ArrayList<ProduitEntity> list = new ArrayList<ProduitEntity>();
	static ArrayList<String> cartlist = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	HttpSession session;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page == null || page.equals("index")) {
			try {
				list = produitDAOFactory.produitEntityList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session = request.getSession();
			session.setAttribute("cartlist", cartlist);
			session.setAttribute("list", list);

			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			doPost(request, response);
		}

			 session = request.getSession();
			 session.setAttribute("cartlist", cartlist);
			 session.setAttribute("list", list);

			request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		if(page.equals("login")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if(page.equals("sign-up")) {
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		
		if(page.equals("sign-up-form")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String address = request.getParameter("address");
			String password_1 = request.getParameter("password_1");
			String password_2 = request.getParameter("password_2");
			
			if(password_1.equals(password_2)) {

				UserEntity user = new UserEntity(username,password_1,username,name,email,address,null, null);
				Object res = userDAOFactory.inscription(user);

				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("notification","Inscription Réussite !");
				request.setAttribute("username", username);
				request.setAttribute("msg", "Account created successfully, Please Login!");
				request.getRequestDispatcher("login.jsp").forward(request, response);

			}else {
				request.setAttribute("msg", "The two passwords do not match");
				request.setAttribute("name", name);
				request.setAttribute("address", address);
				request.setAttribute("email", email);
				request.setAttribute("username", username);
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
			
		}
		
		if(page.equals("login-form")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			boolean status = false;
			status = userDAOFactory.connexion(username,password);

			if(status) {
				session = request.getSession();
				session.setAttribute("session", session);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "Invalid Crediantials");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		if(page.equals("logout")) {
			session = request.getSession();
			session.invalidate();
			session = request.getSession();
			cartlist.clear();
			session.setAttribute("cartlist", cartlist);
			session.setAttribute("list", list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		if(page.equals("mobiles") || page.equals("laptops") || page.equals("clothing") || page.equals("home-decor") || page.equals("all-products")) {
			try {
				list = produitDAOFactory.produitEntityList();
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.setAttribute("list", list);
			if(page.equals("mobiles"))
				request.getRequestDispatcher("menu/mobiles.jsp").forward(request, response);
			if(page.equals("laptops"))
				request.getRequestDispatcher("menu/laptops.jsp").forward(request, response);
			if(page.equals("clothing"))
				request.getRequestDispatcher("menu/clothing.jsp").forward(request, response);
			if(page.equals("home-decor"))
				request.getRequestDispatcher("menu/home-decor.jsp").forward(request, response);
			if(page.equals("all-products"))
				request.getRequestDispatcher("menu/all-products.jsp").forward(request, response);
		}

		if(page.equals("showcart")) {
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
		if(page.equals("addtocart")) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			ProduitEntity p = new ProduitEntity();
			boolean check = p.check(cartlist,id);
			
			if(check) {
				//JOptionPane.showMessageDialog(null, "Product is already added to Cart", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				cartlist.add(id);
				//JOptionPane.showMessageDialog(null, "Product successfully added to Cart", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(action.equals("index"))
				request.getRequestDispatcher("index.jsp").forward(request, response);
			if(action.equals("allproducts"))
				request.getRequestDispatcher("menu/all-products.jsp").forward(request, response);
			if(action.equals("clothing"))
				request.getRequestDispatcher("menu/clothing.jsp").forward(request, response);
			if(action.equals("home-decor"))
				request.getRequestDispatcher("menu/home-decor.jsp").forward(request, response);
			if(action.equals("laptops"))
				request.getRequestDispatcher("menu/laptops.jsp").forward(request, response);
			if(action.equals("mobiles"))
				request.getRequestDispatcher("menu/mobiles.jsp").forward(request, response);
		}
		
		if(page.equals("success")) {
			
			request.getRequestDispatcher("success.jsp").forward(request, response);
			
			session = request.getSession();
			 cartlist.clear();
			 session.setAttribute("cartlist", cartlist);
		}
		
		if(page.equals("remove")) {
			String id = request.getParameter("id");
			ProduitEntity p = new ProduitEntity();
			cartlist = p.remove(cartlist,id);
			
			session = request.getSession();
			session.setAttribute("cartlist", cartlist);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
		if(page.equals("price-sort")) {
			String price = request.getParameter("sort");
			String action = request.getParameter("action");
			ProduitEntity p = new ProduitEntity();
			if(price.equals("low-to-high"))
				list = p.lowtohigh(list);
			else
				list = p.hightolow(list);
			
			session.setAttribute("list", list);
			
			if(action.equals("index"))
				request.getRequestDispatcher("index.jsp").forward(request, response);
			if(action.equals("all-products"))
				request.getRequestDispatcher("menu/all-products.jsp").forward(request, response);
			if(action.equals("mobiles"))
				request.getRequestDispatcher("menu/mobiles.jsp").forward(request, response);
			if(action.equals("laptops"))
				request.getRequestDispatcher("menu/laptops.jsp").forward(request, response);
			if(action.equals("clothing"))
				request.getRequestDispatcher("menu/clothing.jsp").forward(request, response);
			if(action.equals("home-decor"))
				request.getRequestDispatcher("menu/home-decor.jsp").forward(request, response);
		}
	}

}

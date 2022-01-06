package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.beans.daoFactory.AdminDAOFactory;
import com.beans.daoFactory.ProduitDAOFactory;
import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;


//----------------------------------------// Controller Admin//--------------------------------------
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final AdminDAOFactory adminDAOFactory = new AdminDAOFactory();
	private final ProduitDAOFactory produitDAOFactory = new ProduitDAOFactory();
	HttpSession session;
	ArrayList list = new ArrayList();
	ArrayList listUtilisateur = new ArrayList();
	String editUser = null;

  
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


		//----------------------------------------// Formulaire Admin Login //------------------------------------------
		if(page.equals("admin-login-form")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(username.equals("admin") && password.equals("admin@1234")) {
				request.getRequestDispatcher("admin/index.jsp").forward(request, response);
			}
			else {
				request.setAttribute("msg", "Identifiant ou mot de passe incorrect");
				request.setAttribute("username", username);
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			}
		}
		//----------------------------------------// Suppression Produit //---------------------------------------------
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

		//----------------------------------------// JSP Index //-------------------------------------------------------
		if(page.equals("index")) {
			try {
				list = adminDAOFactory.produitEntityListAdmin();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session = request.getSession();
			session.setAttribute("list", list);
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}

		//----------------------------------------// JSP liste Utilisateur //-------------------------------------------
		if(page.equals("listeUtilisateur")) {
			try {
				listUtilisateur = adminDAOFactory.userEntityListAdmin();
			} catch (Exception e) {
				e.printStackTrace();
			}
			session = request.getSession();
			session.setAttribute("listUser", listUtilisateur);

			request.getRequestDispatcher("admin/listeUtilisateur.jsp").forward(request, response);
		}

		//----------------------------------------// JSP Edit User//---------------------------------------------
		if(page.equals("editUser")) {
			editUser = request.getParameter("id");
			try {
				UserEntity u = adminDAOFactory.getOneUserEntity(editUser);
				request.setAttribute("u", u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/editUser.jsp").forward(request, response);
		}

		//----------------------------------------// JSP Add Produit //---------------------------------------------
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

		//----------------------------------------// Formulaire Edition Produit //---------------------------------------------
		if(page.equals("edit_product")){
			String id = request.getParameter("id");
			String name = request.getParameter("nom");
			String price = request.getParameter("prix");
			String category = request.getParameter("select-categorie");
			String categoryDefaut = request.getParameter("categorie");
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			String featured = request.getParameter("select-tendance");
			String featuredDefaut = request.getParameter("tendance");
			String image = request.getParameter("image");
			System.out.print("categoryDefaut : " + categoryDefaut);
			System.out.print("featuredDefaut : " + featuredDefaut);
			ProduitEntity p = new ProduitEntity();
			p.setId(Integer.parseInt(id));
			p.setNom(name);
			p.setPrix(price);
			if(category.equals("CategorieDefaut")) {
				p.setCategorie(categoryDefaut);
			} else {
				p.setCategorie(category);
			}
			if(featured.equals("TendanceDefaut")) {
				p.setEnTendance(featuredDefaut);
			} else {
				p.setEnTendance(featured);
			}
			p.setQuantite(quantite);
			p.setImage(image);
			try {
				adminDAOFactory.updateOneProduct(p);
				list.add(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}

		//----------------------------------------// Formulaire Edition User //----------------------------------------
		if(page.equals("edit_user")){
			UserEntity u = adminDAOFactory.getOneUserEntity(editUser);
			String bloque = request.getParameter("select-bloque");
			if(bloque.equals("1")) {
				u.setEst_bloque(true);
			} else {
				u.setEst_bloque(false);
			}
			try {
				adminDAOFactory.updateOneUser(u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("admin/listeUtilisateur.jsp").forward(request, response);
		}

		//----------------------------------------// Formulaire Ajout Produit //----------------------------------------
		if(page.equals("add_product")){
			String name = request.getParameter("nom");
			String price = request.getParameter("prix");
			String category = request.getParameter("select-categorie");
			int quantite = Integer.parseInt(request.getParameter("quantite"));
			String featured = request.getParameter("select-tendance");
			String image = request.getParameter("image");
			ProduitEntity p = new ProduitEntity();
			p.setNom(name);
			p.setPrix(price);
			p.setCategorie(category);
			p.setQuantite(quantite);
			p.setEnTendance(featured);
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

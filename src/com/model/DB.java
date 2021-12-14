package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.User;
import com.beans.entity.ProduitEntity;


public class DB {
	
	private String username = "root";
	private String password = "root";
	private String dbName = "vente_en_ligne";
	private String url = "jdbc:mysql://localhost:3306/" + dbName;
	private String driver = "com.mysql.jdbc.Driver";
	
	ArrayList<ProduitEntity> list = new ArrayList<ProduitEntity>();
	ArrayList<User> userList = new ArrayList<>();
	
	private Connection con;
	private void dbConnect() {
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void addUser(User user) throws SQLException {
		dbConnect();
		String sql = "Insert into user(name,email,username,address,password) values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, user.getName());
		st.setString(2, user.getEmail());
		st.setString(3, user.getUsername());
		st.setString(4, user.getAddress());
		st.setString(5, user.getPassword());
		
		
		st.executeUpdate();
		dbClose();
	}




	public boolean checkUser(String username, String password) throws SQLException {
		dbConnect();
		int count = 0;
		String sql = "Select * from user where username = ? and password = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, username);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			count = 1;
		}
		
		dbClose();
		if(count == 0)
			return false;
		
		return true;
	}

	public ArrayList<ProduitEntity> fetch() throws SQLException {
		dbConnect();
		String sql = "Select * from product";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			int id=rs.getInt("id_produit");
			String name= rs.getString("nom");
			String categorie= rs.getString("categorie");
			String prix= rs.getString("prix");
			String quantite= rs.getString("quantite");
			String image= rs.getString("image");


			ProduitEntity p = new ProduitEntity();
			p.setCategorie(categorie);
			p.setQuantite(quantite);
			p.setId(id);
			p.setImage(image);
			p.setNom(name);
			p.setPrix(prix);
			list.add(p);
			p=null;
			
		}
		
		dbClose();
		return list;
	}

	public ArrayList<User> fetchUser() throws SQLException {
		dbConnect();
		String sql = "Select * from user";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String address = rs.getString("address");
			String user = rs.getString("username");
			String email = rs.getString("email");
			String name = rs.getString("name");
			int id = rs.getInt("id");
			String password = rs.getString("password");
			
			User u = new User();
			u.setAddress(address);
			u.setEmail(email);
			u.setId(id);
			u.setName(name);
			u.setUsername(user);
			u.setPassword(password);
			userList.add(u);
			u=null;
				
		}
		
		dbClose();
		return userList;
	}

	public void deleteProduct(String id) throws SQLException {
		
		dbConnect();
		String sql = "Delete from product where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
		dbClose();
		
	}

	public ProduitEntity fetchProduct(String id) throws SQLException {
		dbConnect();
		String sql = "select * from product where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rst = pstmt.executeQuery();
		ProduitEntity p = new ProduitEntity();
		while(rst.next()){
			
			p.setId(rst.getInt("id_produit"));
			p.setNom(rst.getString("nom"));
			p.setPrix(rst.getString("prix"));
			p.setCategorie(rst.getString("categorie"));
			p.setQuantite(rst.getString("quantite"));
			p.setImage(rst.getString("image"));
		}
		dbClose();
		return p;
	}

	public void updateProduct(ProduitEntity p) throws SQLException {
		dbConnect();
		String sql = "update product set name=?,price=?,category=?,featured=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, p.getNom());
		st.setString(2, p.getPrix());
		st.setString(3, p.getCategorie());
		st.setString(4, p.getQuantite());
		st.setInt(5, p.getId());
		st.executeUpdate();
		dbClose();
	}

	public void addProduct(ProduitEntity p) throws SQLException {
		dbConnect();
		String sql = "Insert into product(name,price,category,featured,image) values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, p.getNom());
		st.setString(2, p.getPrix());
		st.setString(3, p.getCategorie());
		st.setString(4, p.getQuantite());
		st.setString(5, p.getImage());
		st.executeUpdate();
		dbClose();
	}

	
	
	
}

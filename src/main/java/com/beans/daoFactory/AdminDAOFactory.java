package com.beans.daoFactory;

import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;
import java.util.ArrayList;

//----------------------------------------// DAO ADMIN//--------------------------------------
public class AdminDAOFactory {

    private final ProduitDAOFactory produitDAOFactory = new ProduitDAOFactory();
    private final UserDAOFactory userDAOFactory = new UserDAOFactory();

    public AdminDAOFactory() {
    }

    //----------------------------------------// Fct supprimer produit //--------------------------------------
    public void supprimerProduit(int id)  {
        try {
            produitDAOFactory.deleteOneProduit(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------// Fct List produit //--------------------------------------
    public ArrayList<ProduitEntity> produitEntityListAdmin() {
        ArrayList list = new ArrayList();
        list =produitDAOFactory.produitEntityList();
        return list;
    }

    //----------------------------------------// Fct liste User //--------------------------------------
    public ArrayList<UserEntity> userEntityListAdmin() {
        ArrayList list = new ArrayList();
        list =userDAOFactory.userEntityList();
        return list;
    }

    //----------------------------------------// Fct Get un produit //--------------------------------------
    public ProduitEntity getOneproduitEntity(int id) {
        ProduitEntity oneProduit = produitDAOFactory.getOneProduit(id);
        return oneProduit;
    }
    //----------------------------------------// Fct get//--------------------------------------
    public UserEntity getOneUserEntity(String login) {
        UserEntity oneUser = userDAOFactory.getOneUser(login);
        return oneUser;
    }


    public void updateOneProduct(ProduitEntity p){
        produitDAOFactory.updateProduct(p);
    }

    public void updateOneUser(UserEntity p){
        userDAOFactory.updateUser(p);
    }

    public void newOneProduct(ProduitEntity p){
        produitDAOFactory.newProduct(p);
    }

}

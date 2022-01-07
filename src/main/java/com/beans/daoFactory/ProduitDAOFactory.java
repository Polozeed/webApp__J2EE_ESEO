package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.ProduitEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//----------------------------------------// DAO Produit//--------------------------------------
public class ProduitDAOFactory {

    public ProduitDAOFactory() {
    }

    //----------------------------------------// Fct List produit//--------------------------------------
    public ArrayList<ProduitEntity> produitEntityList() {
        ArrayList<ProduitEntity> list = new ArrayList<ProduitEntity>();
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            List<ProduitEntity> resultList = hibernateSession
                    .createQuery("from com.beans.entity.ProduitEntity P", ProduitEntity.class)
                    .getResultList();
            transaction.commit();
            // Boucle for pour chaque produit
            for (ProduitEntity produitEntity : resultList) {
                ProduitEntity produit = new ProduitEntity(produitEntity.getId(), produitEntity.getNom(), produitEntity.getPrix(), produitEntity.getQuantite(), produitEntity.getEnTendance(), produitEntity.getCategorie(), produitEntity.getImage());
                System.out.println(produit.toString());
                list.add(produit);
                produit = null;
            }
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return list;
    }

    public List<ProduitEntity> productList(){
        return null;
    }

    //----------------------------------------// Fct Get un produit//--------------------------------------
    public ProduitEntity getOneProduit(int id) {
        System.out.println("----------------// Get One Produit //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        ProduitEntity produitEntity = new ProduitEntity();
        try {
            produitEntity = hibernateSession
                    .createQuery("FROM com.beans.entity.ProduitEntity p WHERE p.id = :id", ProduitEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            System.out.println(produitEntity.toString());
            transaction.commit();
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return produitEntity;
    }

    //----------------------------------------// Fct Delete un produit//--------------------------------------
    public void deleteOneProduit(int id) {
        System.out.println("----------------// Delete One Produit //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            ProduitEntity produitEntity =hibernateSession.find(ProduitEntity.class, id);
            hibernateSession.remove(produitEntity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
    }

    //----------------------------------------// Fct Update un produit/--------------------------------------
    public void updateProduct(ProduitEntity produit) {
        System.out.println("----------------// Update One Produit //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println(produit.toString());
            hibernateSession.merge(produit);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
    }
    //----------------------------------------// Fct Nouveau produit/--------------------------------------
    public void newProduct(ProduitEntity produit) {
        System.out.println("----------------// New One Produit //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println(produit.toString());
            hibernateSession.save(produit);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
    }
}

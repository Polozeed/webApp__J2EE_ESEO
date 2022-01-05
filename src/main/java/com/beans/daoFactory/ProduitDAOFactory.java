package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.ProduitEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOFactory {

    private final Session hibernateSession = FactoryProvider.getFactory().openSession();
    private final Transaction transaction = hibernateSession.beginTransaction();


    public ProduitDAOFactory() {
    }

    public void transactionSessionClose(){
        transaction.commit();
    }

    
    public ArrayList<ProduitEntity> produitEntityList() {

        ArrayList<ProduitEntity> list = new ArrayList<ProduitEntity>();
        try {
            List<ProduitEntity> res = hibernateSession
                    .createQuery("from com.beans.entity.ProduitEntity P", ProduitEntity.class)
                    .getResultList();
            for (ProduitEntity rs : res) {
                ProduitEntity p = new ProduitEntity(rs.getId(), rs.getNom(), rs.getPrix(), rs.getQuantite(), rs.getEnTendance(), rs.getCategorie(), rs.getImage());
                System.out.println(p.toString());
                list.add(p);
                p = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ProduitEntity> productList(){
        return null;
    }

    public ProduitEntity getOneProduit(int id) {
        System.out.println("----------------// Get One Produit //----------------");
        ProduitEntity res = new ProduitEntity();
        try {
            res = hibernateSession
                    .createQuery("FROM com.beans.entity.ProduitEntity p WHERE p.id = :id", ProduitEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            System.out.println(res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }


    public void deleteOneProduit(int id) {
        try {
            ProduitEntity res =hibernateSession.find(ProduitEntity.class, id);
            hibernateSession.remove(res);
            System.out.println("----------------// Delete One Produit //----------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.transactionSessionClose();
        }
    }

    public void updateProduct(ProduitEntity produit) {
        try {
            System.out.println("----------------// Update One Produit //----------------");
            System.out.println(produit.toString());
           hibernateSession.merge(produit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            //this.transactionSessionClose();
        }
    }

    public void newProduct(ProduitEntity produit) {
        try {
            System.out.println("----------------// New One Produit //----------------");
            System.out.println(produit.toString());
            hibernateSession.save(produit);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.transactionSessionClose();
        }
    }
}

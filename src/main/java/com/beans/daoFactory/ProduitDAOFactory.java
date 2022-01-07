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


    public ProduitDAOFactory() {
    }


    public ArrayList<ProduitEntity> produitEntityList() {

        ArrayList<ProduitEntity> list = new ArrayList<ProduitEntity>();
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            List<ProduitEntity> res = hibernateSession
                    .createQuery("from com.beans.entity.ProduitEntity P", ProduitEntity.class)
                    .getResultList();
            transaction.commit();
            for (ProduitEntity rs : res) {
                ProduitEntity p = new ProduitEntity(rs.getId(), rs.getNom(), rs.getPrix(), rs.getQuantite(), rs.getEnTendance(), rs.getCategorie(), rs.getImage());
                System.out.println(p.toString());
                list.add(p);
                p = null;
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

    public ProduitEntity getOneProduit(int id) {
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        System.out.println("----------------// Get One Produit //----------------");
        ProduitEntity res = new ProduitEntity();
        try {
            res = hibernateSession
                    .createQuery("FROM com.beans.entity.ProduitEntity p WHERE p.id = :id", ProduitEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            System.out.println(res.toString());
            transaction.commit();
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();

        }
        hibernateSession.close();
        return res;
    }


    public void deleteOneProduit(int id) {
        System.out.println("----------------// Delete One Produit //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            ProduitEntity res =hibernateSession.find(ProduitEntity.class, id);
            hibernateSession.remove(res);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
    }

    public void updateProduct(ProduitEntity produit) {
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println("----------------// Update One Produit //----------------");
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

    public void newProduct(ProduitEntity produit) {
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println("----------------// New One Produit //----------------");
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

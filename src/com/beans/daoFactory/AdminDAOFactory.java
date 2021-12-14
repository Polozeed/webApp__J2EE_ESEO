package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AdminDAOFactory {

    private final Session hibernateSession = FactoryProvider.getFactory().openSession();
    private final Transaction transaction = hibernateSession.beginTransaction();


    public AdminDAOFactory() {
    }
    public void transactionSessionClose(){
        transaction.commit();
        hibernateSession.close();
    }

    public void supprimerProduit(String id)  {
        try {
            ProduitEntity res =  hibernateSession.createQuery("DELETE FROM com.beans.entity.ProduitEntity  WHERE id_produit = :id", ProduitEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            System.out.println("---------// Produit Delete //---------------");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

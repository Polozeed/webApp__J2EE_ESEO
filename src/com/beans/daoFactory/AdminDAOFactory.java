package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOFactory {

    private final Session hibernateSession = FactoryProvider.getFactory().openSession();
    private final Transaction transaction = hibernateSession.beginTransaction();
    private final ProduitDAOFactory produitDAOFactory = new ProduitDAOFactory();

    public AdminDAOFactory() {
    }
    public void transactionSessionClose(){
        transaction.commit();
        hibernateSession.close();
    }

    public void supprimerProduit(int id)  {
        try {
            System.out.println("id ============>" +id);
            produitDAOFactory.deleteOneProduit(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ProduitEntity> produitEntityListAdmin() {
        ArrayList list = new ArrayList();
        list =produitDAOFactory.produitEntityList();
        return list;
    }

    public ProduitEntity getOneproduitEntity(int id) {
        ProduitEntity res = produitDAOFactory.getOneProduit(id);
        return res;
    }
}
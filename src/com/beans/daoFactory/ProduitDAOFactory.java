package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.Product;
import com.beans.entity.ProduitEntity;
import com.sun.deploy.net.MessageHeader;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProduitDAOFactory {

    private final Session hibernateSession = FactoryProvider.getFactory().openSession();
    private final Transaction transaction = hibernateSession.beginTransaction();


    public ProduitDAOFactory() {
    }

    public void transactionSessionClose(){
        transaction.commit();
        hibernateSession.close();
    }

    
    public ArrayList<ProduitEntity> produitEntityList() {

        ArrayList<ProduitEntity> list = new ArrayList<ProduitEntity>();
        try {

            List<ProduitEntity> res = hibernateSession
                    .createQuery("from com.beans.entity.ProduitEntity P", ProduitEntity.class)
                    .getResultList();

            for (ProduitEntity rs : res) {
                ProduitEntity p = new ProduitEntity(rs.getId(), rs.getNom(), rs.getPrix(), rs.getQuantite(), rs.getCategorie(), rs.getImage());
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




}

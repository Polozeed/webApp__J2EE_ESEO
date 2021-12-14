package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.Product;
import com.sun.deploy.net.MessageHeader;
import org.hibernate.Session;
import org.hibernate.Transaction;

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



    public List<Product> productList(){
        return null;
    }




}

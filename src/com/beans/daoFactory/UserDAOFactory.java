package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOFactory {


        private final Session hibernateSession = FactoryProvider.getFactory().openSession();
        private final Transaction transaction = hibernateSession.beginTransaction();


    public Object inscription(UserEntity user){
        try {
            System.out.println("je suis 3");
            Session hibernateSession = FactoryProvider.getFactory().openSession();
            Transaction transaction = hibernateSession.beginTransaction();
            System.out.println("je suis 4");
            int res = (int)hibernateSession.save(user);
            System.out.println("je suis 5");
            System.out.println(res);
            transaction.commit();
            hibernateSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void connexion(UserEntity user){
        try {
            Object res = hibernateSession.save(user);
            System.out.println(res.toString());
            transaction.commit();
            hibernateSession.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

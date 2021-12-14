package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOFactory {


    private final Session hibernateSession = FactoryProvider.getFactory().openSession();
    private final Transaction transaction = hibernateSession.beginTransaction();


    public UserDAOFactory() {
    }

    public void transactionSessionClose(){
        System.out.println("Transaction close");
        transaction.commit();
        //hibernateSession.close();
    }

    public Object inscription(UserEntity user){
        System.out.println("----------------// User Inscription  //----------------");
        try {
            System.out.println(user.toString());
            int res = (int)hibernateSession.save(user);
            this.transactionSessionClose();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean connexion(String username, String password) {
        System.out.println("----------------// User Connexion //----------------");
        boolean status = false;
        try {
            UserEntity res = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity  WHERE login = :username", UserEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();
            System.out.println(res.toString());
            if (res.getMdp().equals(password))
                status = true;
            else {
                status = false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }


}

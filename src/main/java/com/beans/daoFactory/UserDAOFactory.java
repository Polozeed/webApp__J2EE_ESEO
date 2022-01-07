package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDAOFactory {

    public UserDAOFactory() {
    }

    public Object inscription(UserEntity user){
        System.out.println("----------------// User Inscription  //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println(user.toString());
            int res = (int)hibernateSession.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
        return null;
    }

    public Boolean connexion(String username, String password) {
        System.out.println("----------------// User Connexion //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        boolean status = false;
        try {
            UserEntity res = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity  WHERE login = :username", UserEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();
            transaction.commit();
            System.out.println(res.toString());
            if (res.getMdp().equals(password))
                status = true;
            else {
                status = false;
            }

        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return status;
    }

    public UserEntity getOneUser(String login) {
        System.out.println("----------------// Get One User //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        UserEntity res = new UserEntity();
        try {
            res = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity p WHERE p.login = :login", UserEntity.class)
                    .setParameter("login", login)
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

    public UserEntity getOneUserById(int id) {
        System.out.println("----------------// Get One User By Id //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        UserEntity res = new UserEntity();
        try {
            res = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity p WHERE p.id = :id", UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            transaction.commit();
            System.out.println(res.toString());
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return res;
    }

    public ArrayList<UserEntity> userEntityList() {
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        ArrayList<UserEntity> list = new ArrayList<UserEntity>();
        try {
            List<UserEntity> res = hibernateSession
                    .createQuery("from com.beans.entity.UserEntity S", UserEntity.class)
                    .getResultList();
            transaction.commit();
            for (UserEntity rs : res) {
                UserEntity S = new UserEntity(rs.getLogin(),rs.getMdp(),rs.getNom(),rs.getPrenom(), rs.getMail(),rs.getAdresse(),rs.getToken(),rs.getEst_bloque());
                System.out.println(S.toString());
                list.add(S);
                S = null;
            }
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return list;
    }


    public void updateUser(UserEntity user) {
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println("----------------// Update One User//----------------");
            System.out.println(user.toString());
            hibernateSession.merge(user);
            transaction.commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
    }



}

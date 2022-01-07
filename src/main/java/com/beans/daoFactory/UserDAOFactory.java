package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

//----------------------------------------// DAO USER/--------------------------------------
public class UserDAOFactory {


    public UserDAOFactory() {
    }

    //----------------------------------------// Inscription/--------------------------------------
    public Object inscription(UserEntity user){
        System.out.println("----------------// User Inscription  //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println(user.toString());
            int save = (int)hibernateSession.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
        return null;
    }

    //----------------------------------------// Fct Connexion /--------------------------------------
    public Boolean connexion(String username, String password) {
        System.out.println("----------------// User Connexion //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        boolean status = false;
        try {
            UserEntity userEntity = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity  WHERE login = :username", UserEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();
            transaction.commit();
            System.out.println(userEntity.toString());
            // Test si mot de passe saisi = mot de passe en base de donnée
            if (userEntity.getMdp().equals(password))
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

    //----------------------------------------// Fct Get un User/--------------------------------------
    public UserEntity getOneUser(String login) {
        System.out.println("----------------// Get One User //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity p WHERE p.login = :login", UserEntity.class)
                    .setParameter("login", login)
                    .getSingleResult();
            System.out.println(userEntity.toString());
            transaction.commit();
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return userEntity;
    }

    //----------------------------------------// Fct Get un User by ID /--------------------------------------
    public UserEntity getOneUserById(int id) {
        System.out.println("----------------// Get One User By Id //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        UserEntity userEntity = new UserEntity();
        try {
            userEntity = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity p WHERE p.id = :id", UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            // Recuperation d'un seul resultat
            transaction.commit();
            System.out.println(userEntity.toString());
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return userEntity;
    }

    //----------------------------------------// Fct Liste User/--------------------------------------
    public ArrayList<UserEntity> userEntityList() {
        System.out.println("----------------// Get List User //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        ArrayList<UserEntity> list = new ArrayList<UserEntity>();
        try {
            List<UserEntity> resultList = hibernateSession
                    .createQuery("from com.beans.entity.UserEntity S", UserEntity.class)
                    .getResultList();
            transaction.commit();
            // Boucle For pour chaque UserEntity
            for (UserEntity userEntity : resultList) {
                UserEntity entity = new UserEntity(userEntity.getLogin(),userEntity.getMdp(),userEntity.getNom(),userEntity.getPrenom(), userEntity.getMail(),userEntity.getAdresse(),userEntity.getToken(),userEntity.getEst_bloque());
                System.out.println(entity.toString());
                list.add(entity);
                entity = null;
            }
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return list;
    }

    //----------------------------------------// Fct Update User/--------------------------------------
    public void updateUser(UserEntity user) {
        System.out.println("----------------// Update One User //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
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

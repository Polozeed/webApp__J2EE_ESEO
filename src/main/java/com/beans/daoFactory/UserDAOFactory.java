package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.ProduitEntity;
import com.beans.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDAOFactory {


    private Session hibernateSession = FactoryProvider.getFactory().openSession();
    private Transaction transaction = hibernateSession.beginTransaction();


    public UserDAOFactory() {
    }

    public void transactionSessionClose(){
        System.out.println("Transaction close");
        transaction.commit();
    }

    public Object inscription(UserEntity user){
        System.out.println("----------------// User Inscription  //----------------");
        try {
            System.out.println(user.toString());
            int res = (int)hibernateSession.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.transactionSessionClose();
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

    public UserEntity getOneUser(String login) {
        System.out.println("----------------// Get One User //----------------");
        UserEntity res = new UserEntity();
        try {
            res = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity p WHERE p.login = :login", UserEntity.class)
                    .setParameter("login", login)
                    .getSingleResult();
            System.out.println(res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public UserEntity getOneUserById(int id) {
        System.out.println("----------------// Get One User By Id //----------------");
        UserEntity res = new UserEntity();
        try {
            res = hibernateSession
                    .createQuery("FROM com.beans.entity.UserEntity p WHERE p.id = :id", UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
            System.out.println(res.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<UserEntity> userEntityList() {

        ArrayList<UserEntity> list = new ArrayList<UserEntity>();
        try {
            List<UserEntity> res = hibernateSession
                    .createQuery("from com.beans.entity.UserEntity S", UserEntity.class)
                    .getResultList();
            for (UserEntity rs : res) {
                UserEntity S = new UserEntity(rs.getLogin(),rs.getMdp(),rs.getNom(),rs.getPrenom(), rs.getMail(),rs.getAdresse(),rs.getToken(),rs.getEst_bloque());
                System.out.println(S.toString());
                list.add(S);
                S = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    public void updateUser(UserEntity user) {
        try {
            System.out.println("----------------// Update One User//----------------");
            System.out.println(user.toString());
            hibernateSession.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
        }
    }



}

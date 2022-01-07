package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.HistoriqueCommandeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueCommandeDAOFactory {


    public HistoriqueCommandeDAOFactory() {
    }


    public ArrayList<HistoriqueCommandeEntity> getHistorique(int id_client) {
        System.out.println("----------------// Get Historique //----------------");
        ArrayList<HistoriqueCommandeEntity> list = new ArrayList<HistoriqueCommandeEntity>();
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            List<HistoriqueCommandeEntity> res = hibernateSession
                    .createQuery("FROM com.beans.entity.HistoriqueCommandeEntity hc WHERE hc.id_client = :id_client", HistoriqueCommandeEntity.class)
                    .setParameter("id_client", id_client)
                    .getResultList();
            transaction.commit();
            for (HistoriqueCommandeEntity rs : res) {
                HistoriqueCommandeEntity hc = new HistoriqueCommandeEntity(rs.getId_hist_commande(), rs.getDateheure(), rs.getQuantite(), rs.getId_client(), rs.getId_produit());
                System.out.println(hc.toString());
                list.add(hc);
                hc = null;
            }
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return list;
    }

    public void ajoutHistorique(HistoriqueCommandeEntity historique) {
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            System.out.println("----------------// Ajout Historique //----------------");
            System.out.println(historique.toString());
            hibernateSession.save(historique);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            hibernateSession.close();
        }
    }
}

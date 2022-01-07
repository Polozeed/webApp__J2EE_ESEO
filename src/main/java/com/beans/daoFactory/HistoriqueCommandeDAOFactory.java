package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.HistoriqueCommandeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

//----------------------------------------// DAO Historique Commande//--------------------------------------
public class HistoriqueCommandeDAOFactory {


    public HistoriqueCommandeDAOFactory() {
    }

    //----------------------------------------// Fct Get Historique //--------------------------------------
    public ArrayList<HistoriqueCommandeEntity> getHistorique(int id_client) {
        System.out.println("----------------// Get Historique //----------------");
        ArrayList<HistoriqueCommandeEntity> list = new ArrayList<HistoriqueCommandeEntity>();
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
            List<HistoriqueCommandeEntity> client = hibernateSession
                    .createQuery("FROM com.beans.entity.HistoriqueCommandeEntity hc WHERE hc.id_client = :id_client", HistoriqueCommandeEntity.class)
                    .setParameter("id_client", id_client)
                    .getResultList();
            transaction.commit();
            // Boucle for pour chaque client
            for (HistoriqueCommandeEntity commandeEntity : client) {
                HistoriqueCommandeEntity historiqueCommandeEntity = new HistoriqueCommandeEntity(commandeEntity.getId_hist_commande(), commandeEntity.getDateheure(), commandeEntity.getQuantite(), commandeEntity.getId_client(), commandeEntity.getId_produit());
                list.add(historiqueCommandeEntity);
                historiqueCommandeEntity = null;
            }
        } catch (Exception e) {
            hibernateSession.close();
            e.printStackTrace();
        }
        hibernateSession.close();
        return list;
    }

    //----------------------------------------// Fct Ajout Historique//--------------------------------------
    public void ajoutHistorique(HistoriqueCommandeEntity historique) {
        System.out.println("----------------// Ajout Historique //----------------");
        Session hibernateSession = FactoryProvider.getFactory().openSession();
        Transaction transaction= hibernateSession.beginTransaction();
        try {
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

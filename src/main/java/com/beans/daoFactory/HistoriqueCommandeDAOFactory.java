package com.beans.daoFactory;

import com.beans.FactoryProvider;
import com.beans.entity.HistoriqueCommandeEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HistoriqueCommandeDAOFactory {

    private Session hibernateSession = FactoryProvider.getFactory().openSession();
    private Transaction transaction = hibernateSession.beginTransaction();


    public HistoriqueCommandeDAOFactory() {
    }

    public void transactionSessionClose(){
        transaction.commit();
    }

    public ArrayList<HistoriqueCommandeEntity> getHistorique(int id_client) {
        System.out.println("----------------// Get Historique //----------------");
        ArrayList<HistoriqueCommandeEntity> list = new ArrayList<HistoriqueCommandeEntity>();
        try {
            List<HistoriqueCommandeEntity> res = hibernateSession
                    .createQuery("FROM com.beans.entity.HistoriqueCommandeEntity hc WHERE hc.id_client = :id_client", HistoriqueCommandeEntity.class)
                    .setParameter("id_client", id_client)
                    .getResultList();
            for (HistoriqueCommandeEntity rs : res) {
                HistoriqueCommandeEntity hc = new HistoriqueCommandeEntity(rs.getId_hist_commande(), rs.getDateheure(), rs.getQuantite(), rs.getId_client(), rs.getId_produit());
                System.out.println(hc.toString());
                list.add(hc);
                hc = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void ajoutHistorique(HistoriqueCommandeEntity historique) {
        try {
            System.out.println("----------------// Ajout Historique //----------------");
            System.out.println(historique.toString());
            hibernateSession.save(historique);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            this.transactionSessionClose();
        }
    }
}

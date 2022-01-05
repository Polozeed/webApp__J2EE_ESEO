package com.beans;

import java.time.LocalDateTime;

public class HistoriqueCommande {

    private int id_hist_commande;
    private LocalDateTime dateheure;
    private int id_client;
    private int id_produit;
    private int quantite;

    public int getId_hist_commande() {return id_hist_commande;}

    public void setId_hist_commande(int id_hist_commande) {this.id_hist_commande = id_hist_commande;}

    public LocalDateTime getDateheure() {
        System.out.println("======================================33333 je suis dans historique Command");
        return dateheure;}

    public void setDateheure(LocalDateTime dateheure) {this.dateheure = dateheure;}

    public int getId_client() {return id_client;}

    public void setId_client(int id_client) {this.id_client = id_client;}

    public int getId_produit() {return id_produit;}

    public void setId_produit(int id_produit) {this.id_produit = id_produit;}

    public int getQuantite() {return quantite;}

    public void setQuantite(int quantite) {this.quantite = quantite;}
}

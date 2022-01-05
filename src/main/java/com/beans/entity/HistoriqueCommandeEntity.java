package com.beans.entity;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Table(name = "historique_commande")
@Entity(name = "HistoriqueCommandeEntity")
public class HistoriqueCommandeEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hist_commande", nullable = false)
    private Integer id_hist_commande;

    @Column(name = "dateheure", nullable = false)
    private LocalDateTime dateheure;

    @Column(name = "quantite", nullable = false)
    private int quantite;

    @JoinColumn(
            name = "id_client",
            referencedColumnName = "id_client"
    )
    private int id_client;

    @JoinColumn(
            name = "id_produit",
            referencedColumnName = "id_produit"
    )
    private int id_produit;

    public HistoriqueCommandeEntity(Integer id_hist_commande, LocalDateTime dateheure, int quantite, int id_client, int id_produit) {
        this.id_hist_commande = id_hist_commande;
        this.dateheure = dateheure;
        this.quantite = quantite;
        this.id_client = id_client;
        this.id_produit = id_produit;
    }

    public HistoriqueCommandeEntity(LocalDateTime dateheure, int quantite, int id_client, int id_produit) {
        this.dateheure = dateheure;
        this.quantite = quantite;
        this.id_client = id_client;
        this.id_produit = id_produit;
    }

    public HistoriqueCommandeEntity() {

    }

    public Integer getId_hist_commande() {return id_hist_commande;}

    public void setId_hist_commande(Integer id_hist_commande) {this.id_hist_commande = id_hist_commande;}

    public LocalDateTime getDateheure() {
        return dateheure;
    }
    public String getDateheureFront() {
        Date out = Date.from(dateheure.atZone(ZoneId.systemDefault()).toInstant());
        DateFormat mediumDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM,
                DateFormat.MEDIUM);
        return mediumDateFormat.format(out);

    }



    public void setDateheure(LocalDateTime dateheure) {this.dateheure = dateheure;}

    public int getQuantite() {return quantite;}

    public void setQuantite(int quantite) {this.quantite = quantite;}

    public int getId_client() {return id_client;}

    public void setId_client(int id_client) {this.id_client = id_client;}

    public int getId_produit() {return id_produit;}

    public void setId_produit(int id_produit) {this.id_produit = id_produit;}

    @Override
    public String toString() {
        return "HistoriqueCommandeEntity{" +
                "id=" + id_hist_commande +
                ", dateheure='" + dateheure + '\'' +
                ", id_client=" + id_client +
                ", id_produit='" + id_produit + '\'' +
                ", quantite='" + quantite + '\'' +
                '}';
    }
}

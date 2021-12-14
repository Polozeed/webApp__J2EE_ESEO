package com.beans.entity;


import javax.persistence.*;

@Table(name = "produit")
@Entity(name = "ProduitEntity")
public class ProduitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 60)
    private String nom;

    @Column(name = "prix", nullable = true)
    private Float prix;

    @Column(name = "quantite_stock", nullable = true)
    private String quantite;


    public ProduitEntity(Integer id, String nom, Float prix, String quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public ProduitEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }


    @Override
    public String toString() {
        return "ProduitEntity{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantite='" + quantite + '\'' +
                '}';
    }
}






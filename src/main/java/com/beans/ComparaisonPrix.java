package com.beans;

import com.beans.entity.ProduitEntity;

import java.util.Comparator;


//----------------------------------------// Classe permettant de comparer le prix des produits //--------------------------------------
public class ComparaisonPrix implements Comparator<ProduitEntity> {
    public int compare(ProduitEntity p1, ProduitEntity p2) {
        return Integer.parseInt(p2.getPrix()) - Integer.parseInt(p1.getPrix());
    }

}

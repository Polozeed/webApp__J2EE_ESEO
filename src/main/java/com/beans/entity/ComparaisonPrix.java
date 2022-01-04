package com.beans.entity;

import java.util.Comparator;

public class ComparaisonPrix implements Comparator<ProduitEntity> {
    public int compare(ProduitEntity p1, ProduitEntity p2) {
        return Integer.parseInt(p2.getPrix()) - Integer.parseInt(p1.getPrix());
    }

}

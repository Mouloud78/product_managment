package com.mouloud.produits.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomProd", types = { Produit.class})
public interface ProduitPrejection {
    public String getNomProduit();
}

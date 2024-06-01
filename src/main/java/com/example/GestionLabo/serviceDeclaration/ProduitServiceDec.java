package com.example.GestionLabo.serviceDeclaration;

import com.example.GestionLabo.models.Produit;
import com.example.GestionLabo.models.ProduitRequestDto;

import java.util.List;

public interface ProduitServiceDec {
    Produit saveProduct(ProduitRequestDto produit);

    List<Produit> getAllProducts();

    Produit getProductById(String id);

    void deleteProduct(String id);

    Produit modifieProuct(Produit produit);
    void inventaireProduit(Produit produit);

}

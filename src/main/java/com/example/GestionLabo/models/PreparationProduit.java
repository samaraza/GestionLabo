package com.example.GestionLabo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class PreparationProduit {

    private Produit produit ;
    private int quantite;

}

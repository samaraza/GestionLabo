package com.example.GestionLabo.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProduitInventaire {

    private Produit produit ;
    private  int quantiteRestante ;

}

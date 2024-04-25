package com.example.GestionLabo.models;

import com.example.GestionLabo.models.enums.NiveauScolaire;
import com.example.GestionLabo.models.enums.TpType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "tp")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Tp {

    @Id
    private  String id  ;
    private TpType type ;
    private LocalDateTime jourTp ;
    @DBRef
    private User prof ;
    @DBRef
    private SalleTp salleTp ;
    private NiveauScolaire niveauScolaire ;
    @DBRef
    private List<PreparationProduit> preparationProduits ;
    @DBRef
    private List<Preparation>preparations ;
    @DBRef
    private List<Produit>produits ;

}

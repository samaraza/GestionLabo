package com.example.GestionLabo.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "fournisseur")
@Builder

public class Fournisseur {
    @Id
    private String id  ;
    private String nom  ;
    private  String adresse ;
    private  String email  ;
    private    String nmrTel ;

}

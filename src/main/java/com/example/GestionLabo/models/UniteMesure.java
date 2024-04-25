package com.example.GestionLabo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "uniteMesure")

public class UniteMesure {

    @Id
    private String id  ;
    private String designation  ;
    private  String abreviation   ;

}

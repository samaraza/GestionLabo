package com.example.GestionLabo.models;

import com.example.GestionLabo.models.enums.LaboType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "labo")
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Labo {

    @Id
    private String id   ;
    private LaboType laboType  ;
    @DBRef
    @JsonIgnore
    private List<SalleTp> salleTp = new ArrayList<>();

}

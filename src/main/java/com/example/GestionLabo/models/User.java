package com.example.GestionLabo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.Role;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "user")
@NoArgsConstructor

public class User {
    @Id
    private String id  ;
    private String firstName  ;
    private  String lastName   ;
    @Indexed(unique = true)
    private  String email   ;
    private String password  ;
    private Role role;

}

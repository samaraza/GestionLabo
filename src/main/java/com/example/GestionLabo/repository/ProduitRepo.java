package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepo extends MongoRepository<Produit,String> {
}

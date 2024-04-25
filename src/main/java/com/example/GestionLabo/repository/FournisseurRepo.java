package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Fournisseur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepo extends MongoRepository<Fournisseur, String> {
}

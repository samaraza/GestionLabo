package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Inventaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventaireRepo extends MongoRepository<Inventaire, String> {
}

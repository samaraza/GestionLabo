package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Rubrique;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubriqueRepo extends MongoRepository<Rubrique, String> {
}

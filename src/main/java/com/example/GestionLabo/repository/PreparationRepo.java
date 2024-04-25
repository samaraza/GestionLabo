package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Preparation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreparationRepo extends MongoRepository<Preparation, String> {
}

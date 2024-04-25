package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.SalleTp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalleTpRepo extends MongoRepository<SalleTp, String> {
}

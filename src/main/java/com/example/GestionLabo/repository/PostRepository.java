package com.example.GestionLabo.repository;

import com.example.GestionLabo.models.Posts;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Posts, String> {
}

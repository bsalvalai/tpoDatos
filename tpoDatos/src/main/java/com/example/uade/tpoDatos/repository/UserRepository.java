package com.example.uade.tpoDatos.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.uade.tpoDatos.entity.User;
import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Long>{

    User findByNombre(String nombre);
    User findByDni(String dni);
    User findByEmail(String emial);
} 

package com.example.obspringsecurityjwtroles.repository;

import com.example.obspringsecurityjwtroles.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //usuario para buscarlo con nombre
    User findByUsername(String username);

    //existe un usuario por email, retorna un boolean sin necesidad de recuperar un usuario de base de datos, lo cual consume recursos
    boolean existsByEmail(String email);
}
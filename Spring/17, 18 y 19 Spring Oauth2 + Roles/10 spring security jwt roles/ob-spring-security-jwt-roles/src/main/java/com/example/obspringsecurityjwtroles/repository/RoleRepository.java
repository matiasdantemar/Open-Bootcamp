package com.example.obspringsecurityjwtroles.repository;

import com.example.obspringsecurityjwtroles.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    // a la hora de agregar roles al usuario al crearlos en base de datos y le asigna un rol y hay que buscarlo
    Role findRoleByName(String name);
}
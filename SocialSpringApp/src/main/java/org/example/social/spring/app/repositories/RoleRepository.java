package org.example.social.spring.app.repositories;

import org.example.social.spring.app.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role getRoleByName(String name);
}

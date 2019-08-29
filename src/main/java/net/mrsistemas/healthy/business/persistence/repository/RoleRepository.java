package net.mrsistemas.healthy.business.persistence.repository;

import net.mrsistemas.healthy.business.persistence.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {}

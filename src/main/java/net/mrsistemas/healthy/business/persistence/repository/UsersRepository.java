package net.mrsistemas.healthy.business.persistence.repository;

import net.mrsistemas.healthy.business.persistence.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {}

package net.mrsistemas.iot.business.persistence.repository;

import net.mrsistemas.iot.business.persistence.entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

}

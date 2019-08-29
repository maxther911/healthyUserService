package net.mrsistemas.healthy.business.persistence.repository;

import net.mrsistemas.healthy.business.persistence.entities.DataUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataUserRepository extends CrudRepository<DataUser, Long> {}

package net.mrsistemas.healthy.business.persistence.repository;

import net.mrsistemas.healthy.business.persistence.entities.OauthClientDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OauthRepository extends CrudRepository<OauthClientDetails, String> {}

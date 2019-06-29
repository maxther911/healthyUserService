package net.mrsistemas.iot.business.persistence.repository;

import net.mrsistemas.iot.business.persistence.entities.DatosUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataUserRepository extends CrudRepository<DatosUsuario, Long> {


}

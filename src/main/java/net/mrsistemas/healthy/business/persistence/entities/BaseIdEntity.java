package net.mrsistemas.healthy.business.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseIdEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_id_seq_gen")
	@SequenceGenerator(name="user_id_seq_gen", sequenceName = "users_id_seq", schema = "public")
	protected long id;


}
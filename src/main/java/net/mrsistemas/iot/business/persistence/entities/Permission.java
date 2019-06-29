package net.mrsistemas.iot.business.persistence.entities;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Permission extends BaseIdEntity implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

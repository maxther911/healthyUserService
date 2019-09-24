package net.mrsistemas.healthy.business.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(insertable = false, updatable = false)
	@Getter @Setter
	private Long id;
	@Getter @Setter
	private BigDecimal altitude;
	@Getter @Setter
	private BigDecimal latitude;
	@Getter @Setter
	private BigDecimal longitude;

	public Location() {
	}

}

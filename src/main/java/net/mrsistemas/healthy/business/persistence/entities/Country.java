package net.mrsistemas.healthy.business.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@NoArgsConstructor
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String code;

	@Getter @Setter
	private String name;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "country")
	@Getter @Setter
	@JsonIgnoreProperties("country")
	private Set<City> cities = new HashSet<>();

}


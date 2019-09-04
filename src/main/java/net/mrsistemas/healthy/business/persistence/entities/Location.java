package net.mrsistemas.healthy.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
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
	private Long id;
	private Long altitude;
	private Long latitude;
	private Long longitude;

	public Location() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAltitude() {
		return this.altitude;
	}

	public void setAltitude(Long altitude) {
		this.altitude = altitude;
	}

	public Long getLatitude() {
		return this.latitude;
	}

	public void setLatitude(Long latitude) {
		this.latitude = latitude;
	}

	public Long getLongitude() {
		return this.longitude;
	}

	public void setLongitude(Long longitude) {
		this.longitude = longitude;
	}
}
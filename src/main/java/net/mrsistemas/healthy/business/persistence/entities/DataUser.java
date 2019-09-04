package net.mrsistemas.healthy.business.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the data_users database table.
 * 
 */
@Entity
@Table(name="data_users")
public class DataUser implements Serializable {

	@Id
	private Long id;

	private String address;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "YYYY-MM-dd")
	@JsonProperty(value = "FechaDeNacimiento")
	@Column(name="birth_date")
	private LocalDate birthDate;

	private String cellphone;

	private String dni;

	private String email;

	@Column(name="id_contact")
	private BigDecimal idContact;

	@Column(name="last_name")
	private String lastName;

	private String name;

	private String phone;

	private BigDecimal state;

	//bi-directional many-to-one association to City
	@OneToMany(fetch=FetchType.EAGER)
	private List<City> places_visited;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="id_city_birth")
	private City birth_city;;

	public DataUser() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getIdContact() {
		return this.idContact;
	}

	public void setIdContact(BigDecimal idContact) {
		this.idContact = idContact;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getState() {
		return this.state;
	}

	public void setState(BigDecimal state) {
		this.state = state;
	}

	public List<City> getPlaces_visited() {
		return this.places_visited;
	}

	public void setPlaces_visited(List<City> places_visited) {
		this.places_visited = places_visited;
	}

	public City addCity(City city) {
		getPlaces_visited().add(city);
		return city;
	}

	public City removeCity(City city) {
		getPlaces_visited().remove(city);
		return city;
	}

	public City getBirth_city() {
		return this.birth_city;
	}

	public void setBirth_city(City birth_city) {
		this.birth_city = birth_city;
	}

}

package net.mrsistemas.healthy.business.persistence.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the data_users database table.
 * 
 */
@Entity
@Table(name="data_users")
public class DataUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	private String address;

	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date birthDate;

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
	@OneToMany(mappedBy="dataUser", fetch=FetchType.EAGER)
	private List<City> cities;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="id_city")
	private City city1;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="id_city_birth")
	private City city2;

	//bi-directional one-to-one association to Users
	@OneToOne
	@JoinColumn(name="id")
	private Users user1;

	//bi-directional one-to-one association to Users
	@OneToOne(mappedBy="dataUser2")
	private Users user2;

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

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
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

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		return city;
	}

	public City getCity1() {
		return this.city1;
	}

	public void setCity1(City city1) {
		this.city1 = city1;
	}

	public City getCity2() {
		return this.city2;
	}

	public void setCity2(City city2) {
		this.city2 = city2;
	}

	public Users getUser1() {
		return this.user1;
	}

	public void setUser1(Users user1) {
		this.user1 = user1;
	}

	public Users getUser2() {
		return this.user2;
	}

	public void setUser2(Users user2) {
		this.user2 = user2;
	}

}
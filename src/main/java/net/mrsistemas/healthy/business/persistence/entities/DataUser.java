package net.mrsistemas.healthy.business.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The persistent class for the data_users database table.
 * 
 */
@Entity
@Table(name="data_users")
public class DataUser {

	@Id
	private Long id;
	private String address;
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="birth_date")
	private LocalDate birthDate;
	private String cellphone;
	private String dni;
	private String email;
	@Column(name="id_contact")
	private Long idContact;
	@Column(name="last_name")
	private String lastName;
	private String name;
	private String phone;
	private BigDecimal state;

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

	public Long getIdContact() {
		return this.idContact;
	}

	public void setIdContact(Long idContact) {
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

	public City getBirth_city() {
		return this.birth_city;
	}

	public void setBirth_city(City birth_city) {
		this.birth_city = birth_city;
	}

}

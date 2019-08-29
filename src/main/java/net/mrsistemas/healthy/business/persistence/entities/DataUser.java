package net.mrsistemas.healthy.business.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * The persistent class for the DATOS_USUARIO database table.
 */
@Entity
@Table(name = "DATA_USERS")
@AllArgsConstructor
@NoArgsConstructor
public class DataUser extends BaseIdEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Column(insertable=false, updatable=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    private String dni;

    @Getter
    @Setter
    @Column(name = "nombres")
    private String name;

    @Getter
    @Setter
    @Column(name = "apellidos")
    private String lastName;

    @Getter
    @Setter
    @Column(name = "direccion")
    private String address;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @Column(name = "movil")
    private String cellphone;

    @Getter
    @Setter
    private String id_city;

    @Getter
    @Setter
    @OneToMany
    @JoinColumn(name = "id_city", referencedColumnName = "id", insertable=false, updatable=false)
    private Set<City> city;

    @ManyToOne
    @JoinColumn(name="id", referencedColumnName = "id", nullable=false, insertable=false, updatable=false)
    private Users users;

    @Column(name = "tel_principal")
    private String phone;
}

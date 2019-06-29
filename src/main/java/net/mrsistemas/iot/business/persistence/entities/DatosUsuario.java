package net.mrsistemas.iot.business.persistence.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * The persistent class for the DATOS_USUARIO database table.
 */
@Entity
@Table(name = "DATA_USERS")
public class DatosUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private long id;
    private String dni;
    private String nombres;
    private String apellidos;
    private String ciudad;
    private String direccion;
    private String email;
    private String movil;
    private String pais;

    @OneToOne(mappedBy = "datosUsuario")
    private Users users;

    @Column(name = "TEL_PRINCIPAL")
    private String telPrincipal;

    public DatosUsuario() {}

    /**
     * <b>Constructor con parametros, la funcion priencipal es cargar los datos
     * des la entidad persistente.</b>
     *
     * @param id
     * @param apellidos
     * @param ciudad
     * @param direccion
     * @param dni
     * @param email
     * @param movil
     * @param nombres
     * @param pais
     * @param telPrincipal
     */
    public DatosUsuario(long id, String apellidos, String ciudad, String direccion, String dni,
                        String email, String movil, String nombres, String pais, String telPrincipal) {
        super();
        this.id = id;
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dni = dni;
        this.email = email;
        this.movil = movil;
        this.nombres = nombres;
        this.pais = pais;
        this.telPrincipal = telPrincipal;
    }

    /**
     * <b>Constructor con parametros para cargar datos desde el objeto VO.</b>
     *
     * @param apellidos
     * @param ciudad
     * @param direccion
     * @param dni
     * @param email
     * @param movil
     * @param nombres
     * @param pais
     * @param telPrincipal
     */
    public DatosUsuario(String apellidos, String ciudad, String direccion, String dni, String email, String movil,
                        String nombres, String pais, String telPrincipal) {
        super();
        this.apellidos = apellidos;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.dni = dni;
        this.email = email;
        this.movil = movil;
        this.nombres = nombres;
        this.pais = pais;
        this.telPrincipal = telPrincipal;
        //this.tourRolesUsuarios = tourRolesUsuarios;
    }

    public void setId(String usuarioId) {
        this.id = id;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getMovil() {
        return this.movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelPrincipal() {
        return this.telPrincipal;
    }

    public void setTelPrincipal(String telPrincipal) {
        this.telPrincipal = telPrincipal;
    }

    @Override
    public String toString() {
        return "DatosUsuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", direccion='" + direccion + '\'' +
                ", email='" + email + '\'' +
                ", movil='" + movil + '\'' +
                ", pais='" + pais + '\'' +
                ", telPrincipal='" + telPrincipal + '\'' +
                '}';
    }
}

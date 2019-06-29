package net.mrsistemas.iot.facade.dto;

public class DataUser {
    private long id;
    private String apellidos;
    private String ciudad;
    private String direccion;
    private String dni;
    private String email;
    private String movil;
    private String nombres;
    private String pais;
    private String telPrincipal;

    public DataUser(Builder builder) {
        this.id = builder.id;
        this.apellidos = builder.apellidos;
        this.ciudad = builder.ciudad;
        this.direccion = builder.direccion;
        this.dni = builder.dni;
        this.email = builder.email;
        this.movil = builder.movil;
        this.nombres = builder.nombres;
        this.pais = builder.pais;
        this.telPrincipal = builder.telPrincipal;

    }

    public long getId() {
        return id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getMovil() {
        return movil;
    }

    public String getNombres() {
        return nombres;
    }

    public String getPais() {
        return pais;
    }

    public String getTelPrincipal() {
        return telPrincipal;
    }

    public static class Builder {
        private long id;
        private String apellidos;
        private String ciudad;
        private String direccion;
        private String dni;
        private String email;
        private String movil;
        private String nombres;
        private String pais;
        private String telPrincipal;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setApellidos(String apellidos) {
            this.apellidos = apellidos;
            return this;
        }

        public Builder setCiudad(String ciudad) {
            this.ciudad = ciudad;
            return this;
        }

        public Builder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Builder setDni(String dni) {
            this.dni = dni;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMovil(String movil) {
            this.movil = movil;
            return this;
        }

        public Builder setNombres(String nombres) {
            this.nombres = nombres;
            return this;
        }

        public Builder setPais(String pais) {
            this.pais = pais;
            return this;
        }

        public Builder setTelPrincipal(String telPrincipal) {
            this.telPrincipal = telPrincipal;
            return this;
        }

        public DataUser build() {
            return new DataUser(this);
        }
    }


}

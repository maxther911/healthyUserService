package net.mrsistemas.iot.facade.dto;

import java.util.Date;
import java.util.List;

public class Role {

    private String rolId;

    private String codigo;

    private String descripcion;

    private String estado;

    private Date fechaActualizacion;

    private Date fechaCreacion;

    private String nombre;

    private String usuario;

    private List<RolesUsuario> tourRolesUsuarios;

    public String getRolId() {
        return rolId;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public List<RolesUsuario> getTourRolesUsuarios() {
        return tourRolesUsuarios;
    }

    static class Builder {
        private String rolId;
        private String codigo;
        private String descripcion;
        private String estado;
        private Date fechaActualizacion;
        private Date fechaCreacion;
        private String nombre;
        private String usuario;
        private List<RolesUsuario> tourRolesUsuarios;

        public Builder setRolId(String rolId) {
            this.rolId = rolId;
            return this;
        }

        public Builder setCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder setDescripcion(String descripcion) {
            this.descripcion = descripcion;
            return this;
        }

        public Builder setEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public Builder setFechaActualizacion(Date fechaActualizacion) {
            this.fechaActualizacion = fechaActualizacion;
            return this;
        }

        public Builder setFechaCreacion(Date fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Builder setNombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder setUsuario(String usuario) {
            this.usuario = usuario;
            return this;
        }

        public Builder setTourRolesUsuarios(List<RolesUsuario> tourRolesUsuarios) {
            this.tourRolesUsuarios = tourRolesUsuarios;
            return this;
        }

        public Builder build() {
            return this;
        }

    }

}

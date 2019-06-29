package net.mrsistemas.iot.facade.transform;

import net.mrsistemas.iot.business.persistence.entities.Users;
import net.mrsistemas.iot.facade.dto.DataUser;
import net.mrsistemas.iot.facade.dto.User;
import org.springframework.stereotype.Component;

@Component(value = "mapperUsers")
public class FacadeToBussiness {

    public Users getUsers(User user) {
        return new Users.Builder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .build();
    }

    public User getUsers(Users user) {
        System.out.println("Usuario Vale : " + user);
        return new User.Builder()
                .setId(user.getId())
                .setUsername(user.getUsername())
                .setEmail(user.getEmail())
                .setData(user.getDatosUsuario() == null ? null : new DataUser.Builder()
                        .setNombres(user.getDatosUsuario().getNombres())
                        .setApellidos(user.getDatosUsuario().getApellidos())
                        .setCiudad(user.getDatosUsuario().getCiudad())
                        .setDireccion(user.getDatosUsuario().getDireccion())
                        .setDni(user.getDatosUsuario().getDni())
                        .setMovil(user.getDatosUsuario().getMovil())
                        .setTelPrincipal(user.getDatosUsuario().getTelPrincipal()).build()
                ).build();
    }

}

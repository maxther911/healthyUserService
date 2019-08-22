package net.mrsistemas.iot.facade.controllers;

import net.mrsistemas.iot.business.persistence.entities.Users;
import net.mrsistemas.iot.business.persistence.service.DataUsersService;
import net.mrsistemas.iot.facade.dto.Greeting;
import net.mrsistemas.iot.facade.dto.User;
import net.mrsistemas.iot.facade.transform.FacadeToBussiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@RequestMapping("/users")
public class UsersControllers {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    DataUsersService uService;


    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('read')")
    @GetMapping(value = "/getUsers")
    public List<User> getUsers() {
        List<User> lista = new ArrayList<>();
        for (Users users : uService.findAllUsers()) {
            lista.add(new FacadeToBussiness().getUsers(users));
        }
        return lista;
    }

    /* @PreAuthorize("#oauth2.hasScope('foo') and #oauth2.hasScope('read')")
     @RequestMapping(value = "/getDataUsers", method = RequestMethod.GET)
     public List<DatosUsuario> getDataUsers() {
         return users.getAllDataUsers();
     }
 */
    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "/extra")
    @ResponseBody
    public Map<String, Object> getExtraInfo(Authentication auth) {
        OAuth2AuthenticationDetails oauthDetails = (OAuth2AuthenticationDetails) auth.getDetails();
        Map<String, Object> details = (Map<String, Object>) oauthDetails.getDecodedDetails();
        return details;
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping(value = "/id/{id}")
    @ResponseBody
    public ResponseEntity<User> getInfoUser(@PathVariable(value = "id") long id) {
        System.out.println("Entrada: " + id);
        return new ResponseEntity<User>(new FacadeToBussiness().getUsers(uService.findOne(id).get()), HttpStatus.OK);
    }

}

package net.mrsistemas.healthy.facade.controllers;

import io.swagger.annotations.Api;
import net.mrsistemas.healthy.business.persistence.entities.Users;
import net.mrsistemas.healthy.business.persistence.service.DataUsersService;
import net.mrsistemas.healthy.facade.dto.Greeting;
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
@Api(value = "Api for data operations users.", tags = "User Operations Authenticated")
public class UsersController {

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
    public List<Users> getUsers() {
        List<Users> lista = new ArrayList<>();
        for (Users users : uService.findAllUsers()) {
            lista.add(users);
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
    public ResponseEntity<Users> getInfoUser(@PathVariable(value = "id") long id) {
        return new ResponseEntity<Users>(uService.findOne(id).get(), HttpStatus.OK);
    }

}

package net.mrsistemas.healthy.facade.controllers;

import io.swagger.annotations.*;
import net.mrsistemas.healthy.business.persistence.entities.DataUser;
import net.mrsistemas.healthy.business.persistence.entities.Users;
import net.mrsistemas.healthy.business.persistence.service.DataUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "NonUsers",  tags = "No users API ")
@RequestMapping("/NonUser")
public class NonUserController {

    DataUsersService userOperations;

    @Autowired
    PasswordEncoder passwordEncoder;

    @ApiOperation("Crear un usuario en el sistema de gestion de usuarios y claves.")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "INVALID REQUEST"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND")})
    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity<DataUser> create(@RequestBody(required = true) DataUser data){
        data = userOperations.create(data);
        if (data == null)
            return new ResponseEntity<DataUser>(new DataUser(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<DataUser>(data, HttpStatus.OK);
    }

    @ApiOperation("Crear los datos de session de los usuarios a registrar.")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "INVALID REQUEST"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENTO NOT FOUND")})
    @PostMapping(value = "/save")
    @ResponseBody
    public ResponseEntity<Users> create(@RequestBody(required = true) Users data){
        if(data != null && data.getPassword() != null){
            data.setPassword(new StringBuilder("#{bcript}").append(passwordEncoder.encode(data.getPassword())).toString());
        }
        data = userOperations.create(data);
        if (data == null)
            return new ResponseEntity<Users>(new Users(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Users>(data, HttpStatus.OK);
    }
}

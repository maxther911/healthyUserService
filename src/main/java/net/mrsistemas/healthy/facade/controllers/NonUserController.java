package net.mrsistemas.healthy.facade.controllers;

import io.swagger.annotations.*;
import net.mrsistemas.healthy.business.persistence.entities.Users;
import net.mrsistemas.healthy.business.persistence.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "NonUsers",  tags = "Users Creation operations ")
@RequestMapping("/NonUser")
public class NonUserController {

    @Autowired
    UsersService userOperations;

    @Autowired
    PasswordEncoder passwordEncoder;

    @ApiOperation("Crear los datos de session de los usuarios a registrar.")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "INTERNAL ERROR SERVER"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "INVALID REQUEST"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENT NOT FOUND")})
    @PostMapping(value = "/save")
    @ResponseBody
    public ResponseEntity<Users> create(@RequestBody(required = true) Users data){
        if(data != null && data.getPassword() != null){
            data.setPassword(passwordEncoder.encode(data.getPassword()));
        }
        data = userOperations.create(data);
        if (data == null)
            return new ResponseEntity<Users>(new Users(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Users>(data, HttpStatus.OK);
    }
}

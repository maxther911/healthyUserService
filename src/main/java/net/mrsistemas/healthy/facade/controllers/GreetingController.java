package net.mrsistemas.healthy.facade.controllers;


import io.swagger.annotations.*;
import net.mrsistemas.healthy.facade.dto.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;


@RestController
@Api(value = "Api for test the functionaly of micro services.", tags = "Greetings")
@RequestMapping("/greetings")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @ApiOperation(value = "Reporta y registra los datos de un sensor en la base de datos con estructura no sql."
                  , tags = "Greetings")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
            @ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "ELEMENT NOT FOUND")})
    @GetMapping(value = "/greeting")
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new ResponseEntity<>(new Greeting(counter.incrementAndGet(), String.format(template, name)), HttpStatus.OK);
    }

}

package net.mrsistemas.healthy.facade.controllers;

import io.swagger.annotations.Api;
import net.mrsistemas.healthy.business.persistence.entities.Country;
import net.mrsistemas.healthy.business.persistence.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Set;

@RestController
@Api(value = "Api for the get out the countries.", tags = "Countries")
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(value = "/getCountryByName/{name}")
    @ResponseBody
    public Set<Country> getCountryByNameLike(@PathVariable String name){
        return countryRepository.getCountriesByNameStartingWith(name.toUpperCase());
    }
}

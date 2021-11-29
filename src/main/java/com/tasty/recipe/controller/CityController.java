package com.tasty.recipe.controller;

import com.tasty.recipe.entity.City;
import com.tasty.recipe.entity.Recipe;
import com.tasty.recipe.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/findCity")
    public City searchCity(@RequestParam int id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        if (cityOptional.isPresent()) {
            return cityOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping("/findByName")
    public List<City> findByName(@RequestParam String name) {
        List<City> cityList = cityRepository.findByName(name);
        return cityList;
    }

    @PostMapping(
        value = "/createCity", consumes = "application/json", produces = "application/json")
        public City createCity(@RequestBody City city) {
            return cityRepository.save(city);
    }
}

package example.controllers;

import example.connection.mysqlentitymodel.City;
import example.connection.mysqlentitymodel.CityRepository;
import example.exceptions.StateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/city")
public class CityController {
    @Autowired
    private CityRepository CityRepository;

    @PostMapping
    public Iterable<City> addCity(@RequestBody Iterable<City> City) {
        return CityRepository.saveAll(City);
    }

    @GetMapping
    public Iterable<City> getAllCities() {
        return CityRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public Optional<City> getCityByID(@PathVariable Integer id) {
        Optional<City> City = CityRepository.findById(id);

        try {
            City.get();
        } catch (Exception e) {
            throw new StateNotFoundException();
        }

        return City;
    }

    @PutMapping
    public City updateCity(@RequestBody City City) {
        if (City.getID() == null)
            throw new StateNotFoundException();
        return CityRepository.save(City);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteCity(@PathVariable Integer id) {
        CityRepository.deleteById(id);

        return "City Deleted Successfully!!";
    }
}
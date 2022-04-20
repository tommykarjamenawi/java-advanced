package nl.inholland.carapi.controller;

import nl.inholland.carapi.model.Car;
import nl.inholland.carapi.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // get all cars
    @RequestMapping(method = RequestMethod.GET, value = "all")
    public ResponseEntity getCars() {
        return ResponseEntity.status(200).body(carService.getAllCars());
    }

    // add a car
    @RequestMapping(method = RequestMethod.POST, value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addCar(@RequestBody Car car) {
        try {
            Car newCar = carService.addCar(car);
            return ResponseEntity.status(201).body(newCar);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.singletonMap("Message", e.getMessage()));
        }
    }

    // get a car by id
    @GetMapping("get/{id}")
    public ResponseEntity getCarById(@PathVariable int id) {
        try {
            return ResponseEntity.status(200).body(carService.getCarById(id));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.singletonMap("Message", e.getMessage()));
        }
    }

    // update a car
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity updateLocation(@RequestBody Car car) {
        try {
            return ResponseEntity.status(200).body(carService.updateCarById(car));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.singletonMap("Message", e.getMessage()));
        }
    }

    // delete a car by id
    @DeleteMapping("delete")
    public ResponseEntity deleteCar(@PathVariable Long id) {
        try {
            carService.deleteCarById(id);
            return ResponseEntity.status(200).body(Collections.singletonMap("Message", "Car deleted"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Collections.singletonMap("Message", e.getMessage()));
        }
    }
}

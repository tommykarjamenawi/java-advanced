package nl.inholland.carAPI.controller;


import nl.inholland.carAPI.model.Car;
import nl.inholland.carAPI.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "hello test";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllCars() {
        List<Car> cars = carService.getAllCars();
        return ResponseEntity.status(200).body(cars);
    }

    @GetMapping("/cars2")
    public List<Car> getAllCars2() {
        return carService.getAllCars();
    }


    @PostMapping(value = "/cars", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    // add new car
    @PostMapping(value = "/addCar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car addCar2(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity getCarById(@PathVariable int id) {
        Car car = carService.getCarById(id);
        return ResponseEntity.status(200).body(car);
    }

    // delete car by id (new method)
//    @DeleteMapping("/deleteCar/{id}")
//    public ResponseEntity deleteCar(@PathVariable int id) {
//        carService.deleteCarById(id);
//        return ResponseEntity.status(200).body("Car with id " + id + " has been deleted");
//    }

    // delete car by id (old method)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable int id) {
        carService.deleteCarById(id);
    }

    // update car (new method)
//    @PutMapping(value = "/updateCar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public Car updateCar(@PathVariable int id, @RequestBody Car car) {
//        return carService.updateCar(id, car);
//    }

    // update car (old method)
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public void updateLocation(@RequestBody Car car, @PathVariable String id) {
        carService.updateCarById(Integer.parseInt(id), car);
    }
}

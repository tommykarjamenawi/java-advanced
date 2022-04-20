package nl.inholland.carapi.controller;

import nl.inholland.carapi.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "other", produces = MediaType.APPLICATION_JSON_VALUE)
public class OtherController {

    private CarService otherService;

    public OtherController(CarService otherService) {
        this.otherService = otherService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(otherService.getAllCars());
    }
}
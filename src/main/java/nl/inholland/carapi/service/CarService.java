package nl.inholland.carapi.service;

import nl.inholland.carapi.model.Car;
import nl.inholland.carapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;



    public Iterable<Car> getAllCars(){
        return carRepository.findAll();
    }


    // adds a car
    public Car addCar(Car car){
        return carRepository.save(car);
    }

    // deletes a car by id
    public void deleteCarById(Long id){
        carRepository.deleteById(id);
    }

    // updates a car by id
    public Car updateCarById(Car car){
        return carRepository.save(car);
    }

    // get a car by id
    public Optional<Car> getCarById(long id){
        return carRepository.findById(id);
    }



}

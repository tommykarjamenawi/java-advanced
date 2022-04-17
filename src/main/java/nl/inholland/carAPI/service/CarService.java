package nl.inholland.carAPI.service;


import nl.inholland.carAPI.model.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private List<Car> cars = new ArrayList<>();

    public CarService() {
        cars.add(new Car(1, "Ferrari", "F40", 200000, 1988));
        cars.add(new Car(2, "Porsche", "Panerama", 100000, 2018));
        cars.add(new Car(3, "Lamborghini", "A80", 30000, 1988));
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public Car addCar(Car car) {
        cars.add(car);
        return car;
    }

    // get car by id
    public Car getCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    // delete car by id
    public void deleteCarById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                cars.remove(car);
            }
        }
    }

    // update car by id
    public void updateCarById(int id, Car car) {
        for (Car c : cars) {
            if (c.getId() == id) {
                c.setBrand(car.getBrand());
                c.setModel(car.getModel());
                c.setPrice(car.getPrice());
                c.setYear(car.getYear());
            }
        }
    }
}

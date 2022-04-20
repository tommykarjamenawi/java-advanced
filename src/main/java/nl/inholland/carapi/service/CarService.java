package nl.inholland.carapi.service;

import nl.inholland.carapi.model.Car;
import nl.inholland.carapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
    private List<Car> cars;

    public CarService(List<Car> cars) {
        this.cars = cars;
    }

    // returns all cars
    public List<Car> getAllCars() {
        return cars;
    }

    // adds a car
    public Car addCar(Car car) {
        Car newCar;
        try {
            newCar = new Car(car.getId(), car.getBrand(), car.getModel(), car.getPrice(), car.getYear());
            cars.add(newCar);
        } catch (Exception e) {
            throw new IllegalArgumentException("Car not added");
        }
        return car;
    }

    // get car by id
    public Car getCarById(int id) {
        try {
            for (Car car : cars) {
                if (car.getId() == id) {
                    return car;
                }
            }
            return null;
        } catch (Exception e) {
            throw new IllegalArgumentException("Car not found");
        }
    }

    public Car updateCarById(int id, Car car) {
        try {
            for (Car c : cars) {
                if (c.getId() == id) {
                    c.setBrand(car.getBrand());
                    c.setModel(car.getModel());
                    c.setPrice(car.getPrice());
                    c.setYear(car.getYear());
                    return c;
                }
            }
            return null;
        } catch (Exception e) {
            throw new IllegalArgumentException("Car not updated");
        }
    }

    // delete car by id
    public void deleteCarById(int id) {
            for (Car car : cars) {
                if (car.getId() == id) {
                    cars.remove(car);
                    return;
                }
            }
    }
}

package nl.inholland.carapi.config;

import nl.inholland.carapi.model.Car;
import nl.inholland.carapi.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private CarRepository carRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Car> cars = List.of(
                new Car(1, "Ferrari", "F40", 200000, 1988 ),
                new Car(2, "Tesla", "S", 80000, 2020 ),
                new Car(3, "Volvo", "vs34", 40000, 2009 ),
                new Car(4, "Fiat", "F3", 20000, 2012 ),
                new Car(5, "Toyota", "T50", 30000, 2015 )
        );

        //cars.forEach(carRepository::save);
        carRepository.saveAll(cars);


    }
}

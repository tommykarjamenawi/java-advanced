package nl.inholland.carapi.config;

import nl.inholland.carapi.model.Car;
import nl.inholland.carapi.model.Customer;
import nl.inholland.carapi.repository.CarRepository;
import nl.inholland.carapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Car> cars = List.of(
                new Car(1, "Ferrari", "F40", 200000, 1988 ),
                new Car(2, "Tesla", "S", 80000, 2020 ),
                new Car(3, "Volvo", "vs34", 40000, 2009 ),
                new Car(4, "Fiat", "F3", 20000, 2012 ),
                new Car(5, "Toyota", "T50", 30000, 2015 )
        );

        //cars.forEach(carRepository::save); // save all cars in the list to the database one by one
        carRepository.saveAll(cars);

//        List<Customer> customers = List.of(
//                new Customer("Tommy King", "tommy@inholland.nl", new Car(1, "Ferrari", "F40", 200000, 1988 )),
//                new Customer("Tony Stark", "tony@inholland.nl", new Car(2, "Tesla", "S", 80000, 2020 )),
//                new Customer("Ronald Stieger", "ronald@inholland.nl", new Car(3, "Volvo", "vs34", 40000, 2009 )),
//                new Customer("James Bond", "james@inholland.nl", new Car(4, "Fiat", "F3", 20000, 2012 )),
//                new Customer("Kim Delilah", "kim@inholland.nl", new Car(5, "Toyota", "T50", 30000, 2015 ))
//        );
//        customerRepository.saveAll(customers);

        customerRepository.findAll().forEach(
                customer -> customerRepository.save(new Customer(customer))
        );
    }
}

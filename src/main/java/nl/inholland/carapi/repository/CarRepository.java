package nl.inholland.carapi.repository;

import nl.inholland.carapi.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
}

package nl.inholland.carapi.repository;

import nl.inholland.carapi.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}

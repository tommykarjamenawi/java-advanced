package nl.inholland.carapi.service;

import nl.inholland.carapi.model.Customer;
import nl.inholland.carapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    // adds a customer
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    // deletes a customer by id
    public void deleteCustomerById(Long id){
        customerRepository.deleteById(id);
    }

    // updates a customer by id
    public Customer updateCustomerById(Customer customer){
        return customerRepository.save(customer);
    }

    // get a customer by id
    public Optional<Customer> getCustomerById(long id){
        return customerRepository.findById(id);
    }
}

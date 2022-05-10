package nl.inholland.carapi.controller;

import nl.inholland.carapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping
    public ResponseEntity allCustomers() {
        return ResponseEntity.ok().body(customerService.getAllCustomers());
    }
}

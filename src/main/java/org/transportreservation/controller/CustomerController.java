package org.transportreservation.controller;

import org.springframework.web.bind.annotation.*;
import org.transportreservation.model.Customer;
import org.transportreservation.service.CustomerService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) throws SQLException {
        return customerService.insertCustomer(customer);
    }

    @GetMapping("/customers")
    public List<Customer> findAllCustomer() throws SQLException {
        return customerService.getAll();
    }

    @GetMapping("/customers/search/")
    public List<Customer> findCustomerByName(@RequestParam(name = "name") String name) throws SQLException {
        return customerService.getByName(name);
    }

    @GetMapping("/customers/search/{id}")
    public Customer findCustomerById(@PathVariable int id) throws SQLException {
        return customerService.getById(id);
    }

    @PatchMapping("/customers/edit/{id}")
    public Customer updateCustomerUsername(@PathVariable int id, @RequestBody String username) throws SQLException {
        return customerService.updateUsernameById(id, username);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomerById(@PathVariable int id) throws SQLException {
        customerService.deleteById(id);
    }

}

package com.halilkrkn.controller;

import com.halilkrkn.data.CustomerRepository;
import com.halilkrkn.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    
    private final CustomerRepository customerRepository;

    // Örneğin
    // http://localhost:8080/api/v1/customers
    // adresine gidilirse, aşağıdaki metot çalışır.
    @GetMapping
    public List<Customer> getCustomers() {
//        Customer customerJohn = new Customer(1, "John", "john@gmail.com", 42);
//        Customer customerSara= new Customer(2, "Sara", "sara@gmail.com", 24);
//
//        customerRepository.save(customerJohn);
//        customerRepository.save(customerSara);

        return customerRepository.findAll();
    }

    record NewCustomerRequest(
            String name,
            String email,
            Integer age
    ) {
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());

        Customer savedCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Integer id) {
        customerRepository.deleteById(id);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Integer id,
            @RequestBody NewCustomerRequest request) {

        Optional<Customer> optionalCustomer = customerRepository.findById(id);

        if (optionalCustomer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Customer existingUser = optionalCustomer.get();
        existingUser.setName(request.name());
        existingUser.setEmail(request.email);
        existingUser.setAge(request.age);
        // Diğer alanları güncelleme işlemleri

        Customer savedUser = customerRepository.save(existingUser);
        return ResponseEntity.ok(savedUser);
    }
}

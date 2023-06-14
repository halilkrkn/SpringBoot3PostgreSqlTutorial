package com.halilkrkn.data;

import com.halilkrkn.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository  extends JpaRepository<Customer, Integer> {



}

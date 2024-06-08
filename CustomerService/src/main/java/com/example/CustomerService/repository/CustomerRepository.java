package com.example.CustomerService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.CustomerService.entity.CustomerEntity;

@Repository
@EnableJpaRepositories
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {


}

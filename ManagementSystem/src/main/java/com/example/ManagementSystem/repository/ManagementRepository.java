package com.example.ManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ManagementSystem.Entity.ManagementEntity;

@Repository
public interface ManagementRepository extends JpaRepository<ManagementEntity,Integer>{

}

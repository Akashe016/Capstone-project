package com.example.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.example.SpringBoot.entity.ReportEntity;

@Repository
@EnableJpaRepositories
public interface ReportRepository extends JpaRepository<ReportEntity, Integer>{

}

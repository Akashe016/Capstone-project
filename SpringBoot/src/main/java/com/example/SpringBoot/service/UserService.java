package com.example.SpringBoot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.SpringBoot.entity.ReportEntity;
import com.example.SpringBoot.repository.ReportRepository;

@Service
public class UserService {

	@Autowired
	ReportRepository reportRepository;


	
	public String getCustomerDetails() {
		
		System.out.println("Inside customer service");
		return "HDFC Customer";
	}

	
	public ReportEntity reportCreate(ReportEntity entity) {
		
		return reportRepository.save(entity);
	}
	
	public ReportEntity reportUpdate(ReportEntity entity) {
			
		entity.setId(entity.getId());
		entity.setName(entity.getName());
		entity.setAge(entity.getAge());
		entity.setCity(entity.getCity());
		
		return reportRepository.save(entity);
	}
	
	public Optional<ReportEntity> reportGet(int id) {
		
		return reportRepository.findById(id);
	}
	
	public String reportDelete(int id) {
		
		reportRepository.deleteById(id);

		return "Delete successfully";
	}
}

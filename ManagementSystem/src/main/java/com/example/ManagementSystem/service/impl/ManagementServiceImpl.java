package com.example.ManagementSystem.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ManagementSystem.Entity.ManagementEntity;
import com.example.ManagementSystem.repository.ManagementRepository;
import com.example.ManagementSystem.service.ManagementService;

@Service
public class ManagementServiceImpl  implements ManagementService{
	

	@Autowired
	ManagementRepository managementRepository;
	
	
	@Override
	public ManagementEntity create(ManagementEntity entity) {
		// TODO Auto-generated method stub
		
		return managementRepository.save(entity);
	}

	@Override
	public ManagementEntity update(ManagementEntity entity) {
		// TODO Auto-generated method stub
		
		entity.setId(entity.getId());
		
		return managementRepository.save(entity);
	}

	@Override
	public List<ManagementEntity> getAll() {
		// TODO Auto-generated method stub
		
		return managementRepository.findAll();
	}

	@Override
	public ManagementEntity getByIdMethod(int id) {
		// TODO Auto-generated method stub
		
		return managementRepository.findById(id).orElse(null);
	}

	@Override
	public String deleteIdMethod(int id) {
		// TODO Auto-generated method stub
		
		 managementRepository.deleteById(id);
		 
		 return "Delete successfully";
	}
}

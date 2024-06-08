package com.example.ManagementSystem.service;

import java.util.List;
import com.example.ManagementSystem.Entity.ManagementEntity;

public interface ManagementService {

	
	public ManagementEntity create(ManagementEntity entity);
	public ManagementEntity update(ManagementEntity entity);
	public List<ManagementEntity> getAll();
	public ManagementEntity getByIdMethod(int id);
	public String deleteIdMethod(int id);
}

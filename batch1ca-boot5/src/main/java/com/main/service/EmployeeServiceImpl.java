package com.main.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.main.dao.EmployeeRepository;
import com.main.dto.EmployeeDTO;
import com.main.entity.EmployeeEntity;

@Service //annotation for service
@Transactional //annotation for whole transaction
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository; //Dao in controller


	public List<EmployeeDTO> FetchAllEmployees() { //unimplemented method from controller

		List<EmployeeEntity> entityList=employeeRepository.findAll(); 
		List<EmployeeDTO> dtoList=new ArrayList<>();//blank list
		for(  EmployeeEntity entity: entityList){

			EmployeeDTO dto=new EmployeeDTO();//blank object
			BeanUtils.copyProperties(entity, dto);
			dtoList.add(dto);

		}

		return dtoList;
	}


	@Override
	public void save(EmployeeDTO empDTO) { 

		EmployeeEntity employeeEntity=new EmployeeEntity();
		BeanUtils.copyProperties(empDTO, employeeEntity);
		employeeRepository.save(employeeEntity);
	}


	@Override
	public EmployeeDTO authenticate(String email, String password) {

		System.out.println("from service.......");
		Optional<EmployeeEntity> optional=employeeRepository.findByEmailIdAndPassword(email, password);

		EmployeeDTO employeeDTO = null;
		if(optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeeDTO = new EmployeeDTO();
			BeanUtils.copyProperties(employeeEntity, employeeDTO);
		}

		return employeeDTO;
	}
}

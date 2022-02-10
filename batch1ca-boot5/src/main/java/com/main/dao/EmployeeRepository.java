package com.main.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {

	Optional<EmployeeEntity> findByEmailIdAndPassword(String email, String password);
//=======
	

}

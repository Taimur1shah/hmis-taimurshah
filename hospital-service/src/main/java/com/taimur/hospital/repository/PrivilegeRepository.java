package com.taimur.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taimur.hospital.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Integer>{
	
	   Privilege findByName(String name);

	    @Override
	    void delete(Privilege privilege);

}

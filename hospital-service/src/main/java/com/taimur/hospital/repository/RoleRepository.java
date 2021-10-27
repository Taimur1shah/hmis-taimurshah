package com.taimur.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taimur.hospital.entity.Role;

/**
 * @author Taimur Shah
 * @since October 23, 2021
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Role findByName(String name);

    @Override
    void delete(Role role);

}

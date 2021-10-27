package com.taimur.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taimur.hospital.entity.Doctor;

/**
 * @author Taimur Shah
 * @since October 23, 2021
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}

package com.taimur.hospital.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.taimur.hospital.enums.Enums.DoctorType;
import com.taimur.hospital.enums.Enums.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Doctor extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=256,nullable=false)
	private String name;
	
	@Column(length=256,nullable=false)
	private String email;
	
	private Integer age;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('MALE','FEMALE') COMMENT 'Gender is male or female'", nullable = false)
	private Gender gender;
	
	@Column(length=256,nullable=false)
	private String address;
	
	@Column(length=256,nullable=false)
	private String mobile;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('REGULAR' , 'CALL_ON') COMMENT 'Doctor availability'", nullable = false)
	private DoctorType doctorType;

	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "departmentId", nullable = true)
	private Department department;

}

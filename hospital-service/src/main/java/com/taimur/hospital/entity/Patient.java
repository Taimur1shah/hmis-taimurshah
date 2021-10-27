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
import javax.persistence.OneToOne;

import com.taimur.hospital.enums.Enums.Gender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Taimur Shah
 * @since October 27, 2021
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Patient extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mrNumber;

	@Column(length=256,nullable=false)
	private String name;
	
	@Column(length=256,nullable=false)
	private String address;
	
	@Column(length=256,nullable=false)
	private String phone;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('MALE','FEMALE') COMMENT 'Gender is male or female'", nullable = false)
	private Gender gender;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "dcotorId", nullable = true)
	private Doctor doctor;
	

}

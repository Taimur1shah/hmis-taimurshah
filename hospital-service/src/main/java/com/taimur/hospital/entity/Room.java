package com.taimur.hospital.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.taimur.hospital.enums.Enums.RoomStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Room extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2319951205684054848L;
	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String roomNumber;
	
	private String roomType;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Available','BOOKED') COMMENT 'Available status means it is avalaible for booking'", nullable = false)
	private RoomStatus status;


}

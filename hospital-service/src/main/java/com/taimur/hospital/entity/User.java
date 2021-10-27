package com.taimur.hospital.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "User", uniqueConstraints = { @UniqueConstraint(name = "UC_Email", columnNames = { "email" }) })
public class User extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5710112885713313949L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=256,nullable=false)
	private String firstName;
	
	@Column(length=256,nullable=false)
	private String lastName;
	
	@Column(length=256,nullable=false)
	private String email;
	
	 @Column(length = 60,nullable=false)
	 private String password;
	
	@Column(length=256)
	private String phone;
	
	@Column(length=256)
	private String address;
	
	@Column(columnDefinition="tinyint(1) default 0")
	private Boolean enable;
	
	  @ManyToMany 
	    @JoinTable(
	        name = "users_roles", 
	        joinColumns = @JoinColumn(
	          name = "user_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "id")) 
	    private Collection<Role> roles;

}

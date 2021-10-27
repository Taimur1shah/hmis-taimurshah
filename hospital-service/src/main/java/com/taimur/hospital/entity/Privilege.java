package com.taimur.hospital.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Privilege extends BaseEntity {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Privilege() {
	
	}
	
	public Privilege(String name) {
		super();
		this.name = name;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


	@Column(length=50,nullable=false)
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;
    
 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
}

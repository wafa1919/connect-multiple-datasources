package com.everis.monitor.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Subselect;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
//@Subselect(
//	    "SELECT * FROM user"
//	)
public class User extends Auditable<String> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	protected Long id;
	@Column(unique = true)
	protected String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	protected String password;
	
	@Email
	protected String email;
	
	protected String firstname;
	protected String lastname;
	protected String gender;
	
	
	protected boolean enabled;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable()
	protected Collection<Role> roles = new HashSet<Role>();
	
	public User(User user) {
		super();
		this.enabled = user.isEnabled();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.roles = user.getRoles();
		this.id = user.getId();
	}

	public User(String username, String password, boolean enabled) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, @Email String email, boolean enabled, Collection<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.roles = roles;
	}
	
	
	
	
}
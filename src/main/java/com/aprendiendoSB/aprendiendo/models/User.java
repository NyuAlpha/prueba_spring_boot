package com.aprendiendoSB.aprendiendo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@ToString @EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter @Setter @Column(name="id")
	private long id;
	
	@Getter @Setter @Column(name="name")
	private String name;
	
	@Getter @Setter @Column(name="surname")
	private String surname;
	
	@Getter @Setter @Column(name="email")
	private String email;
	
	@Getter @Setter @Column(name="tel")
	private String tel;
	
	@Getter @Setter @Column(name="password")
	private String password;
	
	
	
}

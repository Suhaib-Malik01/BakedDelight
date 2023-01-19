package com.masai.model;

import javax.persistence.MappedSuperclass;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Setter
@Getter
@ToString
public class User {
	
	private String username;
	private String password;
	private String role;
	
	
}

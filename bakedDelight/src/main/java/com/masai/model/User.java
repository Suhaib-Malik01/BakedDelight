package com.masai.model;

<<<<<<< HEAD
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private String username;
	private String password;
	private String role;
	
=======
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private String Username;
	private String Password;
	private String Role; 
>>>>>>> 454c288985d26fa3a9cd77a423ab5f91e6d6cac2
}

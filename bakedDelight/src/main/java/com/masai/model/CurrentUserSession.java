package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
public class CurrentUserSession extends User {
=======
public class CurrentUserSession extends User{
>>>>>>> 454c288985d26fa3a9cd77a423ab5f91e6d6cac2
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true)
	private Integer userId;
	private String uuid;
	private LocalDateTime localDateTime;

	public CurrentUserSession(Integer customerId, String key, LocalDateTime now, String username, String password,
			String role) {
		// TODO Auto-generated constructor stub
		this.userId = customerId;
		this.uuid = key;
		this.localDateTime = now;
		this.setUsername(username);
		this.setPassword(password);
		this.setRole(role);
	}
}
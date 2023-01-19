package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CurrentUserSession extends User {
	
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
	
	@Id
	@Column(unique = true)
	private Integer userId;
	private String uuid;
	private LocalDateTime localDateTime;
	
	
	
}

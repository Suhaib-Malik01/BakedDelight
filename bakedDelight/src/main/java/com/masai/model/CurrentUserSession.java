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
public class CurrentUserSession extends User {
	
	@Id
	private Integer userId;
	private String uuid;
	private LocalDateTime localDateTime;

	public CurrentUserSession(Integer customerId,String key, LocalDateTime now, String username, String password,
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
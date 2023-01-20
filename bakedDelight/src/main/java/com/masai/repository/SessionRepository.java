package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.*;

@Repository
public interface SessionRepository extends JpaRepository<CurrentUserSession, Integer> {
	public CurrentUserSession findByUuid(String uuid);

	public List<CurrentUserSession> findByUserId(Integer userId);
	
	public CurrentUserSession findByUsername(String username);
}

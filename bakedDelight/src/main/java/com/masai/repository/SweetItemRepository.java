package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.SweetItem;

public interface SweetItemRepository extends JpaRepository<SweetItem, Integer> {

}

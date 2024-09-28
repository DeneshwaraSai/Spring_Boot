package com.pharmacy.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharmacy.code.entity.CodeValue;

@Repository
public interface CodeValueRepository extends JpaRepository<CodeValue, Integer> {
	public List<CodeValue> findAll();
}

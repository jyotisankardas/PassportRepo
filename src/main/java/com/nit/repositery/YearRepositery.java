package com.nit.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.YearsEntity;

public interface YearRepositery extends JpaRepository<YearsEntity, Integer> {

	
	@Query(value = "select YEAR from YearsEntity")
	public List<Integer> getYears();
}



package com.nit.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.DegreeEntity;

public interface DegreeRepositery extends JpaRepository<DegreeEntity, Integer> {

	@Query(value = "select DEGREE_NAME from DegreeEntity")
	public List<String> getDegrees();

}

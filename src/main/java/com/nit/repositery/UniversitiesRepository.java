package com.nit.repositery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.UniversityEntity;

public interface UniversitiesRepository extends JpaRepository<UniversityEntity, Integer> {
	
	@Query(value = "select UNIV_NAME from UniversityEntity")
	public List<String> getUniversities();

	
}

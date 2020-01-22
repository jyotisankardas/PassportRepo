package com.nit.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.EducationalDetailsEntity;

@Repository
public interface EducationalRepositery extends JpaRepository<EducationalDetailsEntity, Integer> {

}

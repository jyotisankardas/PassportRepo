package com.nit.repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nit.entity.PassportAppDtlsEntity;

@Repository
public interface PassportAppDetailsRepository extends JpaRepository<PassportAppDtlsEntity, Integer> {

}

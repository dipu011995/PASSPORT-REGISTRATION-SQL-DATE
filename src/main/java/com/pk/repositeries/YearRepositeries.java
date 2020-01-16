package com.pk.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pk.entity.YearsEntity;

public interface YearRepositeries extends JpaRepository<YearsEntity, Integer> {

	
	@Query(value = "select year from YearsEntity" )
	public List<String> findAllpassoutYears();
	
}

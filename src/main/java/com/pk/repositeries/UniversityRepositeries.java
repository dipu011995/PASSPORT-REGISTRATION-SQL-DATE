package com.pk.repositeries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pk.entity.UniversityEntity;

public interface UniversityRepositeries extends JpaRepository<UniversityEntity, Integer> {

	@Query(value = "select univName from UniversityEntity" )
	public List<String> findAllUniversitiesNames();
}

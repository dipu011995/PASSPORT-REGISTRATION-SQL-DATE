package com.pk.repositeries;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pk.entity.PassportAppDetailsEntity;

public interface PassportRepositeries extends JpaRepository<PassportAppDetailsEntity, Integer> {

}

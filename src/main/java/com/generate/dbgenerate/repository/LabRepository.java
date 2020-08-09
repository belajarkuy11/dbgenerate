package com.generate.dbgenerate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.generate.dbgenerate.model.Lab;

public interface LabRepository extends JpaRepository<Lab, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE Lab SET nama=:name WHERE id=:id")
	public Integer updateLaNamebById(@Param("id")Integer id, @Param("name")String name);

	@Transactional
	@Modifying
	@Query("DELETE FROM Lab l WHERE l.id=:id")
	public Integer deleteByIdLab(@Param("id")Integer id);
	
	
}

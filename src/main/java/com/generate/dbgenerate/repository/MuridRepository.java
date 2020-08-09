package com.generate.dbgenerate.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generate.dbgenerate.model.Murid;

public interface MuridRepository extends JpaRepository<Murid, Long> {

	@Query("SELECT m FROM Murid m WHERE m.kela.id=:kelas")
	public Optional<List<Murid>> getMuridByKelas(@Param("kelas")Long kelas);
	
	
	@Query(value = "SELECT * FROM murid m WHERE m.kelas=:kelas", nativeQuery = true)
	public Optional<List<Murid>> getMuridByKelasNative(@Param("kelas")Long kelas);
}

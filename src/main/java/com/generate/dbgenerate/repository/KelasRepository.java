package com.generate.dbgenerate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generate.dbgenerate.model.Kela;

public interface KelasRepository extends JpaRepository<Kela, Long>{

	Optional<Kela> findByNama(String oldNama);

}

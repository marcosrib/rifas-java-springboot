package com.rifas.trevorifas.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rifas.trevorifas.domain.entity.Rifa;

public interface RifaRepository  extends JpaRepository<Rifa, Long>{
  
	@Query(
			  value = "SELECT * FROM rifa  where usuario_id = :id ORDER BY id",
			  countQuery = "SELECT count(*) FROM rifa where usuario_id = :id ",
			  nativeQuery = true)
	Page<Rifa> findAllRifaWithPagination(@Param("id") Integer id, Pageable pageable);
	

}

package com.rifas.trevorifas.adapters.outbound.repositories.Raffles;

import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RaffleRepository extends JpaRepository<RaffleEntity, Long>{
  
	@Query(
			  value = "SELECT * FROM rifa  ORDER BY id",
			  countQuery = "SELECT count(*) FROM rifa ",
			  nativeQuery = true)
	Page<RaffleEntity> findAllRifaWithPagination(Pageable pageable);
	

}

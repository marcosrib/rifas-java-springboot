package com.rifas.trevorifas.adapters.outbound.repositories.points;

import java.util.List;


import com.rifas.trevorifas.adapters.outbound.repositories.entity.PointEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import org.springframework.data.repository.CrudRepository;

public interface PointRepository extends CrudRepository<PointEntity, Long>{

  List<PointEntity> findAllByRaffle(RaffleEntity rifa);
  
}

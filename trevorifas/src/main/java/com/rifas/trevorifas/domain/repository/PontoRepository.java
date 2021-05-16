package com.rifas.trevorifas.domain.repository;

import java.util.List;


import com.rifas.trevorifas.domain.entity.Ponto;
import com.rifas.trevorifas.domain.entity.Rifa;
import org.springframework.data.repository.CrudRepository;

public interface PontoRepository extends CrudRepository<Ponto, Long>{

  List<Ponto> findAllByRifa(Rifa rifa);
  
}

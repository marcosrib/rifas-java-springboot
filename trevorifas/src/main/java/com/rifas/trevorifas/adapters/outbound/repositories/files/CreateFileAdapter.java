package com.rifas.trevorifas.adapters.outbound.repositories.files;

import com.rifas.trevorifas.adapters.outbound.repositories.Raffles.RaffleRepository;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.FileEntity;
import com.rifas.trevorifas.adapters.outbound.repositories.entity.RaffleEntity;
import com.rifas.trevorifas.application.core.domain.File;
import com.rifas.trevorifas.application.ports.out.file.CreateFileAdapterPort;
import com.rifas.trevorifas.exception.RegraNegocioException;
import org.springframework.stereotype.Component;

@Component
public class CreateFileAdapter implements CreateFileAdapterPort {

  private final FileRepository fileRepository;

  private final RaffleRepository raffleRepository;

  public CreateFileAdapter(FileRepository fileRepository, RaffleRepository raffleRepository) {
    this.fileRepository = fileRepository;
    this.raffleRepository = raffleRepository;
  }

  @Override
  public File create(File file) {
    RaffleEntity raffleEntity = raffleRepository.findById(file.getRaffleId())
        .orElseThrow(() -> new RegraNegocioException("Rifa não encontrada"));
    FileEntity fileEntity = fileRepository.save(FileEntity.builder()
        .name(file.getName())
        .raffleEntity(raffleEntity)
        .build());

    return File.builder()
        .id(fileEntity.getId())
        .name(fileEntity.getName())
        .raffleId(
        file.getRaffleId());
  }
}

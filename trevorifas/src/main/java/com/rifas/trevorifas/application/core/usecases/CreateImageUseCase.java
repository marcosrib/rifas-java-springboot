package com.rifas.trevorifas.application.core.usecases;

import com.rifas.trevorifas.application.core.domain.File;
import com.rifas.trevorifas.application.ports.in.images.CreateImageUseCasePort;
import com.rifas.trevorifas.application.ports.out.file.CreateFileAdapterPort;
import com.rifas.trevorifas.application.ports.out.fileStorage.FileAdapterPort;

public class CreateImageUseCase implements CreateImageUseCasePort {

  private final FileAdapterPort saveFileLocalAdapterPort;

  private final CreateFileAdapterPort createFileAdapterPort;
  public CreateImageUseCase(FileAdapterPort saveFileLocalAdapterPort,
                            CreateFileAdapterPort createFileAdapterPort) {
    this.saveFileLocalAdapterPort = saveFileLocalAdapterPort;
    this.createFileAdapterPort = createFileAdapterPort;
  }

  @Override
  public void create(File file) {
    String imageName = saveFileLocalAdapterPort.save(file);
    file.setName(imageName);
    createFileAdapterPort.create(file);

  }
}

package com.rifas.trevorifas.application.ports.in.images;

import com.rifas.trevorifas.application.core.domain.File;
import org.springframework.web.multipart.MultipartFile;

public interface CreateImageUseCasePort {
  void create(File file);
}

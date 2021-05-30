package com.rifas.trevorifas.service.files.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface FileStorageService {
    String salvarArquivos(MultipartFile file);
}

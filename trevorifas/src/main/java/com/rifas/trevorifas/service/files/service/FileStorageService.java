package com.rifas.trevorifas.service.files.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    String salvarArquivos(MultipartFile file);
}

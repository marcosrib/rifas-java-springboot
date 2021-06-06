package com.rifas.trevorifas.service.files.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface FileStorageService {
    String salvarArquivos(MultipartFile file);
    Resource buscarImagem(String nomeImagem);
}

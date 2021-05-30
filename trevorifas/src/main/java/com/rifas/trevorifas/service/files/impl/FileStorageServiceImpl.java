package com.rifas.trevorifas.service.files.impl;

import com.rifas.trevorifas.config.FileStorageConfig;
import com.rifas.trevorifas.exception.ArmazenamentoArquivoException;
import com.rifas.trevorifas.service.files.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageServiceImpl(FileStorageConfig fileStorageConfig) {
        this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();

        try {
            if (!Files.exists(this.fileStorageLocation)) {
                Files.createDirectory(this.fileStorageLocation);
            }
        } catch (Exception ex) {
            throw new ArmazenamentoArquivoException("Erro ao criar  pasta" + ex.getMessage());
        }


    }

    @Override
    public String salvarArquivos(MultipartFile file) {
        String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (nomeArquivo.contains("..")) {
                throw new ArmazenamentoArquivoException("Extensão do arquivo inválido");
            }
            Path localPasta = this.fileStorageLocation.resolve(nomeArquivo);
            Files.copy(file.getInputStream(), localPasta, StandardCopyOption.REPLACE_EXISTING);
            return nomeArquivo;
        } catch (Exception ex) {
            throw new ArmazenamentoArquivoException("Erro ao salvar arquivo" + ex.getMessage());
        }
    }
}

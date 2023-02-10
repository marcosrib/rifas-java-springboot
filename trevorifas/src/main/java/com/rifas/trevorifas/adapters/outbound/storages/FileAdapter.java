package com.rifas.trevorifas.adapters.outbound.storages;

import com.rifas.trevorifas.application.core.domain.File;
import com.rifas.trevorifas.application.ports.out.fileStorage.FileAdapterPort;
import com.rifas.trevorifas.common.config.FileStorageConfig;
import com.rifas.trevorifas.exception.ArmazenamentoArquivoException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import com.rifas.trevorifas.exception.RegraNegocioException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class FileAdapter implements FileAdapterPort {

    private final FileStorageConfig fileStorageConfig;

    @Autowired
    public FileAdapter(FileStorageConfig fileStorageConfig) {
        this.fileStorageConfig = fileStorageConfig;
    }

    @Override
    public String save(File file) {

        String fileName = StringUtils.cleanPath(file.getName());

        try {
            if (fileName.contains("..")) {
                throw new ArmazenamentoArquivoException("Extensão do arquivo inválido");
            }
            String extension = FilenameUtils.getExtension(fileName);
            UUID uuid = UUID.randomUUID();
            String fileNameConverted = String.valueOf(uuid) + "." + extension;
            Path pathLocal = getFilePath().resolve(fileNameConverted);
            Files.copy(file.getInputStream(), pathLocal, StandardCopyOption.REPLACE_EXISTING);
            return fileNameConverted;
        } catch (Exception ex) {
            throw new ArmazenamentoArquivoException("Erro ao salvar arquivo" + ex.getMessage());
        }
    }

    public Resource getFileByName(String name) {
        try {
            Path file = getFilePath().resolve(name);
            return new UrlResource(file.toUri());
        } catch (Exception ex) {
            throw new RegraNegocioException("Imagem não encontrada");
        }
    }

    private Path getFilePath() {
        Path path = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();
        try {
            if (!Files.exists(path)) {
                Files.createDirectory(path);
            }
        } catch (Exception ex) {
            throw new ArmazenamentoArquivoException("Erro ao criar  pasta" + ex.getMessage());
        }
        return path;
    }
}

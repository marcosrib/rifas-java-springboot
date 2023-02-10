package com.rifas.trevorifas.adapters.inbound.controllers;


import com.rifas.trevorifas.adapters.inbound.controllers.swagger.api.FileApi;
import com.rifas.trevorifas.application.core.domain.File;
import com.rifas.trevorifas.application.ports.in.images.CreateImageUseCasePort;

import java.io.FileInputStream;
import java.io.IOException;

import com.rifas.trevorifas.application.ports.out.fileStorage.FileAdapterPort;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
@Log
public class FileController implements FileApi {

    private FileAdapterPort fileAdapterPort;
    private final CreateImageUseCasePort createImageUseCasePort;

    public FileController(CreateImageUseCasePort createImageUseCasePort, FileAdapterPort fileAdapterPort) {
        this.createImageUseCasePort = createImageUseCasePort;
        this.fileAdapterPort = fileAdapterPort;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public void save(@RequestParam Long raffleId, @RequestPart MultipartFile file)
            throws IOException {

        createImageUseCasePort.create(
                File.builder()
                        .raffleId(raffleId)
                        .inputStream(file.getInputStream())
                        .name(file.getOriginalFilename())
        );
    }

    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable("fileName") String file,
                                             HttpServletRequest request) {
        Resource fileResource = fileAdapterPort.getFileByName(file);
        log.info("get image: " + fileResource);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + fileResource.getFilename() + "\"")
                .body(fileResource);
    }

}

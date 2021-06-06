package com.rifas.trevorifas.controller;


import com.rifas.trevorifas.service.files.service.FileStorageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
@RestController
@RequestMapping("/api/imagem")
@Log
public class ImagemController {

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping("{nomeImagem:.+}")
     public ResponseEntity<Resource> getImage(@PathVariable("nomeImagem") String nomeImagem, HttpServletRequest request) {
        Resource imagemResource =  fileStorageService.buscarImagem(nomeImagem);
        String contentType = null;

        try {
          contentType = request.getServletContext().getMimeType(imagemResource.getFile().getAbsolutePath());
        } catch (Exception ex) {
            log.info("Não foi localizado imagem");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imagemResource.getFilename() + "\"")
                .body(imagemResource);
    }

}

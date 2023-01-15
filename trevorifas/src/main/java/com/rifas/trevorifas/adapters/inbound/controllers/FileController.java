package com.rifas.trevorifas.adapters.inbound.controllers;


import com.rifas.trevorifas.adapters.inbound.controllers.swagger.api.FileApi;
import com.rifas.trevorifas.application.core.domain.File;
import com.rifas.trevorifas.application.ports.in.images.CreateImageUseCasePort;
import com.rifas.trevorifas.service.files.service.FileStorageService;
import java.io.IOException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/image")
@Log
public class FileController  implements FileApi {

  @Autowired
  private FileStorageService fileStorageService;
  private final CreateImageUseCasePort createImageUseCasePort;

  public FileController(CreateImageUseCasePort createImageUseCasePort) {
    this.createImageUseCasePort = createImageUseCasePort;
  }

  @RequestMapping(
      method = RequestMethod.POST,
      consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE}
  )
  public void save( @RequestParam Long raffleId, @RequestPart MultipartFile file)
      throws IOException {

    createImageUseCasePort.create(
        File.builder()
            .raffleId(raffleId)
            .inputStream(file.getInputStream())
            .name(file.getOriginalFilename())
    );
  }

  @GetMapping("{nomeImagem:.+}")
  public ResponseEntity<Resource> getImage(@PathVariable("nomeImagem") String nomeImagem,
      HttpServletRequest request) {
    Resource imagemResource = fileStorageService.buscarImagem(nomeImagem);
    String contentType = null;

    try {
      contentType = request.getServletContext()
          .getMimeType(imagemResource.getFile().getAbsolutePath());
    } catch (Exception ex) {
      log.info("Não foi localizado imagem");
    }

    if (contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok()
        .contentType(MediaType.parseMediaType(contentType))
        .header(HttpHeaders.CONTENT_DISPOSITION,
            "attachment; filename=\"" + imagemResource.getFilename() + "\"")
        .body(imagemResource);
  }

}

package com.rifas.trevorifas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rifas.trevorifas.service.files.service.FileStorageService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.trevorifas.controller.dto.RifaDTO;
import com.rifas.trevorifas.domain.entity.Rifa;
import com.rifas.trevorifas.service.RifaService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/rifa")
@RequiredArgsConstructor
public class RifaController {

    private final RifaService service;
    private final FileStorageService fileStorageService;

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public Rifa salvar(@RequestParam("imagem") MultipartFile imagem, @RequestBody RifaDTO dto) {

        String nomeArquivo = fileStorageService.salvarArquivos(imagem);
        dto.setImagem(nomeArquivo);
        return service.salvar(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Rifa> listar(@RequestParam Integer page) {
        System.err.println(page);
        return service.listaRifas(page);
    }
}

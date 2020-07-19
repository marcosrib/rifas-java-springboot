package com.rifas.trevorifas.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rifas.trevorifas.controller.dto.PontoResponseDTO;
import com.rifas.trevorifas.service.PontoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ponto")
@RequiredArgsConstructor
public class PontoController {

	private final PontoService service;
	@Autowired
	private SimpMessagingTemplate simpleMessagingTemplate;

	private static final Logger logger = LoggerFactory.getLogger(PontoController.class);

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<PontoResponseDTO> listar(@PathVariable Long id) {
		return service.listaPontoPorIdRifa(id);
	}

	@GetMapping("/news")
	public String broadcastNews() {
		Object[] o = { "nome", "marcos", };

		simpleMessagingTemplate.convertAndSend("/topic/messages",o);
		logger.debug("Post not found");
		return "cd,ldf,vldflv,";
	}

}

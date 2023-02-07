package br.com.ms.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms.dtos.EmailDTO;
import br.com.ms.entities.EmailModel;
import br.com.ms.services.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailController {

	@Autowired
	private EmailService service;
	
	
	@PostMapping("/send-email")
	public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO){
		EmailModel model = new EmailModel();
		BeanUtils.copyProperties(emailDTO, model);
		service.sendEmail(model);
		return ResponseEntity.ok(model);
		
	}
	
}

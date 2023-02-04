package br.com.ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.ms.services.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService service;
	
}

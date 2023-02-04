package br.com.ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ms.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository repository;
}

package br.com.ms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ms.entities.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, Long> {

}

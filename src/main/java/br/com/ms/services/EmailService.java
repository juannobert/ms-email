package br.com.ms.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.ms.entities.EmailModel;
import br.com.ms.entities.enums.StatusEmail;
import br.com.ms.repositories.EmailRepository;

@Service
public class EmailService {

	@Autowired
	private EmailRepository repository;

	@Autowired
	private JavaMailSender mailSender;

	public EmailModel sendEmail(EmailModel emailModel) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(emailModel.getEmailForm());
			message.setTo(emailModel.getEmailTo());
			message.setSubject(emailModel.getSubject());
			message.setText(emailModel.getText());
			mailSender.send(message);

			emailModel.setStatusEmail(StatusEmail.SENT);
			emailModel.setSendDateEmail(LocalDateTime.now());
		} catch (MailException e) {
			emailModel.setStatusEmail(StatusEmail.ERROR);
		} finally {
			return repository.save(emailModel);
		}
	}

}

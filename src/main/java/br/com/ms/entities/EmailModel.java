package br.com.ms.entities;

import java.time.LocalDateTime;

import br.com.ms.entities.enums.StatusEmail;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_email")
public class EmailModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long emailId;
	
	private String ownerRef;
	
	private String emailForm;
	
	private String emailTo;
	
	private String subject;
	
	@Column(columnDefinition = "TEXT")
	private String text;
	
	private LocalDateTime sendDateEmail;
	
	private StatusEmail statusEmail;
}

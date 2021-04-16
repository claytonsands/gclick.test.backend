package br.com.gclick.springboottest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gclick.springboottest.dto.EmailDTO;
import br.com.gclick.springboottest.entity.ClientEntity;
import br.com.gclick.springboottest.entity.EmailEntity;
import br.com.gclick.springboottest.exception.ResourceNotFoundException;
import br.com.gclick.springboottest.repository.ClientRepository;
import br.com.gclick.springboottest.repository.EmailRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmailController {

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/email/client/{clientId}")
	public List<EmailEntity> getEmailsByClientId(@PathVariable(value = "clientId") Long clientId){
		return emailRepository.findByClientId(clientId);
	}

	@PostMapping("/email")
	public EmailEntity create(@Valid @RequestBody EmailDTO emailDTO) throws ResourceNotFoundException {
		Long clientId = emailDTO.getClientId();
		if(clientId == null)
			throw new ResourceNotFoundException("Por favor informar um numero o id do cliente!");
		
		Optional<ClientEntity> optClient = clientRepository.findById(clientId);
		
		if(!optClient.isPresent()) 
			throw new ResourceNotFoundException("Cliente não encontrado para o id " + clientId);

		EmailEntity emailEntity = new EmailEntity();
		emailEntity.setClient(optClient.get());
		emailEntity.setEmail(emailDTO.getEmail());
		emailEntity.setCategory(emailDTO.getCategory());
		emailEntity.setName(emailDTO.getName());
		
		return emailRepository.save(emailEntity);
	}

	@PutMapping("/email/{id}")
	public ResponseEntity<EmailEntity> update(@PathVariable(value = "id") Long emailId,
			@Valid @RequestBody EmailDTO emailDTO) throws ResourceNotFoundException {
		EmailEntity email = emailRepository.findById(emailId)
				.orElseThrow(() -> new ResourceNotFoundException("Email não encontrado para o id " + emailId));

		email.setName(emailDTO.getName());
		email.setCategory(emailDTO.getCategory());
		email.setEmail(emailDTO.getEmail());
		
		final EmailEntity updatedEmail = emailRepository.save(email);
		return ResponseEntity.ok(updatedEmail);
	}

	@DeleteMapping("/email/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		EmailEntity email = emailRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Email não encontrado para o id " + clientId));

		emailRepository.delete(email);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

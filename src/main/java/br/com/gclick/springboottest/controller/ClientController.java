package br.com.gclick.springboottest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import br.com.gclick.springboottest.entity.ClientEntity;
import br.com.gclick.springboottest.exception.ResourceNotFoundException;
import br.com.gclick.springboottest.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/client")
	public Page<ClientEntity> getAllClient(Pageable pageable) {
		return clientRepository.findAll(pageable);
	}

	@GetMapping("/client/{id}")
	public ResponseEntity<ClientEntity> getClientById(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		ClientEntity client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id " + clientId));
		return ResponseEntity.ok().body(client);
	}

	@PostMapping("/client")
	public ClientEntity createClient(@Valid @RequestBody ClientEntity client) {
		return clientRepository.save(client);
	}

	@PutMapping("/client/{id}")
	public ResponseEntity<ClientEntity> updateClient(@PathVariable(value = "id") Long clientId,
			@Valid @RequestBody ClientEntity clientDetails) throws ResourceNotFoundException {
		ClientEntity client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id " + clientId));

		client.setNickname(clientDetails.getNickname());
		client.setSubscription(clientDetails.getSubscription());
		client.setName(clientDetails.getName());
		client.setStatus(clientDetails.getStatus());
		client.setUrlPhoto(clientDetails.getUrlPhoto());
		
		final ClientEntity updatedClient = clientRepository.save(client);
		return ResponseEntity.ok(updatedClient);
	}

	@DeleteMapping("/client/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId)
			throws ResourceNotFoundException {
		ClientEntity client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado para o id " + clientId));

		clientRepository.delete(client);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

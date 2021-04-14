package br.com.gclick.springboottest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class EmailDTO {

	private Long id;
	private String category;
	private String name;
	private String email;
	
	@JsonIgnore
	private ClientDTO client;
}

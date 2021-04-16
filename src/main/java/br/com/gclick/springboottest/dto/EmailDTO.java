package br.com.gclick.springboottest.dto;

import lombok.Data;

@Data
public class EmailDTO {
	private String category;
	private String name;
	private String email;
	private Long clientId;
}

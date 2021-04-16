package br.com.gclick.springboottest.dto;

import java.util.List;

import br.com.gclick.springboottest.enums.ClientStatusEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO{

	private Long id;
	private String subscription;
	private String name;
	private String nickname;
	private ClientStatusEnum status;

	private List<EmailDTO> emails;
}

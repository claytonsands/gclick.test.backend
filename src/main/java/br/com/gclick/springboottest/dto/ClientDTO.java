package br.com.gclick.springboottest.dto;

import java.util.List;

import br.com.gclick.springboottest.enums.ClientStatusEnum;
import br.com.gclick.springboottest.util.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ClientDTO extends BaseDTO{

	private static final long serialVersionUID = 8837049895559131489L;
	private Long id;
	private String subscription;
	private String name;
	private String nickname;
	private ClientStatusEnum status;

	private List<EmailDTO> emails;
}

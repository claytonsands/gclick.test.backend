package br.com.gclick.springboottest.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.gclick.springboottest.enums.ClientStatusEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cliente")
@EqualsAndHashCode(callSuper = false)
public class ClientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "inscricao")
	private String subscription;
	@Column(name = "nome")
	private String name;
	@Column(name = "apelido")
	private String nickname;
	@Column(name = "status")
	private ClientStatusEnum status;
	@Column(name = "foto_url")
	private String urlPhoto;

    @OneToMany(mappedBy = "client", cascade = { CascadeType.ALL })
	private List<EmailEntity> emails = new ArrayList<EmailEntity>();
}

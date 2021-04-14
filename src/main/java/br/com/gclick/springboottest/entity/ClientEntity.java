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
import br.com.gclick.springboottest.util.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "cliente")
@EqualsAndHashCode(callSuper = false)
public class ClientEntity extends BaseEntity {

	private static final long serialVersionUID = 3203151127458533029L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "inscricao")
	private String subscription;
	@Column(name = "nome")
	private String name;
	@Column(name = "apelido")
	private String nickname;
	@Column(name = "status")
	private ClientStatusEnum status;

    @OneToMany(mappedBy = "client", cascade = { CascadeType.ALL })
	private List<EmailEntity> emails = new ArrayList<EmailEntity>();
}

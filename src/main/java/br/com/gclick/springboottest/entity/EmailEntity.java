package br.com.gclick.springboottest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.gclick.springboottest.util.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "email")
@EqualsAndHashCode(callSuper = false)
public class EmailEntity extends BaseEntity{

	private static final long serialVersionUID = -6330245321724361343L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "categoria")
	private String category;
	@Column(name = "nome")
	private String name;
	@Column(name = "email", unique = true)
	private String email;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClientEntity client;
}

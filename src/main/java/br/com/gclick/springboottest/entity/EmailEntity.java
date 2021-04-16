package br.com.gclick.springboottest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "email")
@EqualsAndHashCode(callSuper = false)
public class EmailEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "categoria")
	private String category;
	@Column(name = "nome")
	private String name;
//	@Column(name = "email", unique = true)
	@Column(name = "email")
	private String email;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClientEntity client;
}

package com.projetoweb.pagrn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name="PessoaJuridica")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PessoaJuridica {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO ) 
	private Long id ;
	
	@Column(nullable = false)
	private String nome ;
	private String email ;
	@Column(nullable = false)
	private String telefone ;
	@Column(nullable = false)
	private String estadoCivil;
	@Column(nullable = false)
	private String sexo;
	@Column(nullable = false)
	private String cnpj;
	@Column(nullable = false)
	private String razaosocial;
	
	@ManyToOne
	private Endereco endereco;
	
}

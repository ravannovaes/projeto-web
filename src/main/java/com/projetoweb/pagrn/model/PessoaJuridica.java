package com.projetoweb.pagrn.model;

import lombok.*;

import javax.persistence.*;

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

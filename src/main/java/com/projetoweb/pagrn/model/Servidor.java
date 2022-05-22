package com.projetoweb.pagrn.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity(name="Servidor")
public class Servidor {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO ) 
	private Long id ;
	
	private Long matricula ;
	@Column(nullable = false)
	private String nome_social ;
	private String eh_etrangeiro ;	
	
	@ManyToOne
	private Pessoa pessoa ;

	public Servidor ( String nome_social, String eh_etrangeiro, Pessoa pessoa) {
		this.nome_social=nome_social;
		this.eh_etrangeiro=eh_etrangeiro;
		this.pessoa= pessoa;
		
	}
	

}

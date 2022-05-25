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
	private String nomeSocial ;
	private String estrangeiro ;
	
	@ManyToOne
	private Pessoa pessoa ;

	public Servidor ( String nomeSocial, String estrangeiro, Pessoa pessoa) {
		this.nomeSocial=nomeSocial;
		this.estrangeiro=estrangeiro;
		this.pessoa= pessoa;
		
	}
	

}

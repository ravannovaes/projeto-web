package com.projetoweb.pagrn.model;

import lombok.*;

import java.time.LocalDate;

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
	private LocalDate dataExoneracao;
	
	@ManyToOne
	private Pessoa pessoa ;

	public Servidor ( String nomeSocial, String estrangeiro, Pessoa pessoa, LocalDate dataExoneracao) {
		this.nomeSocial=nomeSocial;
		this.estrangeiro=estrangeiro;
		this.pessoa= pessoa;
		this.dataExoneracao= dataExoneracao;
		
		
	}
	

}

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
	
	

}

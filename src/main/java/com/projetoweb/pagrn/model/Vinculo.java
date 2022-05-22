package com.projetoweb.pagrn.model;

import java.time.LocalDateTime;

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
@Entity(name="Vinculo")
public class Vinculo {
			
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO ) 
	private Long id ;
	
	@Column(nullable = false)
	private LocalDateTime data_exercicio ;
	@Column(nullable = false)
	private LocalDateTime data_posse;
	@Column(nullable = false)
	private LocalDateTime data_nomeacao;
	private String desconto_irpf;
	
	//Instância DTO
	
	
	@ManyToOne
	private Servidor servidor ;

	public Vinculo(LocalDateTime data_exercicio, LocalDateTime data_posse, LocalDateTime data_nomeacao,
	 Servidor servidor) {
		this.data_exercicio = data_exercicio;
		this.data_posse = data_posse;
		this.data_nomeacao = data_nomeacao;
		//this.desconto_irpf = desconto_irpf;
		this.servidor = servidor;
	}



}

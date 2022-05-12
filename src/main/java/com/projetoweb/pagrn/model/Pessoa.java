package com.projetoweb.pagrn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name="Pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO ) 
	Long id ;
	
	String nome ;

}

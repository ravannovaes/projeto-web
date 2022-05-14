package com.projetoweb.pagrn.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity(name="Pessoa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pessoa {
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
	private String cpf;
	@Column(nullable = false)
	private LocalDateTime dataNasc;
	private String tipoSanguineo;
	private String nomePai;
	@Column(nullable = false)
	private String nomeMae;
	private String foto;

	public Pessoa(String nome, String email, String telefone, String sexo, LocalDateTime dataNasc, String nomeMae) {

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNasc = dataNasc;
		this.nomeMae = nomeMae;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDateTime dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getTipoSanguineo() {
		return tipoSanguineo;
	}

	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}

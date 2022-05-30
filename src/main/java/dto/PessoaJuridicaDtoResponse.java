package dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.RepresentationModel;

import com.projetoweb.pagrn.controller.PessoaJuridicaController;

import com.projetoweb.pagrn.model.Endereco;
import com.projetoweb.pagrn.model.PessoaJuridica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//*

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PessoaJuridicaDtoResponse extends RepresentationModel <PessoaJuridicaDtoResponse>{
	
    Long id ;
    String nome ;
	String email ;
	String telefone ;
	String estadoCivil;
	String sexo;
    String cnpj;
	String razaosocial;
   
	Endereco endereco;
	
	public PessoaJuridicaDtoResponse (PessoaJuridica pessoaJuridica) {
		

	   this.id = pessoaJuridica.getId();
	   this.nome = pessoaJuridica.getNome();
	   this.email = pessoaJuridica.getEmail();
	   this.telefone = pessoaJuridica.getTelefone();
	   this.estadoCivil = pessoaJuridica.getEstadoCivil();
	   this.sexo = pessoaJuridica.getSexo();
	   this.cnpj = pessoaJuridica.getCnpj();
	   this.razaosocial = pessoaJuridica.getRazaosocial();
	   
	   this.endereco = pessoaJuridica.getEndereco();
	   
	   add(linkTo(PessoaJuridicaController.class).slash(pessoaJuridica.getId()).withSelfRel());
	   add(linkTo(PessoaJuridicaController.class).withRel("allPessoaJuridica"));
		
		
		
	}

}

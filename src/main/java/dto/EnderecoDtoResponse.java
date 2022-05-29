package dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.RepresentationModel;

import com.projetoweb.pagrn.controller.ServidorController;
import com.projetoweb.pagrn.model.Endereco;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class EnderecoDtoResponse extends RepresentationModel<EnderecoDtoResponse> {
	
	     String latitude;
	     String longitude;
	     String numero;
	     String complemento;
	     String logradouro;
	     String cep;
	     
	     public  EnderecoDtoResponse(Endereco e ) {
	    	 
	    	 this.latitude = e.getLatitude();
	    	 this.longitude = e.getLongitude();
	    	 this.numero = e.getNumero();
	    	 this.complemento =e.getComplemento();
	    	 this.logradouro = e.getLogradouro();
	    	 this.cep =e.getCep();
	    	 
	    	 add(linkTo(ServidorController.class).slash(e.getId()).withSelfRel());
	    	 add(linkTo(ServidorController.class).withRel("allEndereco"));
	    	 
		 
		} 

}

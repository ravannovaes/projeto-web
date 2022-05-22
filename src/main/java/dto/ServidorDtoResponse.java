package dto;

import com.projetoweb.pagrn.controller.ServidorController;
import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.model.Servidor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Getter
@Setter
@ToString
public class ServidorDtoResponse extends RepresentationModel<ServidorDtoResponse> {
	
	String nome_social ;
	String eh_etrangeiro ;
	Pessoa pessoa ;
	
	
	public ServidorDtoResponse (Servidor s){
		
		this.nome_social = s.getNome_social() ;
		this.eh_etrangeiro = s.getEh_etrangeiro();
		this.pessoa= s.getPessoa();
		
	    add(linkTo(ServidorController.class).slash(s.getId()).withSelfRel());
	    add(linkTo(ServidorController.class).withRel("allClientes"));
		
		
	}

}

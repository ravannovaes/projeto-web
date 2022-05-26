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
	Long id;
	
	
	public ServidorDtoResponse (Servidor s){

		this.id = s.getId();
		this.nome_social = s.getNomeSocial() ;
		this.eh_etrangeiro = s.getEstrangeiro();
		this.pessoa= s.getPessoa();
		
	    add(linkTo(ServidorController.class).slash(s.getId()).withSelfRel());
	    add(linkTo(ServidorController.class).withRel("allServidor"));
		
		
	}

}

package dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;


import com.projetoweb.pagrn.controller.VinculoController;

import com.projetoweb.pagrn.model.Servidor;
import com.projetoweb.pagrn.model.Vinculo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VinculoDtoResponse extends RepresentationModel <VinculoDtoResponse> {
	

	LocalDateTime data_exercicio ;
    LocalDateTime data_posse;
    LocalDateTime data_nomeacao;
	//String desconto_irpf;
	Servidor servidor ;
	
	public VinculoDtoResponse (Vinculo v ) {
		
		this.data_exercicio = v.getData_exercicio();
		this.data_posse = v.getData_posse();
		this.data_nomeacao = v.getData_nomeacao();
		this.servidor=v.getServidor();
		
		 add(linkTo(VinculoController.class).slash(v.getId()).withSelfRel());
		 add(linkTo(VinculoController.class).withRel("allVinculos"));
	
	}

}

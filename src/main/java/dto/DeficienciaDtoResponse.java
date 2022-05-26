package dto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.hateoas.RepresentationModel;

import com.projetoweb.pagrn.controller.ServidorController;
import com.projetoweb.pagrn.model.Deficiencia;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeficienciaDtoResponse extends RepresentationModel<DeficienciaDtoResponse>{
	

	boolean fisica ;
	boolean visual ;
	boolean auditiva ;
	boolean mental ; 
	boolean intelectual ; 
	String denominacao;
	
	public DeficienciaDtoResponse (Deficiencia d) {
		
		  this.fisica = d.isFisica();
	      this.visual = d.isVisual();
	      this.auditiva = d.isAuditiva();
	      this.mental = d.isMental();
	      this.intelectual = d.isIntelectual();
	      this.denominacao = d.getDenominacao();
	      
	      add(linkTo(ServidorController.class).slash(d.getId()).withSelfRel());
		  add(linkTo(ServidorController.class).withRel("allDeficiencias"));
			
		
		
	}
	
	
	
}

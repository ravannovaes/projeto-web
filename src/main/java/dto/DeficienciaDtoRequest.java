package dto;

import com.projetoweb.pagrn.model.Deficiencia;
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
public class DeficienciaDtoRequest {
	
	
	boolean fisica ;
	boolean visual ;
	boolean auditiva ;
	boolean mental ; 
	boolean intelectual ; 
	String denominacao;
	
	public Deficiencia convertToDeficiencia() {
		return new Deficiencia(this.fisica,this.visual, this.auditiva,this.mental,this.intelectual,this.denominacao);
		
	}
	

}

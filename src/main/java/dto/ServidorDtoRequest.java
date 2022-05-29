package dto;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.model.Servidor;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ServidorDtoRequest {
	
    String nomeSocial ;
	String estrangeiro ;
	Pessoa pessoa ;
 
	public Servidor convertToservidor() {
			return new Servidor( this.nomeSocial,this.estrangeiro, this.pessoa);
		}
}
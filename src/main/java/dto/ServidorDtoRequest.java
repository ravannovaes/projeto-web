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
	
    String nome_social ;
	String eh_etrangeiro ;
	Pessoa pessoa ;
 
	public Servidor convertToservidor() {
			return new Servidor( this.nome_social,this.eh_etrangeiro, this.pessoa);
		}
}
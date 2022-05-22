package dto;

import com.projetoweb.pagrn.model.Pessoa;
import com.projetoweb.pagrn.model.Servidor;

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
public class ServidorDtoRequest {
	
    String nome_social ;
	String eh_etrangeiro ;
	Pessoa pessoa ;
 
	public Servidor convertToservidor() {
			return new Servidor( this.nome_social,this.eh_etrangeiro, this.pessoa);
		}
}
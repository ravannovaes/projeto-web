package dto;

import java.time.LocalDateTime;


import com.projetoweb.pagrn.model.Endereco;
import com.projetoweb.pagrn.model.Pessoa;


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
public class PessoaDtoRequest {

    Long id ;
    String nome ;
	String email ;
	String telefone ;
	String estadoCivil;
	String sexo;
    String cpf;
	LocalDateTime dataNasc;
	String tipoSanguineo;
	String nomePai;
	String nomeMae;
	String foto;
	Endereco endereco;
	//Deficiencia deficiencias;
	
	
	public Pessoa convertToPessoa() {
		return new Pessoa( this.nome, this.email,this.telefone,
			this.sexo,this.dataNasc,this.nomeMae,this.endereco);
	}
	
//Instanciar pro controller ;
}

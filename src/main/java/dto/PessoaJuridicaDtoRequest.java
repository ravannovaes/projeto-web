package dto;
import com.projetoweb.pagrn.model.Endereco;
import com.projetoweb.pagrn.model.PessoaJuridica;
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
public class PessoaJuridicaDtoRequest {

    Long id ;
    String nome ;
	String email ;
	String telefone ;
	String estadoCivil;
	String sexo;
    String cnpj;
	String razaosocial;
   
	Endereco endereco;
	
	public PessoaJuridica convertToPessoaJuridica() {
		return new PessoaJuridica( this.id,this.nome, this.email,this.telefone,this.estadoCivil,this.sexo,this.cnpj,this.razaosocial,this.endereco);
	}

}

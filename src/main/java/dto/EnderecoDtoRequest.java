package dto;

import com.projetoweb.pagrn.model.Endereco;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EnderecoDtoRequest {
	

     String latitude;
     String longitude;
     String numero;
     String complemento;
     String logradouro;
     String cep;
     
     public Endereco convertToEndereco() {
			return new Endereco( this.latitude, this.longitude,this.numero,this.complemento,this.logradouro,this.cep);
			}
     
//Instanciar no Controller;
}

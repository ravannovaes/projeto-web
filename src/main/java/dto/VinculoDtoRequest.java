package dto;

import com.projetoweb.pagrn.model.Servidor;
import com.projetoweb.pagrn.model.Vinculo;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class VinculoDtoRequest {
	

	LocalDateTime data_exercicio ;
    LocalDateTime data_posse;
    LocalDateTime data_nomeacao;
	//String desconto_irpf;
	Servidor servidor ;
	
	public Vinculo convertToVinculo() {
		return new Vinculo(this.data_exercicio, this.data_posse, this.data_nomeacao,this.servidor);
	}

}

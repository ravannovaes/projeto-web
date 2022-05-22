package dto;

import java.time.LocalDateTime;

import com.projetoweb.pagrn.model.Servidor;
import com.projetoweb.pagrn.model.Vinculo;

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
public class VinculoDtoResquest {
	

	LocalDateTime data_exercicio ;
    LocalDateTime data_posse;
    LocalDateTime data_nomeacao;
	//String desconto_irpf;
	Servidor servidor ;
	
	public Vinculo convertToVinculo() {
		return new Vinculo(this.data_exercicio, this.data_posse, this.data_nomeacao,this.servidor);
	}

}

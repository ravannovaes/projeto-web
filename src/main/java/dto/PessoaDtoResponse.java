package dto;

import com.projetoweb.pagrn.controller.ServidorController;
import com.projetoweb.pagrn.model.Pessoa;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;
import java.time.LocalDateTime;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@Getter
@Setter
@ToString
public class PessoaDtoResponse extends RepresentationModel<PessoaDtoResponse> {

    private Long id ;
    private String nome ;
    private String email ;
    private String telefone ;
    private String estadoCivil;
    private String sexo;
    private String cpf;
    private LocalDateTime dataNasc;
    private String nomeMae;


    public PessoaDtoResponse (Pessoa pessoa){

        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.email = pessoa.getEmail();
        this.telefone = pessoa.getTelefone();
        this.estadoCivil = pessoa.getEstadoCivil();
        this.sexo = pessoa.getSexo();
        this.cpf = pessoa.getCpf();
        this.dataNasc = pessoa.getDataNasc();
        this.nomeMae = pessoa.getNomeMae();

        add(linkTo(ServidorController.class).slash(pessoa.getId()).withSelfRel());
        add(linkTo(ServidorController.class).withRel("All people"));
    }
}

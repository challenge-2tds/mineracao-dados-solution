package mineracao.dados.solution.Model;

import jakarta.persistence.Table;
import lombok.Getter;

import java.io.Serializable;


@Getter
@Table(name = "TB_CEP")
public class EnderecoRequestModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private String cep;
}

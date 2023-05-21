package mineracao.dados.solution.Service;

import mineracao.dados.solution.Feign.EnderecoFeign;
import mineracao.dados.solution.Model.EnderecoRequestModel;
import mineracao.dados.solution.Model.EnderecoResponseModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class EnderecoService {

    @Autowired
    private final EnderecoFeign enderecoFeign;

    public EnderecoResponseModel executa(EnderecoRequestModel request) {
        return enderecoFeign.buscaEnderecoCep(request.getCep());
    }
}

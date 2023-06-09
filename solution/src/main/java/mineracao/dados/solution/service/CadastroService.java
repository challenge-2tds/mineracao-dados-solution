package mineracao.dados.solution.service;


import jakarta.transaction.Transactional;
import mineracao.dados.solution.models.CadastroModel;
import mineracao.dados.solution.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroService {


    @Autowired(required = false)
    private CadastroRepository cadastroRepository;

    @Transactional
    public CadastroModel save(CadastroModel cadastroModel) {
        return cadastroRepository.save(cadastroModel);
    }

    public List<CadastroModel> buscarCadastros(){
        List<CadastroModel> listCadastros = cadastroRepository.findAll();
        return listCadastros;
    }

}

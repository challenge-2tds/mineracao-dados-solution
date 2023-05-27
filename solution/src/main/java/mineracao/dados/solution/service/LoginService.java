package mineracao.dados.solution.service;


import jakarta.transaction.Transactional;

import mineracao.dados.solution.models.LoginModel;
import mineracao.dados.solution.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {


    final LoginRepository loginRepository;


    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Transactional
    public LoginModel save(LoginModel loginModels) {
        return loginRepository.save(loginModels);
    }

    public List<LoginModel> buscarLogins(){
        List<LoginModel> listLogins = loginRepository.findAll();
        return listLogins;
    }

    public Optional<LoginModel> AtualizarSenha(LoginModel loginModel){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEconder = encoder.encode(loginModel.getSenha());

        loginModel.setSenha(senhaEconder);

        return Optional.of(loginRepository.save(loginModel));
    }

}

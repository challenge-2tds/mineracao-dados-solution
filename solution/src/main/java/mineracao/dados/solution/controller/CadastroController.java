package mineracao.dados.solution.Controller;


import mineracao.dados.solution.Exception.CPFException;
import mineracao.dados.solution.Model.CadastroModel;
import mineracao.dados.solution.Repository.CadastroRepository;
import mineracao.dados.solution.Service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class CadastroController {

    @Autowired
    private CadastroRepository cadastroRepository;

    final CadastroService cadastroService;

    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    public void validarCPF(CadastroModel cadastroModel) throws CPFException {
        Optional<CadastroModel> cadastroCPF = cadastroRepository.findByCpf(cadastroModel.getCpf());


        if (cadastroCPF.isPresent()) {
            throw new CPFException();
        }

    }

    @GetMapping(path = "/buscarCadastros")
    public List<CadastroModel> buscarCadastro() {
        return cadastroService.buscarCadastros();

    }

    @PostMapping(path = "/cadastar")
    public ResponseEntity<Object> saveCadastro(@RequestBody CadastroModel cadastroModel) throws CPFException {
        this.validarCPF(cadastroModel);

        CadastroModel cadastroSalva = cadastroRepository.save(cadastroModel);
        return new ResponseEntity<>(cadastroSalva, HttpStatus.CREATED);
    }

    @ExceptionHandler({CPFException.class})
    public ResponseEntity<String> InvalidaException(CPFException e) {
        String exception = e.getMessage();
        return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);

    }
}

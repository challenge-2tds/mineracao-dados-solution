package mineracao.dados.solution.controller;


import lombok.RequiredArgsConstructor;
import mineracao.dados.solution.models.EnderecoRequestModel;
import mineracao.dados.solution.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class EnderecoController {

    @Autowired
    private final EnderecoService enderecoService;

    @GetMapping("/consultaCEP")
    public ResponseEntity consultaCep(@RequestBody EnderecoRequestModel enderecoRequest) {
        return ResponseEntity.ok(enderecoService.executa(enderecoRequest));
    }
}

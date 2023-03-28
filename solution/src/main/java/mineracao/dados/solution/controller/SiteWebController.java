package mineracao.dados.solution.controller;
import mineracao.dados.solution.models.UrlModel;
import mineracao.dados.solution.service.MiningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/site")
public class SiteWebController<T> {

    MiningService miningService = new MiningService();

    @PostMapping("/url")
    public ResponseEntity<T> siteUrl(@RequestBody UrlModel url) {
        System.out.println("SiteWebController.siteUrl");
        System.out.println("url = " + url);

        if (url.getUrl() != null && url.getTypeSearch() != null) {
            miningService.extractWebData(url);
            return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.CREATED).body(url);
        }


        return (ResponseEntity<T>) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Não é possivel inserir dados nulos!");
    }


}

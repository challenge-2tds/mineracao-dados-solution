package mineracao.dados.solution.controller;

import mineracao.dados.solution.models.GenericEntity;
import mineracao.dados.solution.models.UrlModel;
import mineracao.dados.solution.repository.UrlModelRepository;
import mineracao.dados.solution.service.GenericEntityServiceImpl;
import mineracao.dados.solution.service.MiningService;
import mineracao.dados.solution.service.UrlServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/site")
public class SiteWebController {

    MiningService miningService = new MiningService();

    @Autowired
    private UrlServiceImpl urlModelRepository;

    @Autowired
    private GenericEntityServiceImpl genericEntityService;


    @PostMapping("/url")
    public ResponseEntity<UrlModel> siteUrl(@RequestBody UrlModel url) {
        System.out.println("SiteWebController.siteUrl");
        System.out.println("url = " + url);
        try {
            List<GenericEntity> mining = miningService.extractWebData(url);

            urlModelRepository.saveUrl(url);
            genericEntityService.saveGenericEntity(mining);


            return ResponseEntity.ok(url);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }


    }


}




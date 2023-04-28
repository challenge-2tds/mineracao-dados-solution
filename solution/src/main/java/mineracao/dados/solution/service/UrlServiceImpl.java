package mineracao.dados.solution.service;

import mineracao.dados.solution.models.UrlModel;
import mineracao.dados.solution.repository.UrlModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlServiceImpl {

    @Autowired
    private UrlModelRepository urlRepo;

    public UrlModel saveUrl(UrlModel urlModel) {
        return urlRepo.save(urlModel);
    }







}

package mineracao.dados.solution.service;

import mineracao.dados.solution.models.GenericEntity;
import mineracao.dados.solution.repository.GenericEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericEntityServiceImpl {

    @Autowired
    private GenericEntityRepository genericEntityRepository;

    public void saveGenericEntity(List<GenericEntity> genericEntity) {

        try {

            System.out.println("Persistindo dados...");
            genericEntityRepository.saveAll(genericEntity);
        } catch (Exception e) {
            System.out.println("ERRO ao persistir!");
            e.printStackTrace();
        }
    }

}

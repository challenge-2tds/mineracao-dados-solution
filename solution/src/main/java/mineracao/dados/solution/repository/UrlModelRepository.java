package mineracao.dados.solution.repository;

import mineracao.dados.solution.models.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlModelRepository extends MongoRepository<UrlModel, Long> {


}

package mineracao.dados.solution.repository;

import mineracao.dados.solution.models.GenericEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GenericEntityRepository  extends MongoRepository<GenericEntity, Long> {
}

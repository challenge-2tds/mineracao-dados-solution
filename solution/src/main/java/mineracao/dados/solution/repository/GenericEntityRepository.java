package mineracao.dados.solution.repository;

import mineracao.dados.solution.models.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
//MongoRepository
public interface GenericEntityRepository  extends JpaRepository<GenericEntity, Long> {
}

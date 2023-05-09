package mineracao.dados.solution.repository;

import mineracao.dados.solution.models.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
//MongoRepository
public interface UrlModelRepository extends JpaRepository<UrlModel, Long> {


}

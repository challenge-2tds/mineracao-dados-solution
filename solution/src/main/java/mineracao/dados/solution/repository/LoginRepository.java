package mineracao.dados.solution.repository;

import mineracao.dados.solution.models.LoginModel;
import org.springframework.boot.context.properties.DeprecatedConfigurationProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, UUID> {
}

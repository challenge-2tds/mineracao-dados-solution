package mineracao.dados.solution.repository;

import mineracao.dados.solution.models.CadastroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel, UUID> {

    Optional<CadastroModel> findByCpf(String cpf);

    Optional<CadastroModel> findByEmail(String email);
}

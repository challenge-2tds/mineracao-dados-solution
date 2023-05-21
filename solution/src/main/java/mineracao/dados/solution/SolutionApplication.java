package mineracao.dados.solution;

import mineracao.dados.solution.repository.UrlModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@EnableMongoRepositories
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
public class SolutionApplication {




	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}

}

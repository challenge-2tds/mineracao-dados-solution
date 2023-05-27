package mineracao.dados.solution;

import mineracao.dados.solution.repository.UrlModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@EnableMongoRepositories
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
@EnableWebMvc
@EnableSwagger2
public class SolutionApplication {




	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}

}

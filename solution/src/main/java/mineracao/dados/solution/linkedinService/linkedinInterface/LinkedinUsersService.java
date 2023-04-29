package mineracao.dados.solution.linkedinService.linkedinInterface;

import mineracao.dados.solution.models.GenericEntity;
import org.openqa.selenium.WebDriver;

import java.util.List;

public interface LinkedinUsersService {

    public List<String> LinkedinUrl(WebDriver driver, String urlSite);

    public List<GenericEntity> linkedinExtractUserData(WebDriver driver, List<String> linkUsers );


}

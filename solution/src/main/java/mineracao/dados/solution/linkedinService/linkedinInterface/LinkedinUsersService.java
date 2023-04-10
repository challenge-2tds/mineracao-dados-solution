package mineracao.dados.solution.linkedinService.linkedinInterface;

import org.openqa.selenium.WebDriver;

import java.util.List;

public interface LinkedinUsersService {

    public List<String> LinkedinUrl(WebDriver driver, String urlSite);

    public void linkedinExtractUserData(WebDriver driver, List<String> linkUsers );


}

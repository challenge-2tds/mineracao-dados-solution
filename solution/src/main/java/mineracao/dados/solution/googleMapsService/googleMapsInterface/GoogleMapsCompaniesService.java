package mineracao.dados.solution.googleMapsService.googleMapsInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface GoogleMapsCompaniesService {

    public List<WebElement> scrollPageAndExtractCompany(WebDriver driver);

    public void getAllCompaniesByKey(WebDriver driver);
}

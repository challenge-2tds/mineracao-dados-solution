package mineracao.dados.solution.googleMapsService;

import mineracao.dados.solution.models.UrlModel;
import org.openqa.selenium.WebDriver;

public class MapsUrlCompanies {


    public String getCompaniesUrl(WebDriver driver, UrlModel url) {

        String geoloc = "@-23.6552192,-46.7566592,12z";

        String findAllCompanies = url.getUrl() + "/search/" + url.getKeys() + "/" +   geoloc;

        driver.get(findAllCompanies);

        return findAllCompanies;

    }


}

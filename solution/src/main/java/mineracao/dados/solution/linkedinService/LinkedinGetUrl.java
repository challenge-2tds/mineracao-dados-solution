package mineracao.dados.solution.linkedinService;

import mineracao.dados.solution.models.UrlModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinGetUrl {


    public String getPeopleSection(WebDriver driver, UrlModel url) {

        String urlPeople = url.getUrl() + "/search/results/people/?keywords=" + url.getKeys() + "&origin=CLUSTER_EXPANSION";

        driver.get(urlPeople);

        return urlPeople;

    }

}

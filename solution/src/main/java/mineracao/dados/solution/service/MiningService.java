package mineracao.dados.solution.service;


import mineracao.dados.solution.googleMapsService.GetCompanies;
import mineracao.dados.solution.googleMapsService.MapsUrlCompanies;
import mineracao.dados.solution.linkedinService.LinkedinAuth;
import mineracao.dados.solution.linkedinService.LinkedinGetUrl;
import mineracao.dados.solution.linkedinService.LinkedinUrlUsers;
import mineracao.dados.solution.models.UrlModel;
import mineracao.dados.solution.models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class MiningService {

    private String pageNext = "&page=";


    public WebDriver getDriverChrome() {

        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(option);

        return driver;

    }

    public void extractWebData(UrlModel url) {

        String urlSite = url.getUrl();

        WebDriver driver = getDriverChrome();

        driver.get(urlSite);

        switch (url.getTypeSearch()) {


            case FACEBOOK:


            case LINKEDIN:

                LinkedinAuth linkedinAuth = new LinkedinAuth();
                LinkedinUrlUsers linkedinUrlUsers = new LinkedinUrlUsers();
                LinkedinGetUrl linkedinGetUrl = new LinkedinGetUrl();

                linkedinAuth.loginAuthLinkedin(driver);

                List<String> linkUsers = new ArrayList<>();

                String urlPeople = linkedinGetUrl.getPeopleSection(driver, url);

                linkUsers = linkedinUrlUsers.LinkedinUrl(driver, urlPeople);

                linkedinUrlUsers.linkedinExtractUserData(driver, linkUsers);


            case MAPSGOOGLE:

                MapsUrlCompanies mapsUrlCompanies = new MapsUrlCompanies();

                GetCompanies getCompanies = new GetCompanies();

                mapsUrlCompanies.getCompaniesUrl(driver, url);

                getCompanies.getAllCompaniesByKey(driver);


            case INSTAGRAM: // Minerar dados com base nos seguidores de usuario


        }


    }


}

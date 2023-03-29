package mineracao.dados.solution.service;


import mineracao.dados.solution.linkedinService.LinkedinAuth;
import mineracao.dados.solution.models.UrlModel;
import mineracao.dados.solution.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class MiningService {


    public WebDriver getDriverChrome() {

        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(option);

        return driver;

    }

    public void extractWebData(UrlModel url) {

        String urlSite = url.getUrl();

        switch (url.getTypeSearch()) {


            case FACEBOOK:


            case LINKEDIN: // Minerar dados com base em hashtags

                WebDriver driver = getDriverChrome();

                driver.get(urlSite);

                LinkedinAuth linkedinAuth = new LinkedinAuth();
                linkedinAuth.loginAuthLinkedin(driver);

                WebElement paginacao = driver.findElement(By.cssSelector("#artdeco-pagination artdeco-pagination--has-controls ember-view pv5 ph2"));


                while (paginacao.findElement(By.tagName("button")).getAttribute("disabbled").equals("false")) {


                    WebElement ulGlobal = driver.findElement(By.tagName("ul"));

                    List<WebElement> liUsers = driver.findElements(By.className("entity-result"));

                    List<String> linkUsers = null;

                    for (WebElement usuario : liUsers) {
                        String link = usuario.findElement(By.className("app-aware-link")).getAttribute("href");
                        System.out.println(link);
                        linkUsers.add(link);

                    }
                    WebElement proxPage = paginacao.findElement(By.tagName("button"));
                    proxPage.click();

                }


            case INSTAGRAM: // Minerar dados com base nos seguidores de usuario


        }


    }


}

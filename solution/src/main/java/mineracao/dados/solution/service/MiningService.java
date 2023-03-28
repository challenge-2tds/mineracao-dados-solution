package mineracao.dados.solution.service;


import mineracao.dados.solution.linkedinService.LinkedinAuth;
import mineracao.dados.solution.models.UrlModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MiningService {


    public WebDriver getDriverChrome() {

        System.setProperty("webdriver.chrome.driver", "src\\drive\\chromedriver.exe");

        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(option);

        return driver;

    }

    public void extractWebData(UrlModel url) {

        String urlSite= url.getUrl();

        switch (url.getTypeSearch()) {


            case FACEBOOK :


            case LINKEDIN: // Minerar dados com base em hashtags

                WebDriver driver = getDriverChrome();

                driver.get(urlSite);

                LinkedinAuth linkedinAuth = new LinkedinAuth();
                linkedinAuth.loginAuthLinkedin(driver);

                WebElement ulGlobal = driver.findElement(By.tagName("ul"));

                WebElement liUserLink = driver.findElement(By.className("app-aware-link  scale-down "));

                System.out.println(liUserLink);






            case INSTAGRAM: // Minerar dados com base nos seguidores de usuario


        }





    }






}

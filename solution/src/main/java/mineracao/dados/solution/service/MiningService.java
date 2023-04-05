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

                linkedinUrlUsers.linkedinExtractUserData( driver, linkUsers );


            case MAPSGOOGLE:

                MapsUrlCompanies mapsUrlCompanies = new MapsUrlCompanies();

                GetCompanies getCompanies = new GetCompanies();

                mapsUrlCompanies.getCompaniesUrl(driver, url);

                getCompanies.getAllCompaniesByKey(driver);





//                    MapsUrlCompanies mapsUrlCompanies = new MapsUrlCompanies();
//
//                    mapsUrlCompanies.getCompaniesUrl(driver, url);
//
//
//
//
//
//
//                    WebElement containerCard = driver.findElement(By.xpath("//div[@class='m6QErb DxyBCb kA9KIf dS8AEf ecceSd']"));
//
//
//                    List<WebElement> cardEmpresa = containerCard.findElements(By.xpath("//div[@class='Nv2PK THOPZb CpccDe ']"));
//
//                    List<WebElement> linkEmpresas = containerCard.findElements(By.xpath("//a[@class='hfpxzc']"));
//
//                    int i = 0;
//
//                    ArrayList<String> linksEmpresas = new ArrayList<>();
//
//                    for (WebElement empresaLink : linkEmpresas) {
//
//                        String linkEmpresa = empresaLink.getAttribute("href");
//                        System.out.println(linkEmpresa);
//                        linksEmpresas.add(linkEmpresa);
//
//
//                    }
//                    for (String link : linksEmpresas) {
//                        driver.get(link);
//
//                        try {
//
//                            String nome = driver.findElement(By.xpath("//h1[@class='DUwDvf fontHeadlineLarge']")).getText();
//
//                            String avaliacoes = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/span[2]/span/span")).getText();
//
//                            String estrelas = driver.findElement(By.xpath("//span[@class='ceNzKf']")).getAttribute("aria-label");
//
//                            List<WebElement> dadosCard = driver.findElements(By.xpath("//div[@class='rogA2c']/div[1]"));
//
//
//                            List<WebElement> horarioFuncionamento = driver.findElements(By.xpath("//tr[@class='y0skZc']"));
//
//
//                            String endereco = dadosCard.get(0).getText();
//
//                            String telefone = dadosCard.get(3).getText();
//
//                            String pluscode = dadosCard.get(4).getText();
//
//
//                            System.out.println("link empresa: " + link + "\nNome: " + nome + "\nestrelas: " + estrelas + "\nendereco: " + endereco + "\ntelefone: " + telefone + "\npluscode: " + pluscode);
//                            System.out.println("==================================================================================================================================================");
//
//
//                        } catch (Exception e) {
//                            System.out.println("==================================================================================================================================================");
//                        }
//
//
//                    }



            case INSTAGRAM: // Minerar dados com base nos seguidores de usuario


        }


    }


}

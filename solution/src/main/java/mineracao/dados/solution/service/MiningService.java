package mineracao.dados.solution.service;


import mineracao.dados.solution.linkedinService.LinkedinAuth;
import mineracao.dados.solution.models.UrlModel;
import mineracao.dados.solution.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


            case LINKEDIN: // Minerar dados com base em hashtags

                LinkedinAuth linkedinAuth = new LinkedinAuth();
                linkedinAuth.loginAuthLinkedin(driver);

                List<String> linkUsers = new ArrayList<>();


                for (int i = 1; i <= 2; i++) {

                    String numeric = Integer.toString(i);
                    System.out.println(numeric);

                    driver.get(urlSite + pageNext + numeric);

                    WebElement ulGlobal = driver.findElement(By.tagName("ul"));

                    List<WebElement> liUsers = driver.findElements(By.className("entity-result"));


                    for (WebElement usuario : liUsers) {
                        String link = usuario.findElement(By.className("app-aware-link")).getAttribute("href");
                        linkUsers.add(link);


                    }

                }

                for (String usuarioProfile : linkUsers) {

                    try {

                        Thread.sleep(3000);

                        driver.get(usuarioProfile);


                        String nome = driver.findElement(By.xpath("//h1[@class='text-heading-xlarge inline t-24 v-align-middle break-words']")).getText();

                        String localidade = driver.findElement(By.xpath("//span[@class='text-body-small inline t-black--light break-words']")).getText();

                        WebElement infoLink = driver.findElement(By.xpath("//*[@id=\"top-card-text-details-contact-info\"]"));

                        System.out.println("link perfil: " + usuarioProfile + "\nNome: " + nome + "\nLocalidade: " + localidade);

                        infoLink.click();

                        try {


                            String mail = driver.findElement(By.xpath("//a[@class='t-14 t-black t-normal']")).getAttribute("href");

                            String telefone = driver.findElement(By.xpath("//span[@class='t-14 t-black t-normal']")).getText();


                            System.out.println("telefone: " + telefone + "\nemail: " + mail);


                        } catch (Exception e) {

                            System.out.println("==================================================================================================================================================");

                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }


            case MAPSGOOGLE:
                try {

                    WebElement containerCard = driver.findElement(By.xpath("//div[@class='m6QErb DxyBCb kA9KIf dS8AEf ecceSd']"));


                    List<WebElement> cardEmpresa = containerCard.findElements(By.xpath("//div[@class='Nv2PK THOPZb CpccDe ']"));

                    List<WebElement> linkEmpresas = containerCard.findElements(By.xpath("//a[@class='hfpxzc']"));

                    int i = 0;

                    ArrayList<String> linksEmpresas = new ArrayList<>();

                    for (WebElement empresaLink : linkEmpresas) {

                        String linkEmpresa = empresaLink.getAttribute("href");
                        System.out.println(linkEmpresa);
                        linksEmpresas.add(linkEmpresa);


                    }
                    for (String link : linksEmpresas) {
                        driver.get(link);

                        try {

                            String nome = driver.findElement(By.xpath("//h1[@class='DUwDvf fontHeadlineLarge']")).getText();

                            String avaliacoes = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/span[2]/span/span")).getText();

                            String estrelas = driver.findElement(By.xpath("//span[@class='ceNzKf']")).getAttribute("aria-label");

                            List<WebElement> dadosCard = driver.findElements(By.xpath("//div[@class='rogA2c']/div[1]"));


                            List<WebElement> horarioFuncionamento = driver.findElements(By.xpath("//tr[@class='y0skZc']"));


                            String endereco = dadosCard.get(0).getText();

                            String telefone = dadosCard.get(3).getText();

                            String pluscode = dadosCard.get(4).getText();


                            System.out.println("link empresa: " + link + "\nNome: " + nome + "\nestrelas: " + estrelas + "\nendereco: " + endereco + "\ntelefone: " + telefone + "\npluscode: " + pluscode);
                            System.out.println("==================================================================================================================================================");


                        } catch (Exception e) {
                            System.out.println("==================================================================================================================================================");
                        }


                    }

//                        i++;
//
////                        System.out.println(i + "º empresa");
////                        System.out.println(empresa.getText());
////                        System.out.println("============================================================");
//
//                        String urlEmpresa = empresa.findElement(By.xpath("//a[@class='hfpxzc']")).getText();
//                        System.out.println(urlEmpresa);
//
////                        empresa.click();
////
////                        Thread.sleep(2000);
////
////
////                        driver.navigate().refresh();
////
////                        Thread.sleep(5000);
////
////                        driver.get(driver.getCurrentUrl());
////
////
////
////
////                        String name = empresa.findElement(By.cssSelector("m6QErb WNBkOb")).getAttribute("aria-label");
////
////                        String stars = empresa.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/span[1]/span[1]")).getText();
////
////                        String endereco = empresa.findElement(By.cssSelector("Io6YTe fontBodyMedium")).getText();
////
////                        String site = empresa.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[3]/div/div[1]/div/div/div[2]/div[9]/div[5]/a")).getAttribute("href");
////
////                        String phone = empresa.findElement(By.cssSelector("Io6YTe fontBodyMedium")).getText();
//                    }
//                    System.out.println("Foram encontrados " + i + "º Resultados");
//
//
//                    System.out.println(cardEmpresa);
                } catch (Exception e) {
                    e.printStackTrace();
//                }
                }


            case INSTAGRAM: // Minerar dados com base nos seguidores de usuario


        }


    }


}

package mineracao.dados.solution.googleMapsService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetCompanies {


    public void getAllCompaniesByKey(WebDriver driver) {

        WebElement containerCard = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div[1]"));


        List<WebElement> cardsEmpresa = containerCard.findElements(By.xpath("//div[@class='Nv2PK THOPZb CpccDe ']"));

        for (WebElement cardEmpresa : cardsEmpresa) {

            cardEmpresa.click();


            String nome = driver.findElement(By.xpath("//h1[@class='DUwDvf fontHeadlineLarge']")).getText();

//            String avaliacoes = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/span[2]/span/span")).getText();

            String estrelas = driver.findElement(By.xpath("//span[@class='ceNzKf']")).getAttribute("aria-label");

            String endereco =  driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[3]/div/div[1]/div/div/div[2]/div[9]/div[3]/button/div[1]/div[3]/div[1]")).getText();

            String telefone = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[3]/div/div[1]/div/div/div[2]/div[9]/div[6]/button/div[1]/div[3]/div[1]")).getText();

            String pluscode = driver.findElement(By.xpath("/html/body/div[3]/div[9]/div[9]/div/div/div[1]/div[3]/div/div[1]/div/div/div[2]/div[9]/div[7]/button/div[1]/div[3]/div[1]")).getText();

        }

        //List<WebElement> linkEmpresas = containerCard.findElements(By.xpath("//a[@class='hfpxzc']"));



    }
}

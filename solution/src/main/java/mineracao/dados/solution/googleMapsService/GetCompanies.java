package mineracao.dados.solution.googleMapsService;

import mineracao.dados.solution.googleMapsService.googleMapsInterface.GoogleMapsCompaniesService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GetCompanies implements GoogleMapsCompaniesService {


    public List<WebElement> scrollPageAndExtractCompany(WebDriver driver) {

        try {
            Thread.sleep(3000);


            List<WebElement> cardsEmpresa = driver.findElements(By.xpath("//a[@class='hfpxzc']"));

            for (WebElement rolagem : cardsEmpresa) {
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                jse.executeScript("arguments[0].scrollIntoView(true)", rolagem);

            }

            return cardsEmpresa;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;


    }


    public void getAllCompaniesByKey(WebDriver driver) {

//        List<WebElement> cardsEmpresa = driver.findElements(By.xpath("//a[@class='hfpxzc']"));

        List<WebElement> scrolls = scrollPageAndExtractCompany(driver);

        for (WebElement scroll : scrolls) {

            scrolls = scrollPageAndExtractCompany(driver);

        }

        for (WebElement cardEmpresa : scrolls) {

            Actions actions = new Actions(driver);

            actions.moveToElement(cardEmpresa).click().perform();


            try {


                Thread.sleep(3000);


                String nome = driver.findElement(By.xpath("//div[@class='lMbq3e']/div/h1")).getText();

                String avaliacoes = driver.findElement(By.xpath("//div[@class='F7nice ']/span[2]/span/span")).getText();

                String estrelas = driver.findElement(By.xpath("//span[@class='ceNzKf']")).getAttribute("aria-label");

                String endereco = driver.findElement(By.xpath("//button[@data-item-id='address']/div/div[3]/div")).getText();

                String pluscode = driver.findElement(By.xpath("//button[@data-tooltip='Copiar Plus Code']/div/div[3]/div")).getText();

                try {
                    String telefone = driver.findElement(By.xpath("//button[@data-tooltip='Copiar número de telefone']/div/div[3]/div")).getText();

                    System.out.println("Nome empresa: " + nome + "\nNº Avaliações: " + avaliacoes + "\nEstrelas: " + estrelas + "\nendereco: " + endereco + "\nTelefone: " + telefone + "\nPlusCode: " + pluscode);
                    System.out.println("==============================================================================================================================================");

                } catch (Exception e) {

                    System.out.println("Nome empresa: " + nome + "\nNº Avaliações: " + avaliacoes + "\nEstrelas: " + estrelas + "\nendereco: " + endereco + "\nPlusCode: " + pluscode);
                    System.out.println("==============================================================================================================================================");

                }

            } catch (Exception e) {

            }
            driver.quit();


        }

        //List<WebElement> linkEmpresas = containerCard.findElements(By.xpath("//a[@class='hfpxzc']"));


    }
}

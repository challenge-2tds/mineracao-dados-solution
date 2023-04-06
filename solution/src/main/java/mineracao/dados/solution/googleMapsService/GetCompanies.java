package mineracao.dados.solution.googleMapsService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetCompanies {


    public void getAllCompaniesByKey(WebDriver driver) {




        List<WebElement> cardsEmpresa = driver.findElements(By.xpath("//a[@class='hfpxzc']"));

        for (WebElement cardEmpresa : cardsEmpresa) {

            cardEmpresa.click();

            try {


                Thread.sleep(2000);


                String nome = driver.findElement(By.xpath("//div[@class='lMbq3e']/div/h1")).getText();

                String avaliacoes = driver.findElement(By.xpath("//div[@class='F7nice ']/span[2]/span/span")).getText();

                String estrelas = driver.findElement(By.xpath("//span[@class='ceNzKf']")).getAttribute("aria-label");

                String endereco =  driver.findElement(By.xpath("//button[@data-item-id='address']/div/div[3]/div")).getText();

                String pluscode = driver.findElement(By.xpath("//button[@data-tooltip='Copiar Plus Code']/div/div[3]/div")).getText();

                try {
                    String telefone = driver.findElement(By.xpath("//button[@data-tooltip='Copiar número de telefone']/div/div[3]/div")).getText();

                    System.out.println("Nome empresa: " + nome + "\nNº Avaliações: " + avaliacoes + "\nEstrelas: " + estrelas + "\nendereco: " + endereco + "\nTelefone: " + telefone + "\nPlusCode: " + pluscode);
                    System.out.println("==============================================================================================================================================");

                }catch (Exception e) {

                    System.out.println("Nome empresa: " + nome + "\nNº Avaliações: " + avaliacoes + "\nEstrelas: " + estrelas + "\nendereco: " + endereco  + "\nPlusCode: " + pluscode);
                    System.out.println("==============================================================================================================================================");


                }

            } catch (Exception e) {

            }




        }

        //List<WebElement> linkEmpresas = containerCard.findElements(By.xpath("//a[@class='hfpxzc']"));



    }
}

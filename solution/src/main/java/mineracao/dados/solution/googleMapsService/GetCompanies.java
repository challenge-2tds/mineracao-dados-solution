package mineracao.dados.solution.googleMapsService;

import mineracao.dados.solution.googleMapsService.googleMapsInterface.GoogleMapsCompaniesService;
import mineracao.dados.solution.models.GenericEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class GetCompanies implements GoogleMapsCompaniesService {

    private String telefone;

    private String estrelas;

    private String endereco;

    private String avaliacoes;

    private String nome;

    private String pluscode;

    private Long urlCompany;


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


    public List<GenericEntity> getAllCompaniesByKey(WebDriver driver) {

        List<GenericEntity> genericEntityList = new ArrayList<>();


//        List<WebElement> cardsEmpresa = driver.findElements(By.xpath("//a[@class='hfpxzc']"));

        List<WebElement> scrolls = scrollPageAndExtractCompany(driver);

        for (WebElement scroll : scrolls) { //REVER

            scrolls = scrollPageAndExtractCompany(driver);

        }

        for (WebElement cardEmpresa : scrolls) {

            Actions actions = new Actions(driver);

            actions.moveToElement(cardEmpresa).click().perform();


            try {

                Thread.sleep(3000);

                nome = driver.findElement(By.xpath("//div[@class='lMbq3e']/div/h1")).getText();

                avaliacoes = driver.findElement(By.xpath("//div[@class='F7nice ']/span[2]/span/span")).getText();

                estrelas = driver.findElement(By.xpath("//span[@class='ceNzKf']")).getAttribute("aria-label");

                endereco = driver.findElement(By.xpath("//button[@data-item-id='address']/div/div[3]/div")).getText();

                pluscode = driver.findElement(By.xpath("//button[@data-tooltip='Copiar Plus Code']/div/div[3]/div")).getText();

                urlCompany = Long.valueOf(driver.getCurrentUrl());

                try {
                    telefone = driver.findElement(By.xpath("//button[@data-tooltip='Copiar número de telefone']/div/div[3]/div")).getText();


                } catch (Exception e) {


                }


                System.out.println("Nome empresa: " + nome + "\nNº Avaliações: " + avaliacoes + "\nEstrelas: " + estrelas + "\nendereco: " + endereco + "\nTelefone: " + telefone + "\nPlusCode: " + pluscode + "\nLink empresa: " + urlCompany );
                System.out.println("==============================================================================================================================================");


            } catch (Exception e) {

            }
            if (telefone != null) {
                GenericEntity genericEntity = new GenericEntity();
                genericEntity.setPhone(telefone);
                genericEntity.setName(nome);
                genericEntity.setLocalidade(endereco);
                genericEntity.setEstrelas(estrelas);
                genericEntity.setPlusCode(pluscode);
                genericEntity.setLinkProfile(urlCompany);
                genericEntity.setAvaliacoes(avaliacoes);
                genericEntityList.add(genericEntity);

            }


        }


        driver.quit();
        return genericEntityList;


    }
}

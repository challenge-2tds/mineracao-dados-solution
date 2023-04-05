package mineracao.dados.solution.linkedinService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LinkedinUrlUsers {

    private String pageNext = "&page=";


    public List<String> LinkedinUrl(WebDriver driver, String urlSite) {

        List<String> linkUsers = new ArrayList<>();

        List<WebElement> liUsers = new ArrayList<WebElement>();

        for (int i = 1; i <= 1; i++) {

            String numeric = Integer.toString(i);
            System.out.println(numeric);
            driver.get(urlSite + pageNext + numeric);

            liUsers = driver.findElements(By.xpath("//div[@class=\"entity-result__item\"]/div/div/div/div/span/span/a"));

            for (WebElement usuario : liUsers) {

                String usuarioLink = usuario.getAttribute("href");

                if (usuario.getAttribute("href") == "https://www.linkedin.com/search/results/people/headless?origin=CLUSTER_EXPANSION&keywords=ingles%20fluente") {
                    System.out.println("usuario não identificado!");

                } else {
                    linkUsers.add(usuarioLink);

                }


            }
        }


        return linkUsers;

    }

    public void linkedinExtractUserData(WebDriver driver, List<String> linkUsers ) {
        for (String usuarioProfile : linkUsers) {

            try {

                Thread.sleep(5000);

                driver.get(usuarioProfile);


                String nome = driver.findElement(By.xpath("//div[@class='mt2 relative']/div/div/h1")).getText();

                String localidade = driver.findElement(By.xpath("//span[@class='text-body-small inline t-black--light break-words']")).getText();

                WebElement infoLink = driver.findElement(By.xpath("//*[@id=\"top-card-text-details-contact-info\"]"));

                System.out.println("link perfil: " + usuarioProfile + "\nNome: " + nome + "\nLocalidade: " + localidade);

                infoLink.click();

                try {

                    String mail = driver.findElement(By.xpath("//section[@class='pv-contact-info__contact-type ci-email']/div/a")).getText();




                    System.out.println( "email: " + mail);

                } catch (Exception e) {
                    System.out.println("==================================================================================================================================================");
                }


                try {

                    String telefone = driver.findElement(By.xpath("//section[@class='pv-contact-info__contact-type ci-phone']/ul/li/span[1]")).getText();
                    System.out.printf("Telefone: " + telefone);


                }catch (Exception e) {
                    System.out.println("==================================================================================================================================================");

                }








            } catch (Exception e) {

            }
        }
    }



}

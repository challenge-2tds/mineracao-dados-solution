package mineracao.dados.solution.linkedinService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Timer;

public class LinkedinAuth {



    public void loginAuthLinkedin(WebDriver driver)  {

        try {


            //WebElement loginArea = driver.findElement(By.className("main__sign-in-link"));
            WebElement loginArea = driver.findElement(By.xpath("//a[@class='nav__button-secondary btn-md btn-secondary-emphasis']"));

            Thread.sleep(2000);

            loginArea.click();

            WebElement loginForm = driver.findElement(By.id("username"));
            loginForm.sendKeys("jhonatas2004@gmail.com"); //jhonatas2004@gmail.com



            WebElement passForm = driver.findElement(By.id("password"));
            passForm.sendKeys("26042004JHON"); //26042004JHON


            WebElement buttonSend = driver.findElement(By.tagName("button"));
            buttonSend.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

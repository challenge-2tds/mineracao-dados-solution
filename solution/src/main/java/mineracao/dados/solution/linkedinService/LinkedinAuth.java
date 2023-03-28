package mineracao.dados.solution.linkedinService;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Timer;

public class LinkedinAuth {



    public void loginAuthLinkedin(WebDriver driver) {

        WebElement loginArea = driver.findElement(By.tagName("a"));
        loginArea.click();

        WebElement loginForm = driver.findElement(By.id("username"));
        loginForm.sendKeys("jhonatas2004@gmail.com");

        WebElement passForm = driver.findElement(By.id("password"));
        passForm.sendKeys("26042004JHON");

        WebElement buttonSend = driver.findElement(By.id("join-form-submit"));
        buttonSend.click();

    }
}

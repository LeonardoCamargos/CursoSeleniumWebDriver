package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretaPage extends BasicPage {

    public SecretaPage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarMe(){
        navegador.findElement(By.className("me")).click();
        return new MePage(navegador);
    }
}

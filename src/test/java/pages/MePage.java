package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasicPage {
    public MePage(WebDriver navegador) {
        super(navegador);
    }

    public MePage clicarNaPaginaMoreDataAbout(){
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        return this;
    }

    public AddContactPage clicarBotaoMoreDataAbout(){
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();
        return new AddContactPage(navegador);
    }
}
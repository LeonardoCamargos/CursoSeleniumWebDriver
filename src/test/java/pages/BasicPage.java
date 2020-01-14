package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicPage {
    protected WebDriver navegador;

    public BasicPage(WebDriver navegador){
        this.navegador = navegador;
    }
    public String capturarTextoToast(){
        return navegador.findElement(By.id("toast-container")).getText();
    }
}

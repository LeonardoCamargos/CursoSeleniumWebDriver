package suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//Essa classe faz tudo que relacionado ao Web
public class Web {

    public static final String USERNAME = "leonardocamargos1";
    public static final String AUTOMATE_KEY = "GeWpLJgfeYCk7srvf7SA";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public static WebDriver createChrome() {

        // Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "/Users/julio.lima/drivers/chromedriver");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Navegando para a página do Taskit!
        navegador.get("http://www.juliodelima.com.br/taskit");

        return navegador;
    }

    public static WebDriver createBrowserStack() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "79.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1366x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        WebDriver navegador = null;

        try {
            navegador = new RemoteWebDriver(new URL(URL), caps);
            navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            // Navegando para a página do Taskit!
            navegador.get("http://www.juliodelima.com.br/taskit");
        } catch (MalformedURLException e) {
            System.out.println("Houveram problemas com a URL: " + e.getMessage());
        }
        return navegador;
    }

}
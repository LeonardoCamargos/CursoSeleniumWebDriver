package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import suporte.Web;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacoesUsuarioPageObjectsTest.csv")
public class informacoesUsuarioPageObjectsTest {

    private WebDriver nav;

    @Before
    public void setUp(){
        nav = Web.createBrowserStack();
    }

    @Test
    public void Testt(
            @Param(name ="login") String login,
            @Param(name ="senha")String senha,
            @Param(name ="tipo") String tipo,
            @Param(name ="contato")String contato,
            @Param(name ="mensagem")String mensagemEsperada
    ){
                String textoToast = new LoginPage(nav)
                .clickSignIn()
                .fazerLogin(login,senha)
                .clicarMe()
                .clicarNaPaginaMoreDataAbout()
                .clicarBotaoMoreDataAbout()
                .adicionarContato(tipo,contato)
                .capturarTextoToast();


                Assert.assertEquals(mensagemEsperada,textoToast);
    }

    @After
    public void tearDown(){
        nav.quit();
    }
}

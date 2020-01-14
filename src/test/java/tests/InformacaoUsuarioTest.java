package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import suporte.Generator;
import suporte.Screenshoot;
import suporte.Web;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "informacaoUsuarioTest.csv")

public class InformacaoUsuarioTest {
    public WebDriver nav;

    @Rule
    public TestName test = new TestName();


    @Before
    public void setUp(){
        nav = Web.createChrome();

        //Clicando no link que possui o texto Sign In
        //nav.findElement(By.linkText("Sign in")).click();

        //Identificando o formulario de Login
        //WebElement formularioSignInbox = nav.findElement(By.id("signinbox"));

        //Digitar no campo com name login que esta dentro do formulario de id"signinbox" o texto "julio0001"
        //formularioSignInbox.findElement(By.name("login")).sendKeys("julio0001");

        //Digitar no campo com name login que esta dentro do formulario de id"signinbox" o texto "123456"
        //formularioSignInbox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link com texto "SIGN IN"
        //nav.findElement(By.linkText("SIGN IN")).click();

        //Validar que dentro do elemento com classe "me" está o texto "Hi,julio
        WebElement me = nav.findElement(By.className("me"));
        String textoElementoMe = me.getText();
        Assert.assertEquals("Hi, Julio",textoElementoMe);

        //clicar no botao que tenha a class me
        nav.findElement(By.className("me")).click();

        //Clicar em um link que possui o texto More Data About
        nav.findElement(By.linkText("MORE DATA ABOUT YOU")).click();

    }

    @Test
    public void Testt(@Param(name = "tipo")String tipo,@Param(name = "contato")String contato,@Param(name = "mensagem")String MensagemEsperada){
        //Clicar no botao através do seu xpath//button[@data-target="addmoredata"]
        nav.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar o popup onde está o formulário de id addmoredata
        WebElement popupAddMoreData = nav.findElement(By.id("addmoredata"));

        //No combo de name "type" escolha a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText(tipo);//Dados de entrada

        //No campo de name "contact" digitar "zzzzzzzz"
        popupAddMoreData.findElement(By.name("contact")).sendKeys(contato);//Dados de Saída

        //Clicar no Link do text "Save" que está no poup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();
        //Na mensagem de id "text -container" validar que o texto é "Your Contact has been added"
        WebElement mensagemPop = nav.findElement(By.id("toast-container"));
        String mensagem = mensagemPop.getText();
        Assert.assertEquals(MensagemEsperada,mensagem);
    }

    //@Test
    public void removerContatoDeUmUsuario(){
        //Clicar no elemento pelo seu xpath //span[text()="number"]/following-sibLing::a
        //nav.findElement(By.xpath("//span[text()=\"551933334444\"]/following-sibling::a"));

        nav.findElement(By.xpath("//span[text()='+5527983832733']/following-sibling::a")).click();

        //Clicar na janela do javaScript
        nav.switchTo().alert().accept();
        nav.switchTo().activeElement().sendKeys();
        //Confirmar se mensagem"Rest in peace, dear phone!
        WebElement mensagemPop2 = nav.findElement(By.id("toast-container"));
        String mensagem2 = mensagemPop2.getText();
        Assert.assertEquals("Rest in peace, dear phone!",mensagem2);

        String screenshotArquivo = "C:\\Users\\lcamargo\\ScreenTest\\Taskit\\" + Generator.datahoraparaarquivo() + test.getMethodName()+".png";
        Screenshoot.tirar(nav,screenshotArquivo);

        //Aguardar até 10 segundos para que a janela desapareca"Experaexplicita"
        WebDriverWait aguardar = new WebDriverWait(nav,10);
        aguardar.until(ExpectedConditions.stalenessOf(mensagemPop2));

        //fazer o logout
        nav.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        //fechando o navegador        sleep(1000);
        //nav.close();
    }

}

import Steps.BaseSteps;
import Steps.GoogleSteps;
import Steps.calis;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.junit.Assert.fail;

public class GoogleTest extends BaseTest {
    private WebDriver webDriver = getWebDriver(); //sólo necesitamos un getwebdriver, por eso lo renombra aquí
    private GoogleSteps googleSteps = new GoogleSteps(webDriver);


    @Test
    public void openGoogle() { //tienen que ser publicos los test no olvidar
        webDriver.get("https://www.google.com");
        String urlActual = webDriver.getCurrentUrl();
        System.out.println("La url atual es " + urlActual);
        // Assert.assertEquals(urlActual.contains("https://www.google.com"), true);
        Assert.assertEquals(urlActual.contains("https://www.google.com"), true);
    }

    @Test
    public void titleGoogleTest() {
        String tituloEsperado = "Google";
        googleSteps.openPageGoogle();
        Assert.assertEquals(tituloEsperado, googleSteps.getTituloActual());
        System.out.println("El título de la página es" + googleSteps.getTituloActual());
    }

    @Test
    public void openPageGoogle() {
        boolean paginaAbierta = true;
        googleSteps.openPageGoogle();
        Assert.assertEquals(paginaAbierta, googleSteps.openPageGoogle()); //confirma si se abríó la página

    }

    @Test
    public void getUrl() {
        googleSteps.openPageGoogle();
        String urlExpected = "www.google.com";
        String urlNotExpected = "www.gogle.com";
        System.out.println("La URL de la página es: " + googleSteps.getURLActual());
        Assert.assertEquals(urlNotExpected, urlExpected);

    }

    @Test
    public void isPageClose() {
        boolean closePage = googleSteps.cerrarVentana();
        boolean isClose = true;
        Assert.assertEquals(isClose, closePage);
        System.out.println("La página ha sido cerrada");
    }

    @Test
    public void getSourceCode() {
        String textExpected = "Hola";
        String textActual = googleSteps.getCodigoFuente();
         Assert.assertEquals(textActual, textExpected);
        }

    }

package testes;

import core.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import pages.MenuPage;
import pages.WebViewPage;

public class WebViewTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private WebViewPage webViewPage = new WebViewPage();

    @Test
    public void deveFazerLogin() {
        menuPage.acessarSeuBarHibrido();
        esperar(3000);
        webViewPage.entrarContextoWeb();
        webViewPage.setEmail("mathews@ma.com");
        webViewPage.setSenha("1234567");
        webViewPage.clicarBotaoEntrar();
        Assert.assertEquals("Bem vindo, Mathews!", webViewPage.getMensagemCabecalho());

    }

    @After
    public void tearDown() {
        webViewPage.sairContextoWeb();
    }
}

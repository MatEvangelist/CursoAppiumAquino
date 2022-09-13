package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.MenuPage;
import pages.SplashPage;

public class SplashTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SplashPage splashPage = new SplashPage();

    @Before
    public void entrarSplash() {
        menuPage.acessarSplash();
    }

    @Test
    public void deveAguardarSplashSumir() {
        splashPage.isTelaSplashVisivel();
        splashPage.aguardarSplashSumir();
        Assert.assertTrue(splashPage.existeElementoPorTexto("Formulário"));
    }
}

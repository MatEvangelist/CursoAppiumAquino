package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.MenuPage;

public class OpcaoEscondidaTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Before
    public void entrarAbas() {
        menuPage.acessarOpcaoEscondida();
    }

    @Test
    public void deveEncontrarOpcaoEscondida() {
        Assert.assertEquals("Você achou essa opção",
                menuPage.obterMensagemAlerta(By.id("android:id/message")));

        menuPage.clicarPorTexto("OK");

    }
}

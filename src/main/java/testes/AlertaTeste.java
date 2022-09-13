package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.AlertasPage;
import pages.MenuPage;

import static org.junit.Assert.assertEquals;

public class AlertaTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertasPage alertasPage = new AlertasPage();

    @Before
    public void entrarAlerta() {
        menuPage.acessarAlertas();
    }

    @Test
    public void deveConfirmarAlerta() {
        alertasPage.clicarAlertaConfirm();
        assertEquals("Info", alertasPage.obterTituloAlertaPage());
        assertEquals("Confirma a operação?", alertasPage.obterMensagemAlertaPage());
        alertasPage.confirmar();
        assertEquals("Confirmado", alertasPage.obterMensagemAlertaPage());
        alertasPage.sair();
    }

    @Test
    public void deveClicarForaAlerta() {
        alertasPage.clicarAlertaSimples();
        esperar(1000);
        alertasPage.clicarForaCaixa();
        Assert.assertFalse(alertasPage.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
    }
}

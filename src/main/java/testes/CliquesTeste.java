package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.CliquesPage;
import pages.MenuPage;

public class CliquesTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private CliquesPage cliquesPage = new CliquesPage();

    @Before
    public void entrarCliques() {
        menuPage.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo() {
        cliquesPage.cliqueLongo();
        Assert.assertEquals("Clique Longo", cliquesPage.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo() {
        cliquesPage.cliqueDuploRapido();
        Assert.assertEquals("Duplo Clique", cliquesPage.obterTextoCampo());
    }
}

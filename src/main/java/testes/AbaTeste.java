package testes;

import core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.AbasPage;
import pages.MenuPage;

import static org.junit.Assert.*;

public class AbaTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();

    @Before
    public void entrarAbas() {
        menuPage.acessarAbas();
    }

    @Test
    public void deveInteragirComAbas() {
        assertTrue(abasPage.isAba1());
        assertFalse(abasPage.isAba2());
        assertEquals("Este é o conteúdo da Aba 1", abasPage.obterMensagemAba1());

        abasPage.acessarAba2();
        assertTrue(abasPage.isAba2());
        assertFalse(abasPage.isAba1());
        assertEquals("Este é o conteúdo da Aba 2", abasPage.obterMensagemAba2());

        abasPage.acessarAba1();
        assertTrue(abasPage.isAba1());
        assertFalse(abasPage.isAba2());
        assertEquals("Este é o conteúdo da Aba 1", abasPage.obterMensagemAba1());
    }
}

package testes;

import core.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.AccordionPage;
import pages.MenuPage;

public class AccordionTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();

    @Before
    public void entrarAccordion() {
        menuPage.acessarAccordion();
    }

    @Test
    public void deveInteragirComAccordion() {
        accordionPage.clicarOpcao1();
        esperar(1000);
        Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.obterValorOp1());
    }
}

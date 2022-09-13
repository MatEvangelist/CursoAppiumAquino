package testes;

import core.BaseTest;
import org.junit.Test;
import pages.MenuPage;
import pages.SwipeListPage;

import static org.junit.Assert.assertTrue;

public class SwipeTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    public void deveRealizarSwipe() {
        menuPage.acessarSwipe();
        assertTrue(menuPage.existeElementoPorTexto("Mova a tela para"));
        menuPage.swipeRight();
        assertTrue(menuPage.existeElementoPorTexto("E veja se"));
        menuPage.swipeRight();
        assertTrue(menuPage.existeElementoPorTexto("Chegar até o fim!"));
        menuPage.swipeLeft();
        assertTrue(menuPage.existeElementoPorTexto("você consegue"));
        menuPage.swipeLeft();
        assertTrue(menuPage.existeElementoPorTexto("a esquerda"));
    }

    @Test
    public void desafioSwipeList() {
        menuPage.acessarSwipeList();
        assertTrue(menuPage.existeElementoPorTexto("Opção 1"));
        swipeListPage.swipeElementRight("Opção 1");
        swipeListPage.clicarBotaoMais();
        assertTrue(menuPage.existeElementoPorTexto("Opção 1 (+)"));
        swipeListPage.swipeElementRight("Opção 4");
        swipeListPage.clicarPorTexto("(-)");
        assertTrue(menuPage.existeElementoPorTexto("Opção 4 (-)"));
        swipeListPage.swipeElementLeft("Opção 5 (-)");
        assertTrue(menuPage.existeElementoPorTexto("Opção 5"));
    }

}

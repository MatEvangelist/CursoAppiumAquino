package testes;

import core.BaseTest;
import org.junit.Test;
import pages.DragNDropPage;
import pages.MenuPage;

import static org.junit.Assert.assertArrayEquals;

public class DragNDropTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private DragNDropPage dragNDropPage = new DragNDropPage();
    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    public void deveEfetuarDragAndDrop () {
        menuPage.acessarDragAndDrop();
        esperar(1000);
        assertArrayEquals(estadoInicial, dragNDropPage.obterLista());
        dragNDropPage.arrastar("Esta", "e arraste para");
        assertArrayEquals(estadoIntermediario, dragNDropPage.obterLista());
        dragNDropPage.arrastar("Faça um clique longo,", "é uma lista");
        assertArrayEquals(estadoFinal, dragNDropPage.obterLista());
    }
}

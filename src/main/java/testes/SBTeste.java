package testes;

import core.BaseTest;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SBTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SBLoginPage sbLoginPage = new SBLoginPage();
    private SBMenuPage sbMenuPage = new SBMenuPage();
    private SBContasPage sbContasPage = new SBContasPage();
    private SBMovimentacoesPage sbMovimentacoesPage = new SBMovimentacoesPage();
    private SBHomePage sbHomePage = new SBHomePage();

    private SBResumoPage sbResumoPage = new SBResumoPage();

    @Before
    public void setup() {
        menuPage.acessarSeuBarNativo();
        sbLoginPage.setEmail("mathews@ma.com");
        sbLoginPage.setSenha("1234567");
        sbLoginPage.clicarBotaoEntrar();
    }

    @Test
    public void deveInserirContaComSucesso() {
        sbMenuPage.acessarContas();
        sbContasPage.digitarNovaConta("Conta de Testad");
        sbContasPage.clicarSalvar();
        esperar(2000);
        assertEquals("Conta adicionada com sucesso", sbContasPage.obterTextoCabecalho());
        assertTrue(sbContasPage.existeElementoPorTexto("Conta adicionada com sucesso"));
    }

    @Test
    public void deveExcluirContaComSucesso() {
        sbMenuPage.acessarContas();
        sbContasPage.selecionarConta("Conta de Testad");
        sbContasPage.clicarExcluir();
        esperar(2000);
        assertEquals("Conta excluída com sucesso", sbContasPage.obterTextoCabecalho());
        assertTrue(sbContasPage.existeElementoPorTexto("Conta excluída com sucesso"));
    }

    @Test
    public void devevalidarInclusao() {
        sbMenuPage.acessarMov();
        sbMovimentacoesPage.salvar();
        assertTrue(sbMovimentacoesPage.existeElementoPorTexto("Descrição é um campo obrigatório"));

        sbMovimentacoesPage.setDescricao("Descricao escrita");
        sbMovimentacoesPage.salvar();
        assertTrue(sbMovimentacoesPage.existeElementoPorTexto("Interessado é um campo obrigatório"));

        sbMovimentacoesPage.setInteressado("Mathews");
        sbMovimentacoesPage.salvar();
        assertTrue(sbMovimentacoesPage.existeElementoPorTexto("Valor é um campo obrigatório"));

        sbMovimentacoesPage.setValor(1111.11);
        sbMovimentacoesPage.salvar();
        assertTrue(sbMovimentacoesPage.existeElementoPorTexto("Conta é um campo obrigatório"));


        sbMovimentacoesPage.selecionarConta("Conta para alterar");
        sbMovimentacoesPage.salvar();
        assertTrue(sbMovimentacoesPage.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
    }

    @Test
    public void deveAtualizarSaldoAoExcluirMovimentacao() {
        assertEquals("534.00", sbHomePage.obterSaldoConta("Conta para saldo"));
        sbMenuPage.acessarResumo();
        sbResumoPage.excluirMovimentacao("Movimentacao 3, calculo saldo");
        assertTrue(sbResumoPage.existeElementoPorTexto("Movimentação removida com sucesso!"));
        sbMenuPage.acessarHome();
        esperar(1500);
        sbHomePage.scroll(0.2, 0.9);
        assertEquals("-1000.00", sbHomePage.obterSaldoConta("Conta para saldo"));
    }
}

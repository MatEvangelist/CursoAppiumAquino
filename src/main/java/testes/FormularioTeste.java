package testes;

import core.BaseTest;
import core.DriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.FormularioPage;
import pages.MenuPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class FormularioTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void entrarFormulario() {
        menuPage.acessarFormulario();
    }

    @Test
    public void devePrencherCampoNome() {
        formularioPage.escreverCampoNome("Mathews");
        assertEquals("Mathews", formularioPage.obterNome());
    }

    @Test
    public void deveInteragirComCombo() {
        formularioPage.selecionarComboConsoles("Nintendo Switch");
        assertEquals("Nintendo Switch", formularioPage.obterValorComboConsoles());
    }

    @Test
    public void deveInteragirComSwitchCheckBox() {
        assertFalse(formularioPage.isCheckMarcado());
        assertTrue(formularioPage.isSwitchOn());

        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        assertTrue(formularioPage.isCheckMarcado());
        assertFalse(formularioPage.isSwitchOn());
    }

    @Test
    public void deveRealizarCadastro() {
        String nomeEnviado = "Mathews Desafio";
        formularioPage.escreverCampoNome(nomeEnviado);
        formularioPage.selecionarComboConsoles("PS4");
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();
        formularioPage.clicarSalvar();

        assertEquals("Nome: " + nomeEnviado, formularioPage.obterNomeCdastrado());
        assertEquals("Console: ps4", formularioPage.obterConsoleCadastrado());
        assertTrue(formularioPage.obterCheckCadastrao().endsWith("Off"));
        assertTrue(formularioPage.obterSwitchCadastrado().endsWith("Marcado"));
    }


    @Test
    public void deveRealizarCadastroDemorado() {
        String nomeEnviado = "Mathews Desafio";
        formularioPage.escreverCampoNome(nomeEnviado);

        DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        formularioPage.clicarSalvarDemorado();
//        esperar(3000);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]")));

        assertEquals("Nome: " + nomeEnviado, formularioPage.obterNomeCdastrado());
    }

    @Test
    public void deveAlterarData() {
        formularioPage.clicarOpcaoData();
        formularioPage.alterarData("20");
        formularioPage.confirmarData();
        assertTrue(formularioPage.obterDataAlterada("20/01/2000"));
    }

    @Test
    public void deveAlterarHora() {
        formularioPage.clicarOpcaoHora();
        formularioPage.AlterarHora("22", "55");
        formularioPage.confirmarHorario();
        assertTrue(formularioPage.obterHorarioAlterado("22:55"));
    }

    @Test
    public void deveInteragirComSeekbar() {
        formularioPage.clicarSeekbar(0.78);
        formularioPage.clicarSalvar();
        Assert.assertEquals("Slider: 78", formularioPage.obterSeekbarCadastrada());
    }
}

package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.DriverFactory.getDriver;

public class MenuPage extends BasePage {

    public void acessarFormulario() {
        super.clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        super.clicarPorTexto("Splash");
    }

    public void acessarAlertas() {
        super.clicarPorTexto("Alertas");
    }

    public void acessarAbas() {
        super.clicarPorTexto("Abas");
    }

    public void acessarAccordion() {
        super.clicarPorTexto("Accordion");
    }

    public void acessarCliques() {
        super.clicarPorTexto("Cliques");
    }

    public void acessarSwipe() {
        super.clicarPorTexto("Swipe");
    }
    public void acessarOpcaoEscondida() {
        rolarMenuPraBaixo();
        super.clicarPorTexto("Opção bem escondida");
    }

    public void acessarSwipeList() {
        rolarMenuPraBaixo();
        super.clicarPorTexto("Swipe List");
    }

    public void acessarDragAndDrop() {
        rolarMenuPraBaixo();
        super.clicarPorTexto("Drag and drop");
    }

    public void rolarMenuPraBaixo() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        super.scrollDown();
    }

    public void acessarSeuBarHibrido() {
        super.clicarPorTexto("SeuBarriga Híbrido");
    }

    public void acessarSeuBarNativo() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
        super.clicarPorTexto("SeuBarriga Nativo");
    }
}

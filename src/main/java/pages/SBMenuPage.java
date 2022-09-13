package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class SBMenuPage extends BasePage {

    public void acessarContas() {
        clicar(By.xpath("//*[@text='Contas']"));
//        clicarPorTexto("Contas");
    }

    public void acessarMov() {
        clicarPorTexto("Mov...");
    }

    public void acessarResumo() {
        clicarPorTexto("Resumo");
    }

    public void acessarHome() {
        clicarPorTexto("Home");
    }


}

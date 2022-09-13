package pages;

import core.BasePage;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class SBContasPage extends BasePage {

    public void digitarNovaConta(String nomeConta) {
        escrever(By.xpath("//*[@text='Conta']"), nomeConta);
    }

    public void clicarSalvar() {
        clicarPorTexto("SALVAR");
    }

    public void selecionarConta(String conta) {
        cliqueLongo(By.xpath("//*[@text='" + conta + "']"));
    }

    public void clicarExcluir() {
        clicarPorTexto("EXCLUIR");
    }

    public String obterTextoCabecalho() {
//        return getDriver().findElement(By.className("android.widget.TextView")).getText();
        return getDriver().findElement(By.xpath("//android.widget.TextView[@index='3']")).getText();
    }
}

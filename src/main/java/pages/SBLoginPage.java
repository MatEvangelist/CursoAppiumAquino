package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class SBLoginPage extends BasePage {

    public void setEmail(String valor) {
        escrever(By.xpath("//*[@text='Nome']"), valor);
    }

    public void setSenha(String valor) {
        escrever(By.xpath("//android.widget.EditText[2]"), valor);
    }

    public void clicarBotaoEntrar() {
        clicarPorTexto("ENTRAR");
    }


}

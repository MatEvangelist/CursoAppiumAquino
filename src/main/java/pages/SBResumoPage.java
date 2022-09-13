package pages;

import core.BasePage;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class SBResumoPage extends BasePage {

    public void excluirMovimentacao(String descricao) {
        MobileElement element = getDriver().findElement(By.xpath("//*[@text='" + descricao + "']/.."));
        super.swipeElement(element, 0.9, 0.1);

        super.clicarPorTexto("Del");
    }
}

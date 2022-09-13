package pages;

import core.BasePage;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void cliqueLongo() {
        cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
    }

    public void cliqueDuploRapido() {
        super.clicarPorTexto("Clique duplo");
        super.clicarPorTexto("Clique duplo");
    }

    public String obterTextoCampo() {
        return getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
    }
}

package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class SBHomePage extends BasePage {

    public String obterSaldoConta(String conta) {
        return obterTexto(By.xpath(
                "//*[@text='" + conta + "']/following-sibling::android.widget.TextView"));
    }
}

package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class AccordionPage extends BasePage {

    public void clicarOpcao1() {
        super.clicarPorTexto("Opção 1");
    }

    public String obterValorOp1() {
        return super.obterTexto(By.xpath("//android.widget.TextView[@text='Opção 1']/../../following-sibling::android.view.ViewGroup//android.widget.TextView"));
    }
}

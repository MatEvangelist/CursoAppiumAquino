package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class AbasPage extends BasePage {

    public String obterMensagemAba1() {
        return super.obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 1']"));
    }

    public String obterMensagemAba2() {
        return super.obterTexto(By.xpath("//*[@text='Este é o conteúdo da Aba 2']"));
    }

    public boolean isAba1() {
        return super.existeElementoPorTexto("Este é o conteúdo da Aba 1");
    }

    public boolean isAba2() {
        return super.existeElementoPorTexto("Este é o conteúdo da Aba 2");
    }

    public void acessarAba1() {
        super.clicarPorTexto("Aba 1");
    }

    public void acessarAba2() {
        super.clicarPorTexto("Aba 2");
    }

}

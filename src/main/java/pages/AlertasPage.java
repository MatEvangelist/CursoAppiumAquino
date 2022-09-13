package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class AlertasPage extends BasePage {

    public void clicarAlertaConfirm() {
        super.clicarPorTexto("ALERTA CONFIRM");
    }

    public void clicarAlertaSimples() {
        super.clicarPorTexto("ALERTA SIMPLES");
    }

    public String obterTituloAlertaPage() {
        return super.obterTituloAlerta(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlertaPage() {
        return super.obterMensagemAlerta(By.id("android:id/message"));
    }

    public void confirmar() {
        super.clicarPorTexto("CONFIRMAR");
    }

    public void sair() {
        super.clicarPorTexto("SAIR");
    }

    public void clicarForaCaixa() {
        super.tap(100, 150);
    }
}

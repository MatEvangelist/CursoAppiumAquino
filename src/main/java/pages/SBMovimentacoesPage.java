package pages;

import core.BasePage;
import org.openqa.selenium.By;

public class SBMovimentacoesPage extends BasePage {

    public void salvar() {
        clicarPorTexto("SALVAR");
    }

    public void setDescricao(String descricao) {
        escrever(By.xpath("//android.widget.EditText[@text='Descrição']"), descricao);
    }

    public void setInteressado(String interessado) {
        escrever(By.xpath("//android.widget.EditText[@text='Interessado']"), interessado);
    }

    public void setValor(double valor) {
        escrever(By.xpath("//android.widget.EditText[@text='Valor']"), String.valueOf(valor));
    }

    public void selecionarConta(String opcao) {
        selecionarCombo(By.xpath("//android.widget.Spinner[@index='9']"), opcao);
    }
}

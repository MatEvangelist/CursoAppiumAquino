package pages;

import core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static core.DriverFactory.getDriver;

public class FormularioPage extends BasePage {

    public void escreverCampoNome(String texto) {
        super.escrever(MobileBy.AccessibilityId("nome"), texto);
    }

    public String obterNome() {
        return super.obterTexto(MobileBy.AccessibilityId("nome"));
    }

    public void selecionarComboConsoles(String valor) {
        super.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
    }

    public String obterValorComboConsoles() {
        return super.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
    }

    public void clicarCheck() {
        super.clicar(By.className("android.widget.CheckBox"));
    }

    public void clicarSwitch() {
        super.clicar(MobileBy.AccessibilityId("switch"));
    }

    public boolean isCheckMarcado() {
        return super.isCheckMarcado(By.className("android.widget.CheckBox"));
    }

    public boolean isSwitchOn() {
        return super.isCheckMarcado(MobileBy.AccessibilityId("switch"));
    }

    public void clicarSalvar() {
        super.clicarPorTexto("SALVAR");
    }

    public String obterNomeCdastrado() {
        return super.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
    }

    public String obterConsoleCadastrado() {
        return super.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
    }

    public String obterCheckCadastrao() {
        return super.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
    }

    public String obterSwitchCadastrado() {
        return super.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
    }

    public void clicarSalvarDemorado() {
        super.clicarPorTexto("SALVAR DEMORADO");
    }

    public void clicarOpcaoData() {
        super.clicarPorTexto("01/01/2000");
    }

    public void alterarData(String dia) {
        super.clicarPorTexto(dia);
    }

    public void confirmarData() {
        super.clicarPorTexto("OK");
    }

    public boolean obterDataAlterada(String data) {
        return super.existeElementoPorTexto(data);
    }

    public void clicarOpcaoHora() {
        super.clicarPorTexto("12:00");
    }

    public void AlterarHora(String hora, String minuto) {
        super.clicar(MobileBy.AccessibilityId(hora));
        super.clicar(MobileBy.AccessibilityId(minuto));
    }

    public void confirmarHorario() {
        confirmarData();
    }

    public boolean obterHorarioAlterado(String horario) {
        return super.existeElementoPorTexto(horario);
    }

    public void clicarSeekbar(double posicao) {
        MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
        int delta = 45;
        double y = seek.getLocation().y + (seek.getSize().height / 2);
        System.out.println(y);

        double xInicial = seek.getLocation().x + (delta);
        double x = (int) (xInicial + ((seek.getSize().width - 2 * delta) * posicao));

        tap((int) x, (int) y);
    }

    public String obterSeekbarCadastrada() {
        return super.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
    }
}

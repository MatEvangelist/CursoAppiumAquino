package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.time.Duration;
import java.util.List;

import static core.DriverFactory.getDriver;

public class BasePage {

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }
    public void clicarPorTexto(String texto) {
        clicar(By.xpath("//*[@text='" + texto + "']"));
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto) {
        List<MobileElement> elements = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
        return elements.size() >0;
    }

    public void tap(int x, int y) {
        new TouchAction<>(getDriver()).tap(PointOption.point(new Point(x, y))).perform();
    }

    public void scroll(double start, double end) {
        Dimension size = getDriver().manage().window().getSize();

        int x = size.width / 2;

        int start_y = (int) (size.height * start);
        int end_y = (int) (size.height * end);

        new TouchAction<>(getDriver())
                .press(PointOption.point(new Point(x, start_y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(new Point(x, end_y)))
                .release()
                .perform();
    }

    public void scrollDown() {
        scroll(0.9, 0.1);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void swipe(double start, double end) {
        Dimension size = getDriver().manage().window().getSize();

        int y = size.height / 2;

        int start_x = (int) (size.width * start);
        int end_x = (int) (size.width * end);

        new TouchAction<>(getDriver())
                .press(PointOption.point(new Point(start_x, y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(new Point(end_x, y)))
                .release()
                .perform();
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public void swipeElement(MobileElement element, double start, double end) {
        int y = element.getLocation().y + (element.getSize().height / 2);

        int start_x = (int) (element.getSize().width * start);
        int end_x = (int) (element.getSize().width * end);

        new TouchAction<>(getDriver())
                .press(PointOption.point(new Point(start_x, y)))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(new Point(end_x, y)))
                .release()
                .perform();
    }

    public String obterTituloAlerta(By by) {
        return obterTexto(by);
    }

    public String obterMensagemAlerta(By by) {
        return obterTexto(by);
    }

    public void cliqueLongo(By by) {
        new TouchAction<>(getDriver())
                .longPress(PointOption.point(getDriver().findElement(by).getCenter())).release().perform();
    }
}

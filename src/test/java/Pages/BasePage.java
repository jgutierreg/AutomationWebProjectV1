package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    // Bloque estático para inicializar el WebDriver y WebDriverWait
    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Constructor que acepta una instancia externa de WebDriver
    public BasePage(WebDriver driver) {
        String pathToChromedriver = "src/test/ChromeDrivers/chromedriver.exe";
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver", pathToChromedriver);
    }

    // Navegar a una URL dada
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Cerrar el navegador
    public static void closeBrowser() {
        driver.quit();
    }

    // Método privado para encontrar un WebElement por XPath con espera explícita
    private WebElement findByXpath(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    // Desplazarse hacia abajo hasta un elemento específico en la página
    public void scrollDownToElement(String locator) {
        WebElement element = findByXpath(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Hacer clic en un WebElement si está habilitado
    public void clickElement(String locator) {
        WebElement element = findByXpath(locator);
        if (element.isEnabled()) {
            element.click();
        }
    }

    // Borrar un campo de entrada de texto y escribir texto en él
    public void write(String locator, String text) {
        findByXpath(locator).clear();
        findByXpath(locator).sendKeys(text);
    }

    // Seleccionar una opción de un menú desplegable por texto visible
    public void selectFromDropdownByValue(String locator, String valueSelect) {
        Select dropdown = new Select(findByXpath(locator));
        dropdown.selectByVisibleText(valueSelect);
    }

    // Seleccionar una opción de un menú desplegable por índice
    public void selectFromDropdownByIndex(String locator, int valueSelect) {
        Select dropdown = new Select(findByXpath(locator));
        dropdown.selectByIndex(valueSelect);
    }

    // Obtener el texto visible de la opción seleccionada en un menú desplegable
    public String getTextFromDropdownByValue(String locator) {
        Select dropdown = new Select(findByXpath(locator));
        return dropdown.getFirstSelectedOption().getText();
    }

    // Mover el cursor del mouse sobre un WebElement
    public void hoverOverElement(String locator) {
        action.moveToElement(findByXpath(locator));
    }

    // Hacer doble clic en un WebElement
    public void doubleClickElement(String locator) {
        action.doubleClick(findByXpath(locator));
    }

    // Hacer clic derecho en un WebElement
    public void rightClick(String locator) {
        action.contextClick(findByXpath(locator));
    }

    // Obtener el texto de una celda específica en una tabla
    public String getValueFromTable(String locator, String row, String column) {
        String cell = locator + "/table/tbody/tr[" + row + "]/td[" + column + "]";
        return findByXpath(cell).getText();
    }

    // Verificar si un WebElement está visible
    public boolean elementIsDisplayed(String locator) {
        return findByXpath(locator).isDisplayed();
    }

    // Cambiar a un iframe utilizando su índice
    public void switchToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    // Cambiar de nuevo al iframe principal
    public void switchToParentiFrame() {
        driver.switchTo().parentFrame();
    }

    // Descartar una alerta
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    // Obtener una lista de WebElements basados en un localizador
    public List<WebElement> elementList(String locator) {
        return driver.findElements(By.xpath(locator));
    }
}

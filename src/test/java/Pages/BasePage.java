package Pages;



import org.junit.After;
import org.junit.Before;
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

    static{
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    public BasePage(WebDriver driver){
        String pathToChromedriver = "src/test/ChromeDrivers/chromedriver.exe";
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        System.setProperty("webdriver.chrome.driver", pathToChromedriver);
    }

    public static void closeDriver() {
        driver.quit();
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement findByXpath(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void scrollDownToElement(String locator){
        WebElement element = findByXpath(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickElement(String locator){
        WebElement element = findByXpath(locator);
       if(element.isEnabled()){
           element.click();
       }

    }
    public void write(String locator,String text){
        findByXpath(locator).clear();
        findByXpath(locator).sendKeys(text);
    }
    public void selectFromDropdownByValue(String locator,String valueSelect){
        Select dropdown = new Select (findByXpath(locator));
        dropdown.selectByVisibleText(valueSelect);
    }
    public void selectFromDropdownByIndex(String locator,int valueSelect){
        Select dropdown = new Select (findByXpath(locator));
        dropdown.selectByIndex(valueSelect);
    }

    public String getTextFromDropdownByValue(String locator){
        Select dropdown = new Select (findByXpath(locator));
        return dropdown.getFirstSelectedOption().getText();
    }

    public void hoverOverElement(String locator){
        action.moveToElement(findByXpath(locator));
    }

    public void doubleClickElement(String locator){
        action.doubleClick(findByXpath(locator));
    }

    public void rigthClick(String locator){
        action.contextClick(findByXpath(locator));
    }

    public String getValueFromTable(String locator, String row, String column){
        String cell = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return findByXpath(cell).getText();
    }

    public boolean elementIsDisplayed (String locator){
        return findByXpath(locator).isDisplayed();
    }

    public void switchToiFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentiFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public List<WebElement> elementList(String locator){
        return driver.findElements(By.xpath(locator));}
}


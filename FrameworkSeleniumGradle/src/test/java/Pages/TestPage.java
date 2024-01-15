package Pages;

import org.openqa.selenium.WebDriver;

public class TestPage extends BasePage {

    public TestPage() {super(driver);}

    private String hrefOptionForTable = "//a[@id='tablestest']";
    private String table = "//div[@id='tablehere']";

    public void navigateToTestPage(){navigateTo("https://testpages.eviltester.com");}

    public void clickToOptionForTable(){clickElement(hrefOptionForTable);}

    public boolean tableIsDisplayed(){return elementIsDisplayed(table);}
    public String getTextFromTable(String row, String column){return getValueFromTable(table, row, column);}

}

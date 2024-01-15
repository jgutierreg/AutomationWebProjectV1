package Pages;

import org.junit.Assert;

public class DemoQaPage extends BasePage {
    public DemoQaPage(){super(driver);}

    private String dropdownOldStyle = "//select[@id='oldSelectMenu']";

    public void navigateToWebQa(){
        navigateTo("https://demoqa.com/");
    }


    public void clickToOptionsCards(String option){
        String locatorCard = "//div[@class='card-body'][contains(.,'"+option+"')]";
        clickElement(locatorCard);
    }

    public void clickOptionsElementTest(String option){

        String locatorOption = "//li[contains(.,'"+option+"')]";
        scrollDownToElement(locatorOption);
        clickElement(locatorOption);
    }

    public void selectValueForOldStyle(String value){
        selectFromDropdownByValue(dropdownOldStyle,value);
        String valueSelect = getTextFromDropdownByValue(dropdownOldStyle);
        System.out.println("Valor actual: "+valueSelect);
        Assert.assertEquals(value, valueSelect);
    }

}

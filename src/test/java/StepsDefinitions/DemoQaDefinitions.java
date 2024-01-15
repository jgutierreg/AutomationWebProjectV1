package StepsDefinitions;
import Pages.DemoQaPage;
import io.cucumber.java.en.*;

public class DemoQaDefinitions {
    DemoQaPage demoQaPage = new DemoQaPage();

    @Given("me dirijo a DemoQA")
    public void navigateToDemoQa() {
        demoQaPage.navigateToWebQa();
    }

    @When("hago click sobre la opcion {string}")
    public void clickOptionsDemoQa(String option){
        demoQaPage.clickToOptionsCards(option);
    }

    @Then("selecciono el elemento web a probar {string}")
    public void clickOptionsElementsDemoQa(String option){demoQaPage.clickOptionsElementTest(option);}

    @And("selecciono los valor para dropdown {string}")
    public void selectValueForOldStyle(String value){
        demoQaPage.selectValueForOldStyle(value);
    }
}

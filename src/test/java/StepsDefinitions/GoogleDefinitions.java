package StepsDefinitions;

import Pages.GooglePage;
import io.cucumber.java.en.*;

public class GoogleDefinitions {
    GooglePage googlePage = new GooglePage();

    @Given("voy a google")
    public void navigateToGoogle() {
     googlePage.navigateToGoogle();
    }

    @When("busco algo {string}")
    public void searchSomething(String text) {
        googlePage.searchCriteria(text);
        googlePage.clickSearchButton();
    }

    @Then("obtengo el resultado")
    public void validateResults(){

    }

}

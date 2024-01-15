package StepsDefinitions;
import Pages.TestPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class TestPageDefinition {
    TestPage testPage = new TestPage();
    private String textActual;

    @Given("me dirijo a TestPage")
    public void navigateToTestPage(){testPage.navigateToTestPage();}

    @When("selecciono la opcion de 'Table test page'")
    public void selectOptionForTable(){testPage.clickToOptionForTable();}

    @Then("obtengo el texto en la tabla de la fila {string} y la columna {string}")
    public void getTextFromTable(String row, String column){
         Assert.assertTrue("La tabla no esta visible",testPage.tableIsDisplayed());
         textActual = testPage.getTextFromTable(row , column);
         System.out.println("Valor obtenido de la tabla: "+textActual);
    }

    @And("valido que el texto obtenido sea {string}")
    public void validateText(String validateValue){
        Assert.assertEquals(validateValue,textActual);
    }
}

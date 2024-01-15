package Runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import static Pages.BasePage.closeBrowser;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Testsfortable",
        features = "src/test/resources/Cucumber",
        glue = "StepsDefinitions",
        monochrome = true,
        plugin  = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)

public class Runner {
    @AfterClass
    public static void closeDriver(){
        closeBrowser();
    }
}

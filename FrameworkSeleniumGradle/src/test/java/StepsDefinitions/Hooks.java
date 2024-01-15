package StepsDefinitions;

import Pages.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks extends BasePage {

    public Hooks() {super(driver);}

    @After
    public static void screenshotFailed(Scenario scenario){
        if(scenario.isFailed()){
            scenario.log("El scenario fallo, por favor referirse a la imegen adjunta");
            final byte[] screenshot = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
    }
}

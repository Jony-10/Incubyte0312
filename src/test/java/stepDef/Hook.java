package stepDef;

import base.Setup;
import base.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.util.Strings;

import static base.Utils.getProperty;

public class Hook extends Setup {
    public static String driverType;
    public static String url;

    @Before
    public void startTest() throws Exception {
        // default browser
        url = Utils.getProperty("baseUrl");
        driverType = Utils.getProperty("browser");

        if (Strings.isNullOrEmpty(driverType)){
            driverType="chrome";
        }
        // default env
      driver = setupBrowser(driverType);
       driver.get(url);
    }

    @After
    public void endTest(Scenario scenario) {
        // happen after each test
        // what happen if test fails? what you will do for the  failing test case? screenshot? logs? ??
        try {
            if (scenario.isFailed()){
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                // embed it in the report.
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        } finally {
            driver.quit();
        }
    }
}
package stepDef;

import base.ConstantString;
import base.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.OutlookLandingPage;

public class OutlookLandingStep extends Setup {
    OutlookLandingPage outlookLandingPage = new OutlookLandingPage(driver);
    @Given("I am at outlook homepage")
    public void iAmAtOutlookHomepage() {
        Assert.assertEquals(driver.getTitle(), ConstantString.OUTLOOK_LANDING_TITLE);
    }

    @When("I click on the Sign In button")
    public void iClickOnTheButton() {
        outlookLandingPage.clickOnSignIn();
    }
}

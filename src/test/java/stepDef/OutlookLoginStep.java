package stepDef;

import base.ConstantString;
import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.OutlookLoginPage;

public class OutlookLoginStep extends Setup {
    OutlookLoginPage outlookLoginPage = new OutlookLoginPage(driver);

    @When("I enter a valid {string} and click on the Next button")
    public void iEnterAValidEmailAndClickOnTheNextButton(String email) {
        outlookLoginPage.enterEmail(email);
        outlookLoginPage.clickOnNext();

    }

    @And("I enter a valid {string} and click on the Submit button")
    public void iEnterAValidPasswordAndClickOnTheSubmitButton(String password) {
        outlookLoginPage.enterPassword(password);
        outlookLoginPage.clickOnNext();

    }


    @And("I select Yes for remember me")
    public void iSelectYesForRememberMe() {
        outlookLoginPage.clickOnNext();
    }

    @Then("Outlook sign in page is displayed")
    public void outlookSignInPageIsDisplayed() {
        Assert.assertEquals(driver.getTitle(), ConstantString.OUTLOOK_SIGN_IN_TITLE);
    }
}

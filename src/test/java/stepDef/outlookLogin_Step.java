package stepDef;

import base.ConstantString;
import base.Setup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.outlookLoginPage;

public class outlookLogin_Step extends Setup {
    outlookLoginPage outlookLoginPage = new outlookLoginPage(driver);

    @When("I enter a valid {string} and click on the Submit button")
    public void iEnterAValidEmailAndClickOnTheNextButton(String value) {
        outlookLoginPage.setInputFieldValue(value);
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

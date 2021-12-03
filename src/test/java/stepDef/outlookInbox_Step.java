package stepDef;

import base.Setup;
import base.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.outlookInboxPage;

public class outlookInbox_Step extends Setup {
    outlookInboxPage outlookInboxPage = new outlookInboxPage(driver);

    @Then("New mail page should be displayed in screen")
    public void newMailModalShouldBeDisplayedInScreen() {
        Assert.assertEquals(outlookInboxPage.sendIconCount(), 1);
    }


    @And("I enter {string}, {string}, {string} into respective fields")
    public void iEnterIntoRespectiveFields(String recipientEmail, String subject, String body) {
        outlookInboxPage.inputRecipientEmail(recipientEmail);
        outlookInboxPage.inputMailSubject(subject);
        outlookInboxPage.inputMailBody(body);
    }

    @When("I click on the Compose Button")
    public void iClickOnTheComposeButton() {
        outlookInboxPage.clickOnComposeButton();
        outlookInboxPage.waitForComposePageLoad();
    }

    @Then("Outlook inbox page should be displayed")
    public void outlookInboxPageShouldBeDisplayed() {
        Assert.assertEquals(driver.getTitle().indexOf("Mail"), 0);
    }

    @Then("I verify {string}, {string}, {string} fields value based on my last input")
    public void iVerifyFieldsValueBasedOnMyLastInput(String recipientEmail, String subject, String body) {
        Assert.assertEquals(outlookInboxPage.recipientEmailText(), recipientEmail);
        Assert.assertEquals(outlookInboxPage.emailSubjectText(), subject);
//        Assert.assertEquals(outlookInboxPage.emailBodyText(), body);
    }
}

package stepDef;

import base.Setup;
import io.cucumber.java.en.And;
import org.testng.Assert;
import pageObject.OutlookSentItemsPage;

public class OutlookSentItemsStep extends Setup {
    OutlookSentItemsPage sentItemsPage = new OutlookSentItemsPage(driver);

    @And("I verify the last mail {string} in Sent Item is the one that I just sent")
    public void iVerifyTheLastMailInSentItemIsTheOneThatIJustSent(String subject) {
        sentItemsPage.clickOnSentItemsLink();
        sentItemsPage.clickOnFirstMail();
        Assert.assertEquals(sentItemsPage.getMailSubject(), subject);
    }
}

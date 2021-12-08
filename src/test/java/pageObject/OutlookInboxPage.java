package pageObject;

import base.Setup;
import base.Utils;
import base.XpathStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutlookInboxPage extends Setup {

    public OutlookInboxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }

    @FindBy(xpath = XpathStrings.NEW_MAIL_BUTTON)
    WebElement composeButton;

    @FindBy(xpath = XpathStrings.TO_INPUT_FIELD)
    WebElement recipientEmailAddressInput;

    @FindBy(xpath = XpathStrings.SUBJECT_INPUT_FIELD)
    WebElement emailSubjectInputField;

    @FindBy(xpath = XpathStrings.BODY_INPUT_FIELD)
    WebElement emailBodyInput;



    public void clickOnComposeButton() {
        composeButton.click();
    }



    public void waitForComposePageLoad() {
        Utils.waitForElementDisplayed(recipientEmailAddressInput, 2);
    }

    public int sendIconCount() {
        return driver.findElements(By.xpath(XpathStrings.SEND_BUTTON)).size();
    }

    public void clickOnSendButton(){
        driver.findElement(By.xpath(XpathStrings.SEND_BUTTON)).click();
        Utils.waitForElementInvisibility(XpathStrings.SEND_BUTTON);
    }

    public void inputRecipientEmail(String email) {
        Utils.clearAndSendKeys(recipientEmailAddressInput, email);
    }

    public void inputMailSubject(String subject) {
        Utils.clearAndSendKeys(emailSubjectInputField, subject);
    }

    public void inputMailBody(String mailBody) {
        Utils.clearAndSendKeys(emailBodyInput, mailBody);
    }

    public String recipientEmailText() {
        return recipientEmailAddressInput.getAttribute("value");
    }

    public String emailSubjectText() {
        return emailSubjectInputField.getAttribute("value");
    }

    public String emailBodyText() {
        return emailSubjectInputField.getText();
    }
}

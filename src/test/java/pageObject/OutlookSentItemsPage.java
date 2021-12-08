package pageObject;

import base.Setup;
import base.XpathStrings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutlookSentItemsPage extends Setup {

    public OutlookSentItemsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }

    @FindBy(xpath = XpathStrings.SENT_ITEMS_FIRST_MAIL)
    WebElement firstMailSentItems;

    @FindBy(xpath = XpathStrings.SENT_ITEMS_FIRST_MAIL_SUBJECT)
    WebElement mailSubject;

    @FindBy(xpath = XpathStrings.SENT_ITEMS_LINK)
    WebElement sentItemsLink;



    public void clickOnFirstMail() {
        firstMailSentItems.click();
    }

    public String getMailSubject() {
        return mailSubject.getText();
    }

    public void clickOnSentItemsLink() {
        sentItemsLink.click();
    }

}

package pageObject;

import base.Setup;
import base.Utils;
import base.XpathStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class outlookLoginPage extends Setup {

    public outlookLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }

    @FindBy(xpath = XpathStrings.INPUT_BOX_GENERAL)
    WebElement inputBoxGeneral;

    @FindBy(xpath = XpathStrings.SUBMIT_BUTTON_GENERAL)
    WebElement nextButton;

    public void clickOnNext() {
        Actions action = new Actions(driver);
        action.moveToElement(nextButton).click().build().perform();
    }

    public void setInputFieldValue(String input) {
        if(input.contains(".com")){
            Utils.waitForElementVisibility(XpathStrings.OUTLOOK_SIGNUP_LINK);
        }else Utils.waitForElementVisibility(XpathStrings.OUTLOOK_FORGET_PASSWORD);

        Utils.clearAndSendKeys(inputBoxGeneral, input);
    }

}

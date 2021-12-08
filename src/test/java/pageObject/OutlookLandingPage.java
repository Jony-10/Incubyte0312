package pageObject;

import base.Setup;
import base.XpathStrings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutlookLandingPage extends Setup {

    public OutlookLandingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        Setup.driver = driver;
    }

    @FindBy(xpath = XpathStrings.SIGN_IN_BUTTON)
    WebElement signInButton;

    public void clickOnSignIn(){signInButton.click();}

}

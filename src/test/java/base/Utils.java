package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Utils extends Setup {


    public static void clearAndSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public static void waitForElementVisibility(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(xpath))));
    }

    public static void waitForElementInvisibility(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath(xpath))));
    }

    public static String getProperty(String Key) throws Exception {
        File file = new File("application.properties");
        FileInputStream fis = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(fis);
        String value = prop.getProperty(Key).toString();
        fis.close();
        return value;
    }

    public static boolean waitForElementDisplayed(WebElement ele, int retryCount) {
        boolean found = false;
        final int max_count = retryCount;
        int count = 0;
        while (!found && count < max_count) {
            try {
                if (ele.isDisplayed()) {
                    found = true;
                    break;
                } else {
                    count++;
                }
            } catch (Exception e) {
                count++;
            }
        }
        return found;
    }



}

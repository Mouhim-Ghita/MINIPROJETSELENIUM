package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTools {
    int timeOut =90;
    public static WebElement webElement;

    public WebElement waitforVisibility(WebDriver driver, String elementname, WebElement elementlocator, Boolean logiftrue){
        WebElement element;
        String msgIftrue = "L'element " + elementname + " est visible";
        String msgIffalse = "L'element " + elementname + " est non visible";
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.withMessage(msgIftrue);
        try{
            element = wait.until(ExpectedConditions.visibilityOf(elementlocator));
            if (logiftrue = true)
                System.out.println(msgIftrue);
        }catch (TimeoutException t){
            System.out.println(msgIffalse);
            throw new NoSuchElementException(msgIffalse);
        }
        return element;
    }

    public void waitandclick(WebDriver driver, WebElement elementlocator){
        WebDriverWait wait = new WebDriverWait(driver,12);
        wait.until(ExpectedConditions.visibilityOf(elementlocator)).click();
    }


    public WebElement waitElementToBeVisible(WebDriver driver,WebElement webElementFindBy) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            webElement = (WebElement) wait.until(ExpectedConditions.visibilityOf(webElementFindBy));
            System.out.println(" ==> The element is Visible");
        } catch (Exception e) {
            System.out.println(" ==> The element " + webElement + " is not Visible after " + timeOut);
        }
        return webElement;
    }

    public WebElement waitElementToBeClickable(WebDriver driver,WebElement webElementFindBy) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            webElement = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(webElementFindBy));
            webElement.click();
            System.out.println(" ==> The element is Clickable");
        } catch (Exception e) {
            System.out.println(" ==> The element " + webElement + " is not Clickable after " + timeOut);
        }
        return webElement;
    }

    public void saisirText(WebDriver driver,WebElement webElementFindBy, String Text, String elementName){
        try {
            waitElementToBeVisible(driver,webElementFindBy).clear();
            waitElementToBeVisible(driver,webElementFindBy).sendKeys(Text);
            System.out.println(" ==> The element was filled with : " + Text + " in the element name : " + elementName);
        } catch (Exception e) {
            System.out.println(" ==> The element " + webElement  + " is not working after " + timeOut);
        }
    }


}

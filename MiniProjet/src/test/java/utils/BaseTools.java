package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTools {
    public WebElement waitforVisibility(WebDriver driver, String elementname, WebElement elementlocator, Boolean logiftrue){
        WebElement element;
        String msgIftrue = "L'element " + elementname + " est visible";
        String msgIffalse = "L'element " + elementname + " est non visible";
        WebDriverWait wait = new WebDriverWait(driver,40);
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


}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTools;

public class MyAccount extends BaseTools {
    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    WebElement boutonOrders;
    @FindBy(xpath = "//a[contains(.,'My Account')]")
    WebElement BoutonMyAccount;

    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void cliquerMyAccount()
    {
        waitandclick(driver,BoutonMyAccount);
        System.out.println("myaccount cliquer");

    }
    public void CliquersurOrder()
    {
        boutonOrders.click();
        System.out.println("Orders cliquer");
    }
}

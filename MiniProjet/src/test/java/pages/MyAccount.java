package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {
    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    WebElement boutonOrders;

    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void CliquersurOrder()
    {
        boutonOrders.click();
    }
}

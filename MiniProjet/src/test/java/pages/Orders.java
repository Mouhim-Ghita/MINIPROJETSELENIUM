package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Orders {
    @FindBy(xpath = "//a[contains(text(),'View')]")
    WebElement boutonView;

    WebDriver driver;

    public Orders(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void cliquersurView()
    {
        boutonView.click();
        System.out.println("view cliquer");
    }
}

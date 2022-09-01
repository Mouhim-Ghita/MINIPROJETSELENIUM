package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseTools;


public class ViewArticles extends BaseTools {

    WebDriver driver;
    String chromepath ="C:\\driver\\chromedriver\\chromedriver.exe";

//Xpath definition
@FindBy(xpath = "//a[text()='Shop']")
WebElement xpathShop;

@FindBy(xpath = " //h4[text()='Product Categories']")
    WebElement Xpath_articles_affiche;
@FindBy(xpath = "//a[text()='JavaScript']")
    WebElement xpath_ClickCatgory;


    public ViewArticles(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickShop(){
        xpathShop.click();
        waitElementToBeClickable(driver, xpathShop);
    }
    public void verifyVisibiliyArticle(){
        waitElementToBeVisible(driver, Xpath_articles_affiche);

    }
    public void clickCategory(){
        xpath_ClickCatgory.click();
        String catName = xpath_ClickCatgory.getText();
        waitElementToBeClickable(driver, xpath_ClickCatgory);
        System.out.println("La catégorie chosie est " +catName);

    }
}

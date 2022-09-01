package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BaseTools;


public class VoirPanier extends BaseTools {

    WebDriver driver;
//xpath
    String url_panier = "https://practice.automationtesting.in/basket/";
    String pro_actual = "JS Data Structures and Algorithm";
    @FindBy(xpath = "//a[contains(text(),'Data')]")
    WebElement xpath_product_added;
    public VoirPanier(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //declaration of constructor


    public void verifyIfImOnBasketPage(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(url_panier,URL);
        System.out.println("On est dans l'espace panier"+"Current URL" +url_panier);
    }

    public void  verifySiArticleChoisiQuiEstAjouteAuPanier() {
        waitElementToBeVisible(driver, xpath_product_added);
        String prod = xpath_product_added.getText();
        Assert.assertTrue( prod.equals(pro_actual),"not ok");
        System.out.println("le produit qu'on ajouté  cest bien  ce lui qu'on a choisi" +prod);


    }
    }


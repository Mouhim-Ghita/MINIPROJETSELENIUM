package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import utils.BaseTools;

public class Panier extends BaseTools {

    //DECLARATION
    WebDriver driver;
    // Xpaths Pavet Panier
    @FindBy(xpath = "//i[@class='wpmenucart-icon-shopping-cart-0']")
    WebElement xpath_button_panier;
    @FindBy(xpath = "//th[text()='Product']")
    WebElement xpath_page_panier;
    @FindBy(xpath = "//td[@class='product-name']/child::a")
    WebElement xpath_articlename;
    @FindBy(xpath="//div[@class='quantity']/child::input")
    WebElement xpath_quantity;
    @FindBy(xpath="//td[@class='product-price']/child::span")
    WebElement xpath_price;
    @FindBy(xpath="//td[@class='product-subtotal']/child::span")
    WebElement  xpath_totalprice;
    @FindBy(xpath = "//a[@title='Remove this item']")
    WebElement xpath_delete_button;

    //Xpaths Baskets Total
    @FindBy(xpath = " //h2[text()='Basket Totals']")
    WebElement xpath_basket_title;
    @FindBy(xpath = " //td[@data-title='Subtotal']/child::span")
    WebElement  xpath_basket_subtotal;
    @FindBy(xpath= "//td[@data-title='Tax']/child::span" )
    WebElement xpath_basket_tax;
    @FindBy(xpath = "//td[@data-title='Total']//child::strong/child::span")
    WebElement xpath_basket_total;

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    WebElement xpath_proceedtocheckout;



    public Panier(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void verifier_pagepanier(){
        waitforVisibility(driver,"page panier",xpath_page_panier,true);
        System.out.println("Page panier verifier");
    }

    public void verifier_panier(String article_name,String article_price,String quantity,
                                String article_totalprice)
    {
        verifier_pagepanier();
        xpath_button_panier.click();
        System.out.println("== V??rification du pavet panier ====");
        AssertJUnit.assertEquals(xpath_articlename.getText(),article_name);
        System.out.println("nom de l'article v??rifier");
        AssertJUnit.assertEquals(xpath_price.getText(),article_price);
        System.out.println("prix de l'article v??rifier");
        System.out.println("Quantit?? :" + xpath_quantity.getAttribute("value"));
        AssertJUnit.assertEquals(xpath_quantity.getAttribute("value"),quantity);
        System.out.println("quantit?? de l'article v??rifier");
        AssertJUnit.assertEquals(xpath_totalprice.getText(),article_totalprice);
        System.out.println("le prix totale de l'article v??rifier");
        xpath_delete_button.isEnabled();
        System.out.println("Bouton de suppression est affich??");
        xpath_quantity.isEnabled();
        System.out.println("Bouton de quantit?? est affich??");


    }

    public void verifier_basket(String basket_subtotal,String basket_tax,String basket_total){
        System.out.println("=== V??rification du Basket ===");
        waitforVisibility(driver,"Basket Total",xpath_basket_title,true);
        System.out.println("Titre V??rifier");
        AssertJUnit.assertEquals(xpath_basket_subtotal.getText(),basket_subtotal);
        System.out.println("Basket subtotal v??rifier");
        AssertJUnit.assertEquals(xpath_basket_tax.getText(),basket_tax);
        System.out.println("Basket Tax v??rifier");
        AssertJUnit.assertEquals(xpath_basket_total.getText(),basket_total);
        System.out.println("Basket total v??rifier");
    }

    public void verifier_buttoncheckout(){
        xpath_proceedtocheckout.isEnabled();
        System.out.println("Boutton Proceed to checkout v??rifier");
    }


}

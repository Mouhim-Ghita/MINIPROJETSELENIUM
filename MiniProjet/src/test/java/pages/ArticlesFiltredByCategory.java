package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BaseTools;


public class ArticlesFiltredByCategory extends BaseTools {

    WebDriver driver;


    //xpathDefinitions
    String url_categ_choisi  = "https://practice.automationtesting.in/product-category/javascript/";
    @FindBy(xpath = "//img[@class='attachment-shop_catalog size-shop_catalog wp-post-image']")
    WebElement xpath_img;
    @FindBy(xpath = "//h3")
    WebElement xpath_libelle;
    @FindBy(xpath = "//span[@class='price']")
    WebElement xpath_prix;
    @FindBy(xpath = "//h3[contains(text(),'Data')]")
    WebElement xpath_article_name;
    @FindBy(xpath = "//h3[text()='JS Data Structures and Algorithm']/parent::a/following-sibling::a[text()='Add to basket']")
    WebElement xpath_Add_To_Basket;
    @FindBy(xpath = "//a[text()='View Basket']")
    WebElement xpath_view_basket;
    @FindBy(xpath = "//a[text()='JavaScript']")
    WebElement xpath_categoryname;

    //Constructor
    public ArticlesFiltredByCategory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

//la vérification de la page des articles filtrés par la catégorie choisi
    public void verifyPageArticleWithCategory(){
        String URL = driver.getCurrentUrl();
        String categNmae = xpath_categoryname.getText();
        Assert.assertEquals(url_categ_choisi,URL);

        System.out.println("On est dans la page avec la bonne catégorie"+"Current URL" +url_categ_choisi +"la catégorie chosie"+ categNmae);

    }
//la vérficiation de la visibilité des 3 élements: Image, Libellé, Prix
    public void verifyVisibiliyOfPictureLibellePrice(){
        Boolean img = xpath_img.isDisplayed();
        Assert.assertTrue(img,"img not exist");
        waitElementToBeVisible(driver, xpath_libelle);
        Boolean libelle = xpath_libelle.isDisplayed();
        Assert.assertTrue(libelle,"libellé non visible");
        Boolean prix = xpath_prix.isDisplayed();
        Assert.assertTrue(prix,"le prix n'est pas visible");

    }




    public  void basculerVersArticleSouhaité(){
        Actions action = new Actions(driver);
       // waitElementToBeVisible(driver,xpath_article_name);
        action.moveToElement(xpath_article_name);
        String article = xpath_article_name.getText();
        System.out.println(" hovering the mouse over the article"  +article);



    }

    public void ajouterArticleToBasket(){
        waitElementToBeVisible(driver, xpath_Add_To_Basket);
        System.out.println("le boutton 'Add To Basket est bien visible");
        xpath_Add_To_Basket.click();
        waitElementToBeClickable(driver, xpath_Add_To_Basket);
        String article = xpath_article_name.getText();

        System.out.println("L'article" +" " +article +" "+" est bien ajouté au panier");

    }

    public void verifyVisibiliyViewBasket(){
        waitElementToBeVisible(driver, xpath_view_basket);
        String LinkViewBastet = xpath_view_basket.getText();
        System.out.println("le lien " + " " +LinkViewBastet+ " " + "est bien visible");

    }

    public void clickToViewBasketPourVoirPanier(){
        xpath_view_basket.click();
        waitElementToBeClickable(driver, xpath_view_basket);
        System.out.println("le click sur 'Vew basket' est bien passé, on va se rediriger vers l'espace panier :");

    }

}

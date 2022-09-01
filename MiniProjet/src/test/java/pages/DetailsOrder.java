package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsOrder {
    @FindBy(xpath = "//mark[@class='order-number']")
    WebElement numeroOrdre;

    @FindBy(xpath = "//mark[@class='order-date']")
    WebElement dateCommande;

    @FindBy(xpath = "//td[@class='product-total']")
    WebElement montantCommande;

    @FindBy(xpath = "//table[@class='shop_table order_details']/child::tfoot/child::tr/th[text()='Payment Method:']/following-sibling::td")
    WebElement moyenPaiement;

    @FindBy(xpath = "//table[@class='shop_table customer_details']/child::tbody/child::tr/th[text()='Email:']/following-sibling::td")
    WebElement emailClient;

    @FindBy(xpath = "//table[@class='shop_table customer_details']/child::tbody/child::tr/th[text()='Telephone:']/following-sibling::td")
    WebElement phoneClient;

    WebDriver driver;

    public DetailsOrder(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void verifierNumeroCommande()
    {
       String numero= numeroOrdre.getText();
       System.out.println("le numéro d'ordre existe et sa valeur est: "+ numero);
    }
    public void verifierDateCommande()
    {
        String date= dateCommande.getText();
        System.out.println("la date de commande existe et sa valeur est: "+ date);
    }
    public void verifierMontantCommande()
    {
        String montant=montantCommande.getText();
        System.out.println("le montant totale de cette commande est: "+montant);
    }
    public void verifierMethodePaiement()
    {
        String methode=moyenPaiement.getText();
        System.out.println("la méthode de paiement est: "+ methode);
    }
    public void verifierMail()
    {
        String mail= emailClient.getText();
        System.out.println("le mail du client est: "+mail);
    }
    public void verifierPhone()
    {
        String telephone= phoneClient.getText();
        System.out.println("le numéro du client est: "+telephone);
    }

}

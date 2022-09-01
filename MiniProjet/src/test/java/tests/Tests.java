package tests;

import org.testng.annotations.Test;
import pages.DetailsOrder;
import pages.MyAccount;
import pages.Orders;
import pages.Panier;
import utils.SetUpTeardown;

public class Tests extends SetUpTeardown {

    @Test
    public void TestHistorique()
    {
        System.out.println("lancement bien fait");
        MyAccount monCompte=new MyAccount(driver);
        monCompte.CliquersurOrder();
        Orders order=new Orders(driver);
        order.cliquersurView();
        DetailsOrder detailsOrder=new DetailsOrder(driver);
        detailsOrder.verifierNumeroCommande();
        detailsOrder.verifierDateCommande();
        detailsOrder.verifierMontantCommande();
        detailsOrder.verifierMethodePaiement();
        detailsOrder.verifierMail();
        detailsOrder.verifierPhone();
    }

    @Test
    public void scenarioverifypanier(){
        Panier pagepanier = new Panier(driver);
        pagepanier.verifier_pagepanier();
        pagepanier.verifier_panier("JS Data Structures and Algorithm",
                "₹150.00","1","₹150.00");
        pagepanier.verifier_basket("₹150.00","₹3.00","₹153.00");
        pagepanier.verifier_buttoncheckout();

    }








}

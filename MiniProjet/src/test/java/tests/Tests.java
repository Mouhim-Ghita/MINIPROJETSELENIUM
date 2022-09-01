package tests;

import org.testng.annotations.Test;
import pages.DetailsOrder;
import pages.MyAccount;
import pages.Orders;
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
}

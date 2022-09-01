package tests;

import org.testng.annotations.Test;
import pages.*;
import utils.SetUpTeardown;

public class Tests extends SetUpTeardown {



    @Test
    public void clickShopeinPageShop() {
        ViewArticles art = new ViewArticles(driver);
        ArticlesFiltredByCategory artFiltred = new ArticlesFiltredByCategory(driver);
        VoirPanier panier = new VoirPanier(driver);
        art.clickShop();
        System.out.println("Button 'Shop' was clicked");
        art.verifyVisibiliyArticle();
        System.out.println("les articles en vente sont bien affichés");
        art.clickCategory();
        System.out.println("the category name is selected");
        artFiltred.verifyPageArticleWithCategory();
        artFiltred.verifyVisibiliyOfPictureLibellePrice();
        System.out.println("les 3 éléments : 'Photo', 'Libellé', 'Prix' sont bien visibles");
        artFiltred.basculerVersArticleSouhaité();
        artFiltred.ajouterArticleToBasket();
        artFiltred.verifyVisibiliyViewBasket();
        artFiltred.clickToViewBasketPourVoirPanier();
        panier.verifyIfImOnBasketPage();
        panier.verifySiArticleChoisiQuiEstAjouteAuPanier();
    }

    @Test(priority = 1)
    public void scenarioverifypanier(){
        Panier pagepanier = new Panier(driver);
        pagepanier.verifier_pagepanier();
        pagepanier.verifier_panier("JS Data Structures and Algorithm",
                "₹150.00","1","₹150.00");
        pagepanier.verifier_basket("₹150.00","₹7.50","₹157.50");
        pagepanier.verifier_buttoncheckout();

    }


    @Test(priority = 2)
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

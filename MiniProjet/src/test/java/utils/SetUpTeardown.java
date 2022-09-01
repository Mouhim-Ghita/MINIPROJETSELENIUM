package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class SetUpTeardown {
    @FindBy(xpath = "//input[@name='username']")
    WebElement emailLogin;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordLogin;
    @FindBy(xpath = "//input[@name='login']")
    WebElement boutonLogin;

    public static WebDriver driver;

     @BeforeTest
     public void OpenBrowserAndLogin()
    {
        String driverChrome="src\\test\\java\\Tools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverChrome);
        driver=new ChromeDriver();
        PageFactory.initElements(driver,this);
        driver.get(Constantes.url);
        driver.manage().window().maximize();
        System.out.println("site bien ouvert");
        emailLogin.sendKeys(Constantes.email);
        passwordLogin.sendKeys(Constantes.password);
        boutonLogin.click();

    }
    @AfterTest
    public void Teardown()
    {
        System.out.println("fin des tests");
        driver.close();
    }
}

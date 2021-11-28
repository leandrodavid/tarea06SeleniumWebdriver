package frameworkTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();


    @BeforeSuite
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver",Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Login Successfully")
    public static void loginSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        loginFormPage.enterUserName();
        loginFormPage.enterPassword();
        loginFormPage.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productsPage = new ProductPage(driver);
        Assert.assertEquals(productsPage.getTitle(),"PRODUCTS");
    }

    @Test(testName = "Logout Successfully")
    public static void logoutSuccessfully(){
        driver.get(Utils.BASE_URL);
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        loginFormPage.enterUserName();
        loginFormPage.enterPassword();
        loginFormPage.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productsPage = new ProductPage(driver);
        productsPage.pressMenuButton();
        productsPage.pressLogoutButton();
        Assert.assertTrue(loginFormPage.isLoginPage());
    }


    @Test(testName = "Login with wrong credentials")
    public static void invalidLogin(){
        driver.get(Utils.BASE_URL);
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        loginFormPage.enterInvalidPassword();
        loginFormPage.enterInvalidUserName();
        loginFormPage.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(loginFormPage.getErrorLoginMessage() ,"Epic sadface: Username and password do not match any user in this service");
    }

    @Test(testName = "Add one item to cart")
    public static void verifyItemAdded(){
        driver.get(Utils.BASE_URL);
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        loginFormPage.enterUserName();
        loginFormPage.enterPassword();
        loginFormPage.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ProductPage productsPage = new ProductPage(driver);
        productsPage.addToCartSauceBackpack();
        Assert.assertEquals(productsPage.getCardBadge(),"1");
    }



    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

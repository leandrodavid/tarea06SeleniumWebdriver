package frameworkTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class ProductPage extends PageObject {

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement products_label;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart_SauceBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCart_SauceBoltTShirt;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    private WebElement cart_badge;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burger_menu;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout_link;

    @FindBy(className = "inventory_item")
    private List<WebElement> list_products;

    @FindBy(id = "shopping_cart_container")
    private WebElement shopping_cart;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        return this.products_label.getText();
    }

    public void addToCartSauceBackpack(){
        this.addToCart_SauceBackpack.click();
    }

    public void addToCartSauceBoltTShirt(){
        this.addToCart_SauceBoltTShirt.click();
    }

    public String getCardBadge(){
        return this.cart_badge.getText();
    }

    public void pressMenuButton() {
        this.burger_menu.click();
    }

    public void pressLogoutButton() {
        this.logout_link.click();
    }

   public void pressCardBadge() {
        this.cart_badge.click();
   }

}

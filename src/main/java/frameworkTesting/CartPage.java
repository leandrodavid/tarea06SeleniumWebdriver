package frameworkTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageObject{


    @FindBy(id = "shopping_cart_container")
    WebElement shopping_cart;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement item_name;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPage() {
        return this.shopping_cart.isDisplayed();
    }

    public String getTextItemCart() {
        return this.item_name.getText();
    }
}

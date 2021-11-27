package frameworkTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginFormPage extends PageObject {

    private final String USERNAME = "standard_user";
    private final String PASSWORD = "secret_sauce";
    private final String INVALIDUSERNAME = "invalid";
    private final String INVALIDPASSWORD = "invalid";

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement login_button;

    @FindBy(xpath = "//h3[@data-test= 'error']")
    private WebElement error_message;

    @FindBy(xpath = "//div[@class= 'login_password']/h4")
    private WebElement passwordAllLabel;

    public LoginFormPage(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(){
        this.username.sendKeys(USERNAME);
    }
    public void enterPassword(){
        this.password.sendKeys(PASSWORD);
    }

    public void pressLoginButton(){
        this.login_button.click();
    }

    public String getErrorLoginMessage() {
        return this.error_message.getText();
    }

    public void enterInvalidUserName(){
        this.username.sendKeys(INVALIDUSERNAME);
    }
    public void enterInvalidPassword(){
        this.password.sendKeys(INVALIDPASSWORD);
    }
}

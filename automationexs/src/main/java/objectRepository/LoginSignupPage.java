package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignupPage {

	@FindBy(xpath = "(//input[@name='email'])[1]")
	private WebElement emailField;

	@FindBy(name = "password")
	private WebElement passwordField;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginBtn;

	@FindBy(name = "name")
	private WebElement signupNameField;

	@FindBy(xpath = "(//input[@name='email'])[2]")
	private WebElement signupEmailField;

	public LoginSignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	public WebElement getSignupNameField() {
		return signupNameField;
	}

	public WebElement getSignupEmailField() {
		return signupEmailField;
	}

}

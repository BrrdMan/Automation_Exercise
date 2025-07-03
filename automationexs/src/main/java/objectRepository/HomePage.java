package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(partialLinkText = "Home")
	private WebElement homeLink;

	@FindBy(partialLinkText = "Products")
	private WebElement productsLink;

	@FindBy(partialLinkText = "Cart")
	private WebElement cartLink;

	@FindBy(partialLinkText = "Test Cases")
	private WebElement testCasesLink;

	@FindBy(partialLinkText = "Contact us")
	private WebElement contactUsLink;

	@FindBy(id = "susbscribe_email")
	private WebElement emailSubscriptionField;

	@FindBy(xpath = "//h2[contains(text(),'Subscription')]")
	private WebElement footerHeading;

	@FindBy(xpath = "//div[text()='You have been successfully subscribed!']")
	private WebElement subscriptionSuccessMsg;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getCartLink() {
		return cartLink;
	}

	public WebElement getTestCasesLink() {
		return testCasesLink;
	}

	public WebElement getContactUsLink() {
		return contactUsLink;
	}

	public WebElement getEmailSubscriptionField() {
		return emailSubscriptionField;
	}

	public WebElement getFooterHeading() {
		return footerHeading;
	}

	public WebElement getSubscriptionSuccessMsg() {
		return subscriptionSuccessMsg;
	}

}

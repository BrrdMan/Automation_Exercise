package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {

	@FindBy(xpath = "//h2[text()='Get In Touch']")
	private WebElement heading;

	@FindBy(name = "name")
	private WebElement nameField;

	@FindBy(name = "email")
	private WebElement emailField;

	@FindBy(name = "subject")
	private WebElement subjectField;

	@FindBy(id = "message")
	private WebElement messageField;

	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileInput;

	@FindBy(name = "submit")
	private WebElement submitBtn;

	@FindBy(xpath = "(//div[contains(text(),'Success!')])[1]")
	private WebElement successMsg;

	@FindBy(xpath = "//span[contains(text(),'Home')]")
	private WebElement homeLink;

	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getHeading() {
		return heading;
	}

	public WebElement getNameField() {
		return nameField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getSubjectField() {
		return subjectField;
	}

	public WebElement getMessageField() {
		return messageField;
	}

	public WebElement getFileInput() {
		return fileInput;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

}

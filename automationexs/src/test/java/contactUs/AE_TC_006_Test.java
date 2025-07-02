package contactUs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.ContactUsPage;
import objectRepository.HomePage;

@Listeners(ListenerUtility.class)
public class AE_TC_006_Test extends BaseClass {

	@Test
	public void contactUsForm() throws EncryptedDocumentException, FileNotFoundException, IOException {
		HomePage hp = new HomePage(driver);
		hp.getContactUsLink().click();

		ContactUsPage cup = new ContactUsPage(driver);

		Assert.assertEquals(cup.getHeading().getText(), "GET IN TOUCH", "Heading is not displayed as expected");

		cup.getNameField().sendKeys(eUtil.getStringValueFromExcel("Contact Us", 1, 0));
		cup.getEmailField().sendKeys(eUtil.getStringValueFromExcel("Contact Us", 1, 1));
		cup.getSubjectField().sendKeys(eUtil.getStringValueFromExcel("Contact Us", 1, 2));
		cup.getMessageField().sendKeys(eUtil.getStringValueFromExcel("Contact Us", 1, 3));
		cup.getFileInput().sendKeys(eUtil.getStringValueFromExcel("Contact Us", 1, 4));
		cup.getSubmitBtn().click();

		wbUtil.switchToAlert().accept();

		Assert.assertEquals(cup.getSuccessMsg().getText(), "Success! Your details have been submitted successfully.",
				"Success message not displayed");

		cup.getHomeLink().click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationexercise.com/",
				"Unsuccessful in redirecting to Homepage");
	}

}

package home;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import objectRepository.HomePage;

public class AE_TC_010_Test extends BaseClass {

	@Test
	public void emailSubscription() throws FileNotFoundException, IOException {
		HomePage hp = new HomePage(driver);

		WebElement footerHeading = hp.getFooterHeading();
		wbUtil.scrollTo(footerHeading);

		Assert.assertEquals(footerHeading.getText(), "SUBSCRIPTION");
		hp.getEmailSubscriptionField().sendKeys(fUtil.getDataFromProperties("email"), Keys.ENTER);

		Assert.assertTrue(hp.getSubscriptionSuccessMsg().isDisplayed());
	}

}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.ListenerUtility;
import objectRepository.HomePage;

@Listeners(ListenerUtility.class)
public class AE_TC_007_Test extends BaseClass {

	@Test
	public void verifyTestCasesPage() {
		HomePage hp = new HomePage(driver);

		hp.getTestCasesLink().click();

		Assert.assertEquals(driver.getTitle(), "Automation Practice Website for UI Testing - Test Cases",
				"Test Cases page is not displayed properly");
	}

}

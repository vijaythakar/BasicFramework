package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	SoftAssert softAssert = new SoftAssert();
	
	 @Test
	public void LoginWithWrongEmailPasswordTest() throws InterruptedException {

		lp.login(df.incorrectEmail, df.incorrectPassword);
		//softAssert will help if we encounter any error so it will jump to next Test Case if we have.
		softAssert.assertEquals(df.globalErr, lp.readGlobalErr());
		//Assert.assertEquals(globalErr,lp.readGlobalErr());

	}

	 @Test
	public void loginWithInvalidEmailTest() throws InterruptedException {
		lp.login(df.inValidEmail, df.incorrectPassword);
		softAssert.assertEquals(df.emailSpecialCharErr, lp.readErr());
		//Assert.assertEquals(emailSpecialCharErr, lp.readErr());

	}

	 @Test
	public void loginWithEmptyEmailTest() throws InterruptedException {

		lp.login("", "afasdfasdf");
		Assert.assertEquals(df.emptyEmailErr, lp.readErr());

	}

	@Test
	public void loginWithEmptyPasswordTest() throws InterruptedException {
		lp.login("dafafaf", "");
		Assert.assertEquals(df.emptyPassErr, lp.readErr());

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		lp.openBrowser();
		lp.openScotiaBankLoginPage();
		
	}

	@AfterMethod
	public void afterMethod() {
		lp.closeBrowser();
	}

}

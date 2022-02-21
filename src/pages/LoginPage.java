package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginPage {
	WebDriver driver;

	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("E:\\testing\\prop.properties"); //we can use excel in place of properties file
		Properties prop = new Properties();
		prop.load(f);
		String browser = prop.getProperty("browser");

		// String browser = "Chrome"; //this value we'll read from data files....excel,
		// properties
		// global variable for all drivers
		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.ie.driver", "E:\\SeleniumJars\\iedriver.exe");
			driver = new InternetExplorerDriver();
		}

	}

	public void openScotiaBankLoginPage() {
		driver.get(
				"https://auth.scotiaonline.scotiabank.com/online?oauth_key=rzpxSiekUw8&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoicnpweFNpZWtVdzgiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTY0MjAwNjMzOSwiaWF0IjoxNjQyMDA1MTM5LCJqdGkiOiI2NmQ3NDE5OS05ZDI5LTQzZWQtYWY1OC1kNjkzOWI0ZTBmMzciLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.X_Gea2HoHgnGjbkm1dSvn-WP1-dnokY3wPBnnHKQyFsDW5WRHmr9sFa3KQGSucrQuT7GDXZVjHqXeco_-COXpFCqw2MlmFCdHYW2Xod_Sof_QzdpzBCetJedsyq43K5l3xNn9kl5Ja2r7uXaW2gNoUMwYnakluBuxgFPJwiV0fmB9l5hN8Vv-iGuq4-yXlcN5Ge20TzYpx1AXJ3a63dNG6AphaUTdd8ZclfWnYgTZLZTKZqSx2QPFe059K43NVa-MBG3saAM-XjKfJGZhaSPaC7HTWxlDbepRl6mtRbyzyANCcy0GAGXdOume5MqKdXUWu75jdilTRbFu0I8WdCiFg&preferred_environment=");
		// implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	public void closeBrowser() {
		driver.close();

	}

	public void login(String email, String password) throws InterruptedException {
		// enter wrong email
		driver.findElement(By.id("usernameInput-input")).sendKeys(email);
		// enter wrong pass
		driver.findElement(By.id("password-input")).sendKeys(password);
		// click on login
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(2000);
	}

	public String readGlobalErr() {
		String actualErrMsg = driver.findElement(By.xpath("//div[@id='globalError']/div/div[2]")).getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;
	}

	public String readErr() {
		String actualErrMsg = driver.findElement(By.xpath("//div[@class='Error__text']")).getText();
		System.out.println(actualErrMsg);
		return actualErrMsg;

	}

}

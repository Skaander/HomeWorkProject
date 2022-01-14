package AuthenticationTwoPointZero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.UtilitiesMethods;

public class AuthenticationDeuxPointZero {

	WebDriver driver;

	WebElement UsernameField;

	WebElement PasswordField;

	WebElement LoginBtn;

	@Before

	public void AccesToLoginPage() {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		String url = "http://the-internet.herokuapp.com/";

		driver = new ChromeDriver();

		driver.get(url);

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='Form Authentication']")).click();

		UsernameField = driver.findElement(By.xpath("//input[@id='username']"));

		PasswordField = driver.findElement(By.xpath("//input[@id='password']"));

		LoginBtn = driver.findElement(By.xpath("//button[@type='submit']"));

	}

	@Test

	public void wrongPassword() {

		UtilitiesMethods.LoginTest(driver, "tomsmith", "Admin", UsernameField, PasswordField, LoginBtn);

	}

	@Test
	public void correctPassword() {

		UtilitiesMethods.LoginTest(driver, "tomsmith", "SuperSecretPassword!", UsernameField, PasswordField, LoginBtn);

	}

	@Test

	public void correctPasswordAndLogout() {

		UtilitiesMethods.LoginTest(driver, "tomsmith", "SuperSecretPassword!", UsernameField, PasswordField, LoginBtn);

		WebElement LogoutBtn = driver.findElement(By.xpath("//a[@class='button secondary radius']"));

		LogoutBtn.click();

	}
	
	@After
	
	public void closeBrowz() {
		
		driver.close();
		driver.quit();
	}

}

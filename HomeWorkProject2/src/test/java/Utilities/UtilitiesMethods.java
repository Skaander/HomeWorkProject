package Utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilitiesMethods {

	static public void LoginTest(WebDriver driver, String username, String password, WebElement object1,
			WebElement object2, WebElement object3) {

		object1.sendKeys(username);

		
		object2.sendKeys(password);


		object3.click();

		String ActualURL = driver.getCurrentUrl();

		String ExpectedURL = "http://the-internet.herokuapp.com/secure";

		Assert.assertEquals(ExpectedURL, ActualURL);

	}

}

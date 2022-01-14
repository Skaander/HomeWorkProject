package SecondHomework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class AlertTest {

	WebDriver driver;

	Actions actions;

	@Test

	public void testAlert() {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		String url = "http://the-internet.herokuapp.com/";

		driver = new ChromeDriver();

		actions = new Actions(driver);

		driver.get(url);

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[normalize-space()='Key Presses']")).click();

		WebElement TextField = driver.findElement(By.xpath("//body"));

		TextField.click();

		TextField.sendKeys("a");

		TextField.sendKeys(Keys.ENTER);

		String ActualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();

		String ExpectedResult = "You entered: ENTER";

		Assert.assertEquals(ExpectedResult, ActualResult);

		driver.close();

		driver.quit();

	}
}

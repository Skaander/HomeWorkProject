package TestSteps;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import LoginHelpers.LoginControllers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CorrectAuthenticationSteps {

	WebDriver driver;

	LoginControllers login;

	@Given("^I access to Orange  login site$")
	public void i_access_to_orange_login_site() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		String url = "http://the-internet.herokuapp.com/";

		driver = new ChromeDriver();

		driver.get(url);

		driver.manage().window().maximize();

	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {

		login = new LoginControllers(driver);

		login.LoginFeature(username, password);
	}

	@Then("^I want to see an error message$")
	public void i_want_to_see_an_error_message() throws Throwable {

		String ActualResult = driver.findElement(By.xpath("//div[@id='flash']")).getText();

		if (ActualResult.contains("invalid")) {

			Assert.assertTrue(true);
		} else {

			Assert.assertFalse(false);

		}
	}

	@When("^User enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void users_enters_and(String username, String password) throws Throwable {
		login = new LoginControllers(driver);

		login.LoginFeature(username, password);
	}

	@Then("^I want to land on my Homepage$")
	public void i_want_to_land_on_my_homepage() throws Throwable {

		String ActualURL = driver.getCurrentUrl();

		String ExpectedURL = "http://the-internet.herokuapp.com/secure";

		Assert.assertEquals(ActualURL, ExpectedURL);

	}

	@And("^I want to logout$")
	public void i_want_to_logout() throws Throwable {
		driver.findElement(By.xpath("//a[@class='button secondary radius']")).click();

	}

	@After

	public void CloseBrows() {

		driver.quit();

		driver.close();
	}
}

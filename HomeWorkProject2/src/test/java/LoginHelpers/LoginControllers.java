package LoginHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginControllers {

	@FindBy(xpath = "//input[@id='username']")

	WebElement UsernameField;

	@FindBy(xpath = "//input[@id='password']")
	WebElement PasswordField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement LoginBtn;

	WebDriver driver;

	public LoginControllers(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void EnterUsername(String Username) {

		UsernameField.clear();

		UsernameField.sendKeys(Username);
	}

	public void EnterPassword(String Password) {

		PasswordField.clear();

		PasswordField.sendKeys(Password);
	}

	public void ClickOnLogin() {

		LoginBtn.click();

	}

	public void LoginFeature(String Username, String Password) {

		this.EnterUsername(Username);
		this.EnterPassword(Password);
		this.ClickOnLogin();
	}
}

package pages;

import org.openqa.selenium.By;

import com.vt.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage{

	private final By textboxUsername = By.name("username");
	private final By textboxPassword = By.name("password");
	private final By buttonLogin = By.xpath("//*[contains(@type,'submit')]");

	public OrangeHRMLoginPage enterUserName(String username) {
		

		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE, "Username");
		return this;
	}

	public OrangeHRMLoginPage enterPassWord(String password) {
		sendKeys(textboxPassword ,password, WaitStrategy.PRESENCE, "Password");
		return this;
	}

	public OrangeHRMHomePage clickLogin() {
		click(buttonLogin, WaitStrategy.PRESENCE, "Login Button");
		return new OrangeHRMHomePage();
	}

	public OrangeHRMHomePage getTitle() {
		return new OrangeHRMHomePage();
	}

}

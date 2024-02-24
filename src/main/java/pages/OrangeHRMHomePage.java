package pages;

import org.openqa.selenium.By;

import com.vt.drivers.DriverManager;
import com.vt.enums.WaitStrategy;



public final class OrangeHRMHomePage extends BasePage {
	
	private final By linkWelcome = By.xpath("//header//*[contains(text(),'Dashboard')]");
	private final By linkLogout = By.xpath("//a[text()='Logout']");
	private final By dashboardUsername = By.xpath("//div[@class='oxd-topbar-header-userarea']");
	
	
	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome, WaitStrategy.PRESENCE,"Welcome link");
		return this;
	}
	
	
			
	public OrangeHRMHomePage clickLogout() {
		click(linkLogout, WaitStrategy.CLICKABLE,"Logout button");
		return new OrangeHRMHomePage();
	}
	
	public OrangeHRMHomePage clickDashboardUsername() {
		click(dashboardUsername, WaitStrategy.CLICKABLE,"DashboardUsername");
		return new OrangeHRMHomePage();
	}
	
	public  String getTitle() {
		return DriverManager.getDriver().findElement(linkWelcome).getText();
	}
	
	//wait.until(d->d.findElement(link_logout).isEnabled()); //Java 8 way
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vt.drivers.DriverManager;
import com.vt.enums.WaitStrategy;
import com.vt.factories.ExplicitWaitFactory;

public class BasePage {
	
	protected void click(By by, WaitStrategy waitstrategy,String elementname) {
		WebElement element =ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.click();
		
		System.out.println(" is clicked");
		
	}
	
	protected void sendKeys(By by, String value, WaitStrategy waitstrategy,String elementname) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(waitstrategy, by);
		element.sendKeys(value);
		System.out.println("useris entered successfully ");
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

}

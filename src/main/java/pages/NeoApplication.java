package pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.vt.drivers.DriverManager;

public class NeoApplication {
	
    private final By textboxUsername = By.xpath("//input[@id='username']");
    private final By textboxPassword = By.xpath("//input[@id='password']");
    private final By buttonLogin = By.xpath("//*[@data-action-button-primary='true']");

    public void LoginIntoApplication(String UserName, String Passwprd) throws InterruptedException {
    	DriverManager.getDriver().manage().window().maximize();
    	DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    	DriverManager.getDriver().findElement(textboxUsername).sendKeys(UserName);
    	 Thread.sleep(2000);
    	DriverManager.getDriver().findElement(textboxPassword).sendKeys(Passwprd);
        Thread.sleep(2000);
        DriverManager.getDriver().findElement(buttonLogin).click();

    }
    
    
    

}

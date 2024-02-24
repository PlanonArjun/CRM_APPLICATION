package pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.vt.drivers.DriverManager;

public class NeoApplcationDashboard {
	
	private final By walletsCoinNames = By.xpath("//*[contains(@class,'coin-title')]");
	
	private final By walletsCoinAmounts = By.xpath("//*[contains(@class,'coinval-width')]");
	
	
	public void cryptoWalletsDetails() throws Exception {
		
		Thread.sleep(6000);
		
		List<WebElement> coinNames = DriverManager.getDriver().findElements(walletsCoinNames);
		
		List<WebElement> coinAmount = DriverManager.getDriver().findElements(walletsCoinAmounts);
		
		Map<String, String> walletDetails = new HashMap<String, String>(coinNames.size());
		
		for(int i =0;i<coinNames.size();i++) {
			walletDetails.put(coinNames.get(i).getText(), coinAmount.get(i).getText());
		
		}
		System.out.println("Crypto Wallets :- ");
		walletDetails.forEach((key, value) -> System.out.println(key + " : " + value));
		//System.out.println("Crypto Wallets : "+walletDetails);
	}

}

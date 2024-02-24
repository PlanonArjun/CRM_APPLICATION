package com.vt.objectRepository;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestVideo {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://skillrary.com/core-java-for-selenium-training");
		driver.findElement(By.xpath("//a[@class= 'close_cookies']")).click();
		
		Thread.sleep(2000);
		//to know its a frame, right click, inspect, u will get an option VIEW FRAME SOURCE
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//*[@class= 'PlayButton_module_playIcon__fc6bec57']")).click();
		Thread.sleep(5000);
		
		Actions a = new Actions(driver);
		Thread.sleep(3000);
		
		// Locate the pause button element
        WebElement videoPlayer = driver.findElement(By.xpath("//div[@id='vp-preview']"));
		// Move the mouse to hover over the element
		a.moveToElement(videoPlayer).perform();
		WebElement pauseBtn= driver.findElement(By.xpath("//*[@class= 'PlayButton_module_pauseIcon__fc6bec57']"));
		Thread.sleep(3000);
		//a.moveToElement(pauseBtn).build().perform(); //build acts a bridge/mediator
		Thread.sleep(3000);
		pauseBtn.click();
		
		driver.switchTo().defaultContent();//just come out of the frame for the video to pause
		Thread.sleep(2000);
		
		//driver.close();	
		}
}	
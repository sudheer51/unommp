package org.iitwforce.healthcare.lib;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MMPLibrary {
	
	WebDriver driver;
	  
	public MMPLibrary(WebDriver driver)
	{
		this.driver= driver;
	}
	 
	public void navigation(String tabName)
	{
		driver.findElement(By.xpath("//a[contains(.,'"+tabName+"')]")).click();
	}
	 
	public void launchApplication(String url )
	{
		 driver.get(url);
	}
	public String handleAlert()
	{
		Alert alrt = driver.switchTo().alert();
		String successMsg = alrt.getText();
		alrt.accept();
		return successMsg;
	}
	 
}

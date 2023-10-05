package org.iitwforce.healthcare.lib;

import java.util.HashMap;
import java.util.Random;

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
		System.out.println("The success message is :"+successMsg);   //instead of thread.sleep
		alrt.accept();
		return successMsg;
	}
	
	public static String randomPTheight() {
		Random rand = new Random();
		String str = "";
		int value = 48+rand.nextInt(2);  //49,50----- will choose no between 1,2
		char digit1 = (char)value;
			
		value = 48+rand.nextInt(3);    //49,50,51---will choose no between 1,2,3
		char digit2 = (char)value;
		
		return str+digit1+digit2;    //Almost height is 213 cms
	}
	 
}

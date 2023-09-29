package org.mmp.patientmodule.pages;

import org.iitwforce.healthcare.lib.MMPLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MessagesPage {

	WebDriver driver;
	public MessagesPage(WebDriver driver)
	{
		this.driver= driver;
	}
	public String sendMessages(String reason,String subject)
	{
		driver.findElement(By.id("subject")).sendKeys(reason);
		driver.findElement(By.id("message")).sendKeys(subject);
		driver.findElement(By.xpath("//input[@value='Send']")).click();
		MMPLibrary mmpLibrary = new MMPLibrary(driver);
		String text = mmpLibrary.handleAlert();
		return text;
	}
}

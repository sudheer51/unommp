package org.mmp.adminmodule.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
	
	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void acceptingNewUser()
	{
	//System.out.println("in profilepage");
	Select select = new Select(driver.findElement(By.xpath("//select[@name='approval']")));
	select.selectByVisibleText("Accepted");
	driver.findElement(By.xpath("//input[@value='Submit']")).click();	
	}

}
